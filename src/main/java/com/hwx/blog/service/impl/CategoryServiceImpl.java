package com.hwx.blog.service.impl;

import com.hwx.blog.entity.Category;
import com.hwx.blog.mapper.ArticleMapper;
import com.hwx.blog.mapper.CategoryMapper;
import com.hwx.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Category> listCategory() {
        return categoryMapper.listCategory();
    }

    @Override
    public List<Category> listCategoryWithCount() {
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryMapper.listCategory();
        for (Category category : categoryList) {
            category.setArticleCount(categoryMapper.selectArticleCountByCategoryId(category.getCategoryId()));
        }
        return categoryList;
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.insertOne(category);
    }

    @Override
    public void deleteById(Integer id) {
        Integer count = articleMapper.getArticleCountByCategoryId(id);
        if(count != null && count > 0) {
            throw new RuntimeException("分类下面有文章");
        }
        categoryMapper.deleteById(id);
    }

    @Override
    public Category selectById(Integer id) {
        return categoryMapper.selectById(id);
    }

}
