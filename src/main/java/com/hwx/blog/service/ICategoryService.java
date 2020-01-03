package com.hwx.blog.service;

import com.hwx.blog.entity.Category;

import java.util.List;

public interface ICategoryService {

    /**
     * 列出所有分类
     * @return
     */
    List<Category> listCategory();

    /**
     * 列出所有分类，并统计分类下的文章数量
     * @return
     */
    List<Category> listCategoryWithCount();

    /**
     * 新增分类
     * @param category
     */
    void addCategory(Category category);

    /**
     * 删除分类
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id获取分类信息
     * @param id
     * @return
     */
    Category selectById(Integer id);
}
