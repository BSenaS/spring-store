package com.workintech.spring_store.controller;

import com.workintech.spring_store.document.CategoryLog;
import com.workintech.spring_store.dto.BookResponse;
import com.workintech.spring_store.dto.CategoryResponse;
import com.workintech.spring_store.entity.Book;
import com.workintech.spring_store.entity.Category;
import com.workintech.spring_store.service.BookService;
import com.workintech.spring_store.service.CategoryLogService;
import com.workintech.spring_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    //Kendi sınıfının reposu haricin de başka repolarla konusma ihtiyacı duyarsan, servicelerini çağır ki kod tekrarından kurtul.
    private CategoryService categoryService;
    private CategoryLogService categoryLogService;
    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, CategoryLogService categoryLogService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.categoryLogService = categoryLogService;
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
        //41.Satır düzgün çalıştıysa kategori bulunmuştur demek , onun için bu satırdan sonra log tutabiliriz.
        //Yeni bir categoryLog instancesi yaratıp gerekli alanları dolduruyoruz sonra save ediyoruz.
        CategoryLog categoryLog = new CategoryLog();
        categoryLog.setCategoryId(category.getId());
        categoryLog.setMessage("Category found successfully with given Id: " + category.getId());
        categoryLog.setCreationTime(Instant.now());
        categoryLogService.save(categoryLog);

        book.setCategory(category);
        category.getBooks().add(book);

        return bookService.save(book);
    }

    
}
