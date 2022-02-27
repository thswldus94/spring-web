package com.sonjy1994.hellospring.utils;

import com.sonjy1994.hellospring.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class UserSession {

    public static User getCurrentUserInfo() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);

        return (User)session.getAttribute("user");
    }
}
