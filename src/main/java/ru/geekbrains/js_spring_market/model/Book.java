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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPage_count() {
        return page_count;
    }

    public boolean isAvailability() {
        return availability;
    }

    public Integer getCost() {
        return cost;
    }

    public Author getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPage_count(Integer page_count) {
        this.page_count = page_count;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    // Добавить ManyToMany
    // @Column (name = "category")


    //надо будет поменять в дальнейшем на ManyToMany, может быть несколько авторов у книги
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
