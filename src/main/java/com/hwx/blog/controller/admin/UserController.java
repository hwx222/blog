package com.hwx.blog.controller.admin;

import com.hwx.blog.entity.User;
import com.hwx.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("")
    public String index(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "/admin/User/index";
    }

    @RequestMapping("/insert")
    public String insert(Model model) {
        return "admin/User/insert";
    }

}
