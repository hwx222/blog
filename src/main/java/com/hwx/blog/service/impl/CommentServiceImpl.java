package com.hwx.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwx.blog.entity.Article;
import com.hwx.blog.entity.Comment;
import com.hwx.blog.mapper.ArticleMapper;
import com.hwx.blog.mapper.CommentMapper;
import com.hwx.blog.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Comment> listRecentComment(int limit) {
        return commentMapper.listRecentComment(limit);
    }

    @Override
    public PageInfo<Comment> getCommentPage(Integer pageNum, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<Comment> commentList = commentMapper.getCommentList();
        for (Comment comment : commentList) {
            Article article = articleMapper.selectById(comment.getCommentArticleId());
            comment.setArticleTitle(article.getArticleTitle());
        }
        return new PageInfo<>(commentList);
    }

    @Override
    public void deleteOne(Integer id) {
        commentMapper.deleteById(id);
    }


}
