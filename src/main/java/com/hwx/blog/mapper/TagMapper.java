package com.hwx.blog.mapper;

import com.hwx.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagMapper {
    List<Tag> selectTagByArticleId(Integer id);

    List<Tag> listTag();

    void deleteArticleTag(Integer articleId);

    void addArticleTag(@Param("articleId")Integer articleId, @Param("tagList") List<Integer> tagList);

    List<Tag> listTagWithArticleCount();

    void insertOne(Tag tag);

    Integer selectArticleCountByTagId(Integer id);

    void deleteById(Integer id);

    Tag selectById(Integer id);

    void updateOne(Tag tag);
}
