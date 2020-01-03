package com.hwx.blog.service;

import com.github.pagehelper.PageInfo;
import com.hwx.blog.entity.Comment;

import java.util.List;

public interface ICommentService {

    /**
     * 近期评论
     * @param limit
     * @return
     */
    List<Comment> listRecentComment(int limit);

    PageInfo<Comment> getCommentPage(Integer pageNum, Integer pageSize);

    void deleteOne(Integer id);
}
