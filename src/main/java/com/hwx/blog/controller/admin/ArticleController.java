package com.hwx.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.hwx.blog.dto.ArticleParam;
import com.hwx.blog.entity.Article;
import com.hwx.blog.entity.Category;
import com.hwx.blog.entity.Tag;
import com.hwx.blog.service.IArticleService;
import com.hwx.blog.service.ICategoryService;
import com.hwx.blog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ITagService tagService;

    /*
    文章模块首页
     */
    @RequestMapping
    public String index(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize, Model model) {
        PageInfo<Article> articlePage = articleService.getArticlePage(pageNum, pageSize);
        model.addAttribute("pageInfo", articlePage);
        model.addAttribute("pageUrlPrefix", "/admin/article?pageNum");
        return "admin/Article/index";
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        articleService.deleteArticle(id);
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Article article = articleService.selectById(id);
        model.addAttribute("article", article);
        List<Category> categoryList = categoryService.listCategory();
        model.addAttribute("categoryList", categoryList);
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList", tagList);
        return "admin/Article/edit";
    }

    @RequestMapping(value = "/editSubmit", method = {RequestMethod.POST})
    public String editArticle(ArticleParam articleParam) {
        articleService.update(articleParam);
        return "redirect:/admin/article";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        List<Tag> tagList = tagService.listTag();
        List<Category> categoryList = categoryService.listCategory();
        model.addAttribute("tagList", tagList);
        model.addAttribute("categoryList", categoryList);
        return "admin/Article/insert";
    }

    @RequestMapping(value = "/insertSubmit", method = {RequestMethod.POST})
    public String insertSubmit(ArticleParam articleParam) {
        articleService.addArticle(articleParam);
        return "redirect:/admin/article";
    }

}
