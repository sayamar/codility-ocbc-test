package com.solution.api.controller;

import com.solution.model.ArticleDTO;
import com.solution.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/article/{id}")
    public ArticleDTO getArticles(@PathVariable Long id) {
        return articleService.findById(id).orElse(ArticleDTO.builder().build());
    }

    @GetMapping("/article")

    public List<ArticleDTO> getArticles(@RequestParam String  title) {
        return articleService.findByTitle(title);
    }

    @PostMapping("/article")
    public Long create(@RequestBody ArticleDTO articleDTO) {
        return articleService.save(articleDTO);
    }

    @PutMapping("/article/{id}")
    public void update(@PathVariable Long id, ArticleDTO articleDTO) {
        articleService.update(id, articleDTO);
    }

    @DeleteMapping  ("/article/{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }
}
