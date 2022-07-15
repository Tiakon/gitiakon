package cn.tiakon.servlet;

import cn.tiakon.entity.User;
import cn.tiakon.service.UserService;
import cn.tiakon.service.impl.UserServiceImpl;
import cn.tiakon.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Hoictas on 2017/8/8.
 */
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("> doPost...");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("> doGet...");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        User resultSetUser;
        HttpSession session = request.getSession();
        try {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String remember = request.getParameter("remember");
            if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
                response.sendRedirect("/login.jsp");
                return;
            }
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            UserService userService = new UserServiceImpl();
            resultSetUser = userService.login(user);
            if (resultSetUser == null) {
                System.out.println("登录失败");
                request.setAttribute("user", user);
                request.setAttribute("error", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                if ("remember-me".equals(remember)) {
                    this.addCookies(username, password, response);
                }
                session.setAttribute("currentUser", resultSetUser);
                request.getRequestDispatcher("MainServlet").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void addCookies(String userName, String password, HttpServletResponse response) {
        Cookie cookie = new Cookie("user", userName + "-" + password);
        //设置cookie的有效时间（秒）
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);
    }
}
