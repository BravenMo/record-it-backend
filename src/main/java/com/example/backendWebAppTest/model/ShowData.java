package com.example.backendWebAppTest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "Shows")
@Getter
@Setter
@NoArgsConstructor
public class ShowData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="director")
    private String director;
    @Column(name="country")
    private String country;
    @Column(name="date")
    private String date;
    @Column(name="duration")
    private String duration;
    @Column(name="description")
    private String description;
    @Column(name="type")
    private String type;

    public ShowData(String title, String director, String country, String date, String duration, String description, String type) {
        this.title = title;
        this.director = director;
        this.country = country;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.type = type;
    }
}
