package com.hwx.blog.entity;

import lombok.Data;

@Data
public class Tag {

    private Integer tagId;

    private String tagName;

    private String tagDescription;

    /**
     * 文章数量(不是数据库字段)
     */
    private Integer articleCount;

}
