package com.hwx.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwx.blog.dto.ArticleParam;
import com.hwx.blog.entity.Article;
import com.hwx.blog.entity.Category;
import com.hwx.blog.entity.Tag;
import com.hwx.blog.mapper.ArticleMapper;
import com.hwx.blog.mapper.CategoryMapper;
import com.hwx.blog.mapper.TagMapper;
import com.hwx.blog.service.IArticleService;
import com.hwx.blog.util.CategoryUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;


    @Override
    public List<Article> listRecentArticle(int limit) {
        return articleMapper.listRecentArticle(limit);
    }

    @Override
    public PageInfo<Article> getArticlePage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Article> list = articleMapper.selectArticleList();
        for (Article article : list) {
            List<Category> categoryList = categoryMapper.selectCatgoryByArticleId(article.getArticleId());
            if(categoryList == null || categoryList.size() == 0) {
                categoryList = new ArrayList<Category>();
                categoryList.add(CategoryUtil.DefaultCategory());
            }
            article.setCategoryList(categoryList);
        }
        return new PageInfo<>(list);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteById(id);
    }

    @Override
    public Article selectById(Integer id) {
        Article article = articleMapper.selectById(id);
        List<Category> categoryList = categoryMapper.selectCatgoryByArticleId(id);
        if(categoryList == null || categoryList.size() == 0) {
            categoryList = new ArrayList<Category>();
            categoryList.add(CategoryUtil.DefaultCategory());
        }
        List<Tag> tagList = tagMapper.selectTagByArticleId(id);
        if(tagList != null && tagList.size() > 0) {
            article.setTagList(tagList);
        }
        article.setCategoryList(categoryList);
        return article;
    }

    @Override
    public void update(ArticleParam articleParam) {
        Article article = new Article();
        BeanUtils.copyProperties(articleParam, article);
        articleMapper.update(article);
        //分类
        List<Integer> categoryList = new ArrayList<Integer>();
        if(articleParam.getArticleParentCategoryId() != null) {
            categoryList.add(articleParam.getArticleParentCategoryId());
        }
        if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(articleParam.getArticleChildCategoryId());
        }
        categoryMapper.deleteArticleCategory(article.getArticleId());
        categoryMapper.addArticleCategory(article.getArticleId(), categoryList);
        //标签
        List<Integer> tagList = new ArrayList<>();
        if (articleParam.getArticleTagIds() != null) {
            tagList = articleParam.getArticleTagIds();
        }
        tagMapper.deleteArticleTag(article.getArticleId());
        tagMapper.addArticleTag(article.getArticleId(), tagList);
    }

    @Override
    public void addArticle(ArticleParam articleParam) {
        Article article = new Article();
        BeanUtils.copyProperties(articleParam, article);
        articleMapper.insertOne(article);
        //分类
        List<Integer> categoryList = new ArrayList<Integer>();
        if(articleParam.getArticleParentCategoryId() != null) {
            categoryList.add(articleParam.getArticleParentCategoryId());
        }
        if (articleParam.getArticleChildCategoryId() != null) {
            categoryList.add(articleParam.getArticleChildCategoryId());
        }
        categoryMapper.addArticleCategory(article.getArticleId(), categoryList);
        //标签
        List<Integer> tagList = new ArrayList<>();
        if (articleParam.getArticleTagIds() != null) {
            tagList = articleParam.getArticleTagIds();
        }
        tagMapper.addArticleTag(article.getArticleId(), tagList);
    }


}
