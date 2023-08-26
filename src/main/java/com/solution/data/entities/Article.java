package com.solution.data.entities;

import javax.persistence.*;

import lombok.*;


import java.util.List;

@Entity
@Table( name ="article")
@Setter
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY ,    orphanRemoval = true,   targetEntity = Tag.class)
    private List<Tag> tags;


}
