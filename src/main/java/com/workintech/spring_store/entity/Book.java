package com.workintech.spring_store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book", schema = "store")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    //Bir kitabın sadece 1 kategorisi olabilir. 1 to Many'nin
    //Bura da kitap many olan kısım ve biz One'a yani Categorye gidiyoruz.
    //Bir kitap silindimi, categorysi silinmelimi ? (Hayır)
    //Join Column Kısmına Foreign Key yazılır (book içerisin de category_id tanımlamıştım DB'DE)
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    //Kitabın bir çok yazarı olabilir.
    //Many to Many iliskiler de JoinColumn yerine JoinTable kullanırız.
    //JoinTable ile Junction table bağlantısı yapılır
    //sonra join columns ile booktan -> book_author'a , inverse ile book_authordan -> authora gidilir.


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "book_author", schema = "store",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

}
