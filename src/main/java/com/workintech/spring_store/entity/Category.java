package com.workintech.spring_store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category", schema = "store")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    //Kitaplar many kısmı , bir liste halin de tutmamız gerekir.
    //One to Many Relation da bi taraftan JoinColumn ile bağlandı ise, diğer taraftan da yazmayın.
    //Bunun yerine mappedBy kullan. mappedBy = "category" -> sen kategoride maplendin demek.
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
        mappedBy = "category")
    private List<Book> books;
}
