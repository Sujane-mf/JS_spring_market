package ru.geekbrains.js_spring_market.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column (name = "user_id")
    private Long user_id;
    @Column (name = "itemCount")
    private Long itemCount;
    @Column (name = "sum")
    private Long sum;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<Book> items;


    //должна мапиться с заказами

}
