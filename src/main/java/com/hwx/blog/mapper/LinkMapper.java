package com.hwx.blog.mapper;

import com.hwx.blog.entity.Link;

import java.util.List;

public interface LinkMapper {

    List<Link> getLinkList();

    Link selectOne(Integer id);

    void update(Link link);

    void deleteById(Integer id);

    void insertOne(Link link);
}
