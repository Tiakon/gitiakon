package cn.tiakon.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author tiankai.me@gmail.com on 2022/8/3 21:26.
 */
public class LoginFilter implements Filter {

    public Logger LOGGER = LogManager.getLogger(LoginFilter.class.getName());

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResponse, FilterChain chain) {
        try {
            HttpServletRequest request = (HttpServletRequest) servletReq;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpSession session = request.getSession();
            String servletPath = request.getServletPath();
            Object user = session.getAttribute("currentUser");

            // 1.以下资源被请求时不拦截。
            // 2.用户成功登陆后不拦截
            // 2.1成功登陆后，直接访问mainTemp.jsp，由于mainPage为空，拦截jsp include的请求到指定页面（mainPageIsNull.jsp）
            if (user == null && !servletPath.contains("login.jsp")
                    && !servletPath.contains(".css") && !servletPath.contains("LoginServlet")
                    && !servletPath.contains("utils.js") && !servletPath.contains("bootstrap.js")
                    && !servletPath.contains("jquery") && !servletPath.contains("favicon.ico")
                    && !servletPath.contains("mainPageIsNull.jsp")) {
                LOGGER.info(">> 拦截请求:{}", servletPath);
                response.sendRedirect("/login.jsp");
            } else {
                LOGGER.info(">> 登录状态:{}", user != null);
                LOGGER.info(">> 放行请求: {}", servletPath);
                chain.doFilter(servletReq, servletResponse);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
