package com.hwx.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwx.blog.entity.Comment;
import com.hwx.blog.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/comment")
@Controller
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @RequestMapping("")
    public String getCommentList(Model model, Integer pageNum, Integer pageSize) {
        PageInfo<Comment> pageInfo = commentService.getCommentPage(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/Comment/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        commentService.deleteOne(id);
        return "redirect:/admin/comment";
    }




}
