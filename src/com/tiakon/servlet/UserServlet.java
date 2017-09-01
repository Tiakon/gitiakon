package com.tiakon.servlet;

import com.tiakon.entity.User;
import com.tiakon.service.UserService;
import com.tiakon.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Hoictas on 2017/8/30.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("**************UserServlet.java");
        String action = request.getParameter("action");
        if ("show".equals(action)) {
            showUser(request, response);
        }
    }

    protected void showUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            UserService userService = new UserServiceImpl();

            if (session.getAttribute("currentUser") != null) {
                User DBUser = userService.showUser((User) session.getAttribute("currentUser"));
                request.setAttribute("DBUser", DBUser);
                request.setAttribute("mainPage", "/user/userShow.jsp");
                request.getRequestDispatcher("/mainTemp.jsp").forward(request, response);
            } else {
                response.sendRedirect("/login.jsp");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
