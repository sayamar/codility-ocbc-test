package com.solution.data.entities;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table( name ="article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tag> tags;
}
