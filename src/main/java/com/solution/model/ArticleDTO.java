package com.solution.model;

import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
public class ArticleDTO {

    private String title;
    private String content;
    private List<String> tags;


}
