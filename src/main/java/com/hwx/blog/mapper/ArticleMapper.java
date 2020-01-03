package com.hwx.blog.mapper;

import com.hwx.blog.entity.Article;

import java.util.List;

public interface ArticleMapper {
    List<Article> listRecentArticle(int limit);

    List<Article> selectArticleList();

    void deleteById(Integer id);

    Article selectById(Integer id);

    void update(Article article);

    Integer getArticleCountByCategoryId(Integer id);

    void insertOne(Article article);
}
