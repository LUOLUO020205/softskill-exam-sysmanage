package com.softskill.exam.controller;

import com.softskill.exam.service.IIdentityService;
import com.softskill.exam.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private IIdentityService iIdentityService;

    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String name, String passwd, HttpSession session, Model model, String flag) {
        boolean success = iIdentityService.checkPassword(name, passwd);
        if (success) {
            session.setAttribute("user", name);
            return "main";
        } else {
            if (StringUtils.isNotBlank(flag)) {
                model.addAttribute("loginMsg", "用户名或者密码错误");
            }
        }
        return "login";
    }
}
