package com.hwx.blog.service;

import com.hwx.blog.entity.Tag;

import java.util.List;

public interface ITagService {

    /**
     * 列出所有标签
     * @return
     */
    List<Tag> listTag();

    /**
     * 列出所有标签，同时返回标签下面文章数量
     * @return
     */
    List<Tag> listTagWithArticleCount();

    /**
     * 新增标签
     * @param tag
     */
    void addTag(Tag tag);

    /**
     * 删除标签
     * @param id
     */
    void delete(Integer id);

    /**
     * 获取一个tag
     * @param id
     * @return
     */
    Tag getOne(Integer id);

    /**
     * 编辑
     * @param tag
     */
    void update(Tag tag);
}
