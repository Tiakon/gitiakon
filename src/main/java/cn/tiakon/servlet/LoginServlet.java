package cn.tiakon.servlet;

import cn.tiakon.entity.User;
import cn.tiakon.service.UserService;
import cn.tiakon.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author tiankai.me@gmail.com on 2022/8/3 18:32.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet", loadOnStartup = 1)
public class LoginServlet extends BaseServlet {

    public LoginServlet() {
        LOGGER = LogManager.getLogger(LoginServlet.class.getName());
        LOGGER.info("> LoginServlet()");
    }

    @Override
    public void init() throws ServletException {
        LOGGER.info("> init()");
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("> doPost...");
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info(">> getServletName:{}", this.getServletName());
        LOGGER.info(">> getServletContext:{}", new File(this.getServletContext().getContextPath()).getAbsolutePath());
        LOGGER.info(">> getServletContext.getRealPath:{}", new File(this.getServletContext().getRealPath("userImage")).getAbsolutePath());
        LOGGER.info(">> request.getContextPath:{}", new File(request.getContextPath()).getAbsolutePath());

        LOGGER.info("> doGet...");
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            User resultSetUser;
            HttpSession session = request.getSession();
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String remember = request.getParameter("remember");
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                response.sendRedirect("/login.jsp");
                return;
            }
            User user = new User(username, password);
            UserService userService = new UserServiceImpl();
            resultSetUser = userService.login(user);
            if (resultSetUser == null) {
                System.out.println("登录失败");
                request.setAttribute("user", user);
                request.setAttribute("error", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                if ("remember-me".equals(remember)) {
                    addCookies(username, password, response);
                }
                session.setAttribute("currentUser", resultSetUser);
                request.getRequestDispatcher("MainServlet")
                        .forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCookies(String userName, String password, HttpServletResponse response) {
        Cookie cookie = new Cookie("user", userName + "-" + password);
        //设置cookie的有效时间（秒）
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);
    }
}
