package cn.tiakon.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tiankai.me@gmail.com on 2022/8/3 18:53.
 */
public class BaseServlet extends HttpServlet {

    public Logger LOGGER = LogManager.getLogger(BaseServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info(">> {}", req.getRequestURL().toString());
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info(">> {}", req.getRequestURL().toString());
        super.doPost(req, resp);
    }
}
