package com.workintech.spring_store.service;

import com.workintech.spring_store.dto.CategoryResponse;
import com.workintech.spring_store.entity.Category;
import com.workintech.spring_store.exception.StoreException;
import com.workintech.spring_store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    //Bu objeyi hard olarak baglama, AutoWired ile dependency injection yap.İhtiyac anın da spring kullansın.
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //orElseThrow kullanmadan normal bir hata fırlatma senaryosu
    @Override
    public CategoryResponse findByTitle(String title) {
        Optional<Category> categoryOptional = categoryRepository.findByTitle(title);
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            return new CategoryResponse(category.getTitle());
        }
        throw new StoreException("Category with given title is not exist" + title,
                HttpStatus.NOT_FOUND);
    }

    //Bura da categoryOptional' a .get yapmamızın sebebi Optional'ın içerisindeki değere ulaşmaktır.
    //if SOrgusu ile öncelikle .isPresent mi diye bakılırki herhangi bir NullPointerException hatasından kaçınalım.
    //Bura da orElseThrow ile hata fırlatma örneği kullandık.
    //orElseThrow: categoryOptional'ı bulursam get edip döner, bulamazsa yeni bir store exception hatası fırlat.
    @Override
    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.orElseThrow(() ->
                new StoreException("Category with given id is not exist: " + id,
                        HttpStatus.NOT_FOUND));
    }

    @Override
    public CategoryResponse save(Category category) {
        Category savedCategory = categoryRepository.save(category);
        return new CategoryResponse(savedCategory.getTitle());
    }


}
