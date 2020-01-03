package com.hwx.blog.mapper;

import com.hwx.blog.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {

    List<Category> selectCatgoryByArticleId(Integer articleId);

    List<Category> listCategory();

    void deleteArticleCategory(Integer articleId);

    void addArticleCategory(@Param("articleId") Integer articleId, @Param("categoryList") List<Integer> categoryList);

    Integer selectArticleCountByCategoryId(Integer categoryId);

    void insertOne(Category category);

    void deleteById(Integer id);

    Category selectById(Integer id);
}
