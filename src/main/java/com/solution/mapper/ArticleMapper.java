package com.solution.mapper;

import com.solution.data.entities.Article;
import com.solution.data.entities.Tag;
import com.solution.model.ArticleDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleMapper {

    public ArticleDTO toDTO(Article article) {
       return ArticleDTO.builder()
               .title(article.getTitle())
               .content(article.getContent())
               .tags(convertTagsToString(article.getTags()))
               .build();

    }

    public Article toEntity(ArticleDTO articleDTO) {
        return Article.builder()
                .title(articleDTO.getTitle())
                .content(articleDTO.getContent())
                .tags(convertTagsToEntity(articleDTO.getTags()))
                .build();
    }

    private List<Tag> convertTagsToEntity(List<String> tags) {
        return tags.stream()
                .map(tag -> Tag.builder().tag(tag).build())
                .collect(Collectors.toList());
    }

    private List<String> convertTagsToString(List<Tag> tags) {
        return tags.stream()
                .map(Tag::getTag)
                .collect(Collectors.toList());
    }

}
