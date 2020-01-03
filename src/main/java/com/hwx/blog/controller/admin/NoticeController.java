package com.hwx.blog.controller.admin;


import com.hwx.blog.entity.Notice;
import com.hwx.blog.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @RequestMapping("")
    public String index(Model model) {
        List<Notice> noticeList = noticeService.getNoticeList();
        model.addAttribute("noticeList", noticeList);
        return "admin/Notice/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Notice notice = noticeService.selectOne(id);
        model.addAttribute("notice", notice);
        return "admin/Notice/edit";
    }

    @RequestMapping("/editSubmit")
    public String editSubmit(Notice notice) {
        noticeService.update(notice);
        return "redirect:/admin/notice";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        noticeService.deleteOne(id);
        return "redirect:/admin/notice";
    }

    @RequestMapping("/insert")
    public String add(Model model) {
        return "admin/Notice/insert";
    }

    @RequestMapping("/insertSubmit")
    public String insertSubmit(Notice notice) {
        noticeService.addOne(notice);
        return "redirect:/admin/notice";
    }

}
