package com.hwx.blog.service.impl;

import com.hwx.blog.entity.Tag;
import com.hwx.blog.mapper.TagMapper;
import com.hwx.blog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements ITagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

    @Override
    public List<Tag> listTagWithArticleCount() {
        return tagMapper.listTagWithArticleCount();
    }

    @Override
    public void addTag(Tag tag) {
        tagMapper.insertOne(tag);
    }

    @Override
    public void delete(Integer id) {
        Integer count = tagMapper.selectArticleCountByTagId(id);
        if(count != null && count > 0) {
            throw new RuntimeException("标签下有文章");
        }
        tagMapper.deleteById(id);
    }

    @Override
    public Tag getOne(Integer id) {
        return tagMapper.selectById(id);
    }

    @Override
    public void update(Tag tag) {
        tagMapper.updateOne(tag);
    }
}
