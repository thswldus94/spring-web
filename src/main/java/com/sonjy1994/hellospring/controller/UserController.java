package com.sonjy1994.hellospring.controller;

import com.sonjy1994.hellospring.controller.entity.MemberEntity;
import com.sonjy1994.hellospring.controller.entity.UserEntity;
import com.sonjy1994.hellospring.domain.Member;
import com.sonjy1994.hellospring.domain.User;
import com.sonjy1994.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/join")
    public String join() {
        return "user/join";
    }

    @PostMapping("/user/add_user")
    public String addUser(UserEntity entity) {
        User user = new User();
        user.setUserId(entity.getUserId());
        user.setUserName(entity.getUserName());
        user.setPassword(entity.getPassword());

        userService.join(user);

        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String loginForm() {
        return "user/login";
    }

    @PostMapping("/user/login")
    public String login(UserEntity entity, HttpServletRequest req) {
        HttpSession session = req.getSession();

        User user = new User();
        user.setUserId(entity.getUserId());
        user.setPassword(entity.getPassword());

        Boolean result = userService.login(user);
        System.out.println(result);
        if (result) {
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            System.out.println("로그인 실패!!!");
            return "redirect:/";
        }
    }

    @PostMapping("/user/logout")
    public String logout(HttpServletRequest req) {
        req.getSession().invalidate();
        req.getSession(true);

        return "redirect:/";
    }

    @GetMapping("/user/list")
    public String list(Model model) {
        List<User> userList = userService.findMembers();
        model.addAttribute("userList", userList);
        return "user/userList";
    }
}
