package com.hwx.blog.service;

import com.github.pagehelper.PageInfo;
import com.hwx.blog.dto.ArticleParam;
import com.hwx.blog.entity.Article;

import java.util.List;

public interface IArticleService {

    List<Article> listRecentArticle(int limit);

    PageInfo<Article> getArticlePage(Integer pageNum, Integer pageSize);

    void deleteArticle(Integer id);

    Article selectById(Integer id);

    void update(ArticleParam articleParam);

    void addArticle(ArticleParam articleParam);
}
