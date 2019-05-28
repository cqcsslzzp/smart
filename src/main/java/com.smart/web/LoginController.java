package com.smart.web;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller  //将任何一下POJO类标注为spirng MVC的控制器，处理HTTP的请求，标注了@controller的类首先是个bean，所以使用@autowired进行bean的注入
public class LoginController {
    private UserService userService;


    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "home";
    }

    @RequestMapping(value = "/loginCheck.html")
    //modelandview代表一个视图
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean isValidUser = userService.hashMatchUser(loginCommand.getUserName(), loginCommand.getPassword());

        if (!isValidUser) {
            return new ModelAndView("/WEB-INF/statics/index.jsp", "error", "用户名或密码错误");
        } else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());

            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("/WEB-INF/statics/main.jsp");
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
