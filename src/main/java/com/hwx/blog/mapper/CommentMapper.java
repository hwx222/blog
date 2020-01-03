package com.hwx.blog.mapper;

import com.hwx.blog.entity.Comment;

import java.util.List;

public interface CommentMapper {
    List<Comment> listRecentComment(int limit);

    List<Comment> getCommentList();

    void deleteById(Integer id);
}
