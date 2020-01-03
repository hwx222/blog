package com.hwx.blog.util;

import com.hwx.blog.entity.Category;

public class CategoryUtil {

    public static Category DefaultCategory() {
        Category category = new Category();
        category.setCategoryId(1000000);
        category.setCategoryName("未分类");
        return category;
    }

}
