package com.workintech.spring_store.controller;

import com.workintech.spring_store.dto.BookResponse;
import com.workintech.spring_store.dto.CategoryResponse;
import com.workintech.spring_store.entity.Book;
import com.workintech.spring_store.entity.Category;
import com.workintech.spring_store.service.BookService;
import com.workintech.spring_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    //Kendi sınıfının reposu haricin de başka repolarla konusma ihtiyacı duyarsan, servicelerini çağır ki kod tekrarından kurtul.
    private CategoryService categoryService;


    @Autowired
    public BookController(CategoryService categoryService, BookService bookService) {
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> findAllBooks(){
        return bookService.getAll();
    }


    //long category_id , Book book gelecek
    //ilgili kategoriyi bul ve kitapla eşleştirip veritabanına kaydet.
    //Eğer logic küçük ise bunu controller da tutabiliriz.Ama logic büyük ise, logic kısmını service'e taşımak daha mantıklı.
    @PostMapping("/{category_id}")
    public BookResponse save(@PathVariable long category_id,
                             @RequestBody Book book){
        Category category = categoryService.findById(category_id);
        book.setCategory(category);
        category.getBooks().add(book);

        return bookService.save(book);
    }

    
}
