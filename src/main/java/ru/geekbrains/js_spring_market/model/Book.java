package ru.geekbrains.js_spring_market.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "page_count")
    private Integer page_count;

    //доступна или нет, должно зависеть от количества на складе (ЖЦ?)
    @Column (name = "availability")
    private boolean availability;

    @Column (name = "cost")
    private Integer cost;

    // Добавить ManyToMany
    // @Column (name = "category")


    //надо будет поменять в дальнейшем на ManyToMany, может быть несколько авторов у книги
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
