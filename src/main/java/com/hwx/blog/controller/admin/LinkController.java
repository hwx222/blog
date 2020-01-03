package com.hwx.blog.controller.admin;

import com.hwx.blog.entity.Link;
import com.hwx.blog.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("admin/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @RequestMapping("")
    public String index(Model model) {
        List<Link> linkList = linkService.listLink();
        model.addAttribute("linkList", linkList);
        return "admin/Link/index";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        List<Link> linkList = linkService.listLink();
        model.addAttribute("linkList", linkList);
        Link link = linkService.selectOne(id);
        model.addAttribute("link", link);
        return "admin/Link/edit";
    }

    @RequestMapping(value = "/editSubmit", method = {RequestMethod.POST})
    public String editSubmit(Link link) {
        linkService.editSubmit(link);
        return "redirect:/admin/link";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        linkService.deleteOne(id);
        return "redirect:/admin/link";
    }

    @RequestMapping("/insert")
    public String add(Model model) {
        List<Link> linkList = linkService.listLink();
        model.addAttribute("linkList", linkList);
        return "admin/Link/insert";
    }

    @RequestMapping("insertSubmit")
    public String insertSubmit(Link link) {
        linkService.addLink(link);
        return "redirect:/admin/link";
    }


}
