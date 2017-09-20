package com.tiakon.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Hoictas on 2017/8/10.
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest servletReq, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletReq;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String servletPath = request.getServletPath();
        Object user = session.getAttribute("currentUser");

        //System.out.println(servletPath.indexOf("login.jsp"));
       /*
               1.以下资源被请求时不拦截。
               2.用户成功登陆后不拦截
                    2.1成功登陆后，直接访问mainTemp.jsp，由于mianPage为空，拦截jsp include的请求到指定页面（mainPageIsNull.jsp）
       */
        if (user == null && servletPath.indexOf("login.jsp") < 0
                && servletPath.indexOf(".css") < 0 && servletPath.indexOf("LoginServlet") < 0
                && servletPath.indexOf("utils.js") < 0 && servletPath.indexOf("bootstrap.js") < 0
                && servletPath.indexOf("jquery") < 0 && servletPath.indexOf("favicon.ico") < 0
                && servletPath.indexOf("mainPageIsNull.jsp") < 0) {
            System.out.println("被拦截的请求:" + servletPath);
            response.sendRedirect("/login.jsp");
            return;
        } else {
            System.out.print("是否已登录:");
            System.out.println(user != null);
            System.out.println("请求的servletPath:" + servletPath);
            chain.doFilter(servletReq, servletResponse);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
