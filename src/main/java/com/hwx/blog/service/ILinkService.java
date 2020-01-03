package com.hwx.blog.service;

import com.hwx.blog.entity.Link;

import java.util.List;

public interface ILinkService {

    /**
     * 列出所有链接
     * @return
     */
    List<Link> listLink();

    /**
     * 根据id查出link
     * @param id
     * @return
     */
    Link selectOne(Integer id);

    /**
     * 更新
     * @param link
     */
    void editSubmit(Link link);

    /**
     * 删除
     * @param id
     */
    void deleteOne(Integer id);

    /**
     * 新增链接
     * @param link
     */
    void addLink(Link link);
}
