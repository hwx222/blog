package com.hwx.blog.controller.admin;

import com.hwx.blog.entity.Tag;
import com.hwx.blog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin/tag")
public class TagController {

    @Autowired
    private ITagService tagService;

    @RequestMapping("")
    public String index(Model model) {
        List<Tag> tagList = tagService.listTagWithArticleCount();
        model.addAttribute("tagList", tagList);
        return "admin/Tag/index";
    }

    @RequestMapping(value="/insertSubmit", method = {RequestMethod.POST})
    public String insertSubmit(Model model, Tag tag) {
        tagService.addTag(tag);
        return "redirect:/admin/tag";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        tagService.delete(id);
        return "redirect:/admin/tag";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        List<Tag> tagList = tagService.listTagWithArticleCount();
        model.addAttribute("tagList", tagList);
        Tag tag = tagService.getOne(id);
        model.addAttribute("tag", tag);
        return "admin/Tag/edit";
    }

    @RequestMapping(value = "/editSubmit", method = {RequestMethod.POST})
    public String editSubmit(Tag tag) {
        tagService.update(tag);
        return "redirect:/admin/tag";
    }


}
