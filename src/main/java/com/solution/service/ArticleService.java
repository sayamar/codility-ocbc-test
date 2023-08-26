package com.solution.service;


import com.solution.model.ArticleDTO;
import com.solution.data.repos.ArticleRepository;
import com.solution.mapper.ArticleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleService {

    private final ArticleMapper articleMapper;
    private final ArticleRepository articleRepository;


    public List<ArticleDTO> findByTitle(String title) {
       return articleRepository.findByTitle(title).stream()
               .map(articleMapper::toDTO)
               .collect(Collectors.toList());
    }

    public Optional<ArticleDTO> findById(Long id) {
        return articleRepository.findById(id)
                .map(articleMapper::toDTO);
    }

    public Long save(ArticleDTO articleDTO) {
       return articleRepository.save(articleMapper.toEntity(articleDTO)).getId();
    }
    public void update(Long id,ArticleDTO articleDTO) {
       articleRepository.findById(id)
               .map(article -> articleMapper.toEntity(articleDTO).toBuilder().id(id).build())
               .ifPresent(articleRepository::saveAndFlush);
    }

    public void delete(Long id) {
        articleRepository.deleteById(id);
    }
}
