package com.example.backendWebAppTest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Games")
@NoArgsConstructor
@Getter
@Setter
public class GameData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="Name")
    String name;
    @Column(name="Platform")
    String platform;
    @Column(name="Genre")
    String genre;
    @Column(name="Year")
    String year;
    @Column(name="Publisher")
    String publisher;
}
