package ru.geekbrains.js_spring_market.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "name")
    private String surname;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;


}
