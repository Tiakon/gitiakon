package cn.tiakon.servlet;

import cn.tiakon.entity.User;
import cn.tiakon.service.UserService;
import cn.tiakon.service.impl.UserServiceImpl;
import cn.tiakon.utils.DateUtil;
import cn.tiakon.utils.PropertiesUtil;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/30.
 */
public class UserServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(UserServlet.class);

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
        System.out.println("**************UserServlet.java");
        String action = request.getParameter("action");
        if ("presave".equals(action)) {
            userPreSave(request, response);
        } else if ("save".equals(action)) {
            userSave(request, response);
        } else if ("safeExit".equals(action)) {
            userSafeExit(request, response);
        }
    }

    protected void userPreSave(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            UserService userService = new UserServiceImpl();

            if (session.getAttribute("currentUser") != null) {
                User DBUser = userService.userPreSave((User) session.getAttribute("currentUser"));
                request.setAttribute("currentUser", DBUser);
                request.setAttribute("mainPage", "/user/userShow.jsp");
                request.getRequestDispatcher("/mainTemp.jsp").forward(request, response);
            } else {
                response.sendRedirect("/login.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void userSave(HttpServletRequest request, HttpServletResponse response) {
        try {
            boolean imageChange = false;
            boolean flag = false;
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            Iterator<FileItem> iterator = fileItems.iterator();

            HttpSession session = request.getSession();

            User sessionUser = (User) session.getAttribute("currentUser");

            while (iterator.hasNext()) {
                FileItem fileItem = iterator.next();
                if (fileItem.isFormField()) {
                    String fieldName = fileItem.getFieldName();
                    if ("nickNameInput".equals(fieldName)) {
                        sessionUser.setNickName(fileItem.getString("UTF-8"));
                    }
                    if ("moodTextArea".equals(fieldName)) {
                        sessionUser.setMood(fileItem.getString("UTF-8"));
                    }

                } else if (!"".equals(fileItem.getName())) {
                    String imageName = DateUtil.getCurrentDateStr();
                    //设置图片名
                    sessionUser.setImageName(imageName + "." + fileItem.getName().split("\\.")[1]);
                    String imagePath = PropertiesUtil.getValue("imagePath");
                    fileItem.write(new File(imagePath + sessionUser.getImageName()));
                    imageChange = true;
                }
            }

            if (!imageChange) {
                sessionUser.setImageName(sessionUser.getImageName().replaceFirst(PropertiesUtil.getValue("userImage"), ""));
            }

            UserService userService = new UserServiceImpl();
            flag = userService.userSave(sessionUser);

            if (flag) {
                //设置图片的绝对路径
                sessionUser.setImageName(PropertiesUtil.getValue("userImage") + sessionUser.getImageName());
                session.setAttribute("currentUser", sessionUser);
                request.setAttribute("flag", "success");
                request.setAttribute("message", "保存成功!");
            } else {
                request.setAttribute("flag", "failure");
                request.setAttribute("message", "保存失败!");
            }

            request.setAttribute("mainPage", "/user/userShow.jsp");
            request.getRequestDispatcher("/mainTemp.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void userSafeExit(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("currentUser");

        if (user != null) {
            System.out.println("currentUser:" + user);
            session.removeAttribute("currentUser");
        }
        try {
            response.sendRedirect("/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
