package com.hwx.blog.controller.admin;

import com.hwx.blog.entity.Article;
import com.hwx.blog.entity.Comment;
import com.hwx.blog.service.IArticleService;
import com.hwx.blog.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ICommentService commentServce;
    @Autowired
    private IArticleService articleService;

    /**
     * 后台首页
     * @param model
     * @return
     */
    @RequestMapping("/admin")
    public String index(Model model) {
        //近期文章
        List<Article> articleList = articleService.listRecentArticle(5);
        model.addAttribute("articleList", articleList);
        //近期评论
        List<Comment> commentList = commentServce.listRecentComment(5);
        model.addAttribute("commentList", commentList);
        return "admin/index";
    }




}
