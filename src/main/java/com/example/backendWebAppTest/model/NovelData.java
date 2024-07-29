package com.example.backendWebAppTest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="NovelData")
public class NovelData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;
    @Column(name="price")
    private String price;
    @Column(name="rating")
    private String rating;
    @Column(name="review_count")
    private String review_count;
    @Column(name="author")
    private String author;
    @Column(name="binding")
    private String binding;
    @Column(name="bestseller")
    private String bestseller;

    public NovelData(String description, String price, String rating, String review_count, String author, String binding, String bestseller) {
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.review_count = review_count;
        this.author = author;
        this.binding = binding;
        this.bestseller = bestseller;
    }
}
