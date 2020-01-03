package com.hwx.blog.service.impl;

import com.hwx.blog.entity.Link;
import com.hwx.blog.mapper.LinkMapper;
import com.hwx.blog.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<Link> listLink() {
        return linkMapper.getLinkList();
    }

    @Override
    public Link selectOne(Integer id) {
        return linkMapper.selectOne(id);
    }

    @Override
    public void editSubmit(Link link) {
        linkMapper.update(link);
    }

    @Override
    public void deleteOne(Integer id) {
        linkMapper.deleteById(id);
    }

    @Override
    public void addLink(Link link) {
        linkMapper.insertOne(link);
    }
}
