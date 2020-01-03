package com.hwx.blog.controller.admin;

import com.hwx.blog.entity.Category;
import com.hwx.blog.service.IArticleService;
import com.hwx.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import java.security.PrivateKey;
import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "")
    public String categoryList(Model model)  {
        List<Category> categoryList = categoryService.listCategoryWithCount();
        model.addAttribute("categoryList", categoryList);
        return "admin/Category/index";
    }

    @RequestMapping(value = "/addCategory", method = {RequestMethod.POST})
    public String addCategory(Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id)  {
        categoryService.deleteById(id);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editCategoryView(@PathVariable("id") Integer id, Model model)  {
        List<Category> categoryList = categoryService.listCategoryWithCount();
        model.addAttribute("categoryList", categoryList);
        Category category = categoryService.selectById(id);
        model.addAttribute("category", category);
        return "admin/Category/edit";
    }


}
