package com.tiakon.servlet;

import com.tiakon.entity.DiaryType;
import com.tiakon.service.DiaryService;
import com.tiakon.service.DiaryTypeService;
import com.tiakon.service.impl.DiaryServiceImpl;
import com.tiakon.service.impl.DiaryTypeServiceImpl;
import com.tiakon.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Hoictas on 2017/8/20.
 */
public class DiaryTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("**************DiaryTypeServlet.java");
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            diaryTypeList(request, response);
        } else if ("delete".equals(action)) {
            diaryTypeDelete(request, response);
        } else if ("save".equals(action)) {
            diaryTypeSave(request, response);
        }
    }

    protected void diaryTypeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DiaryTypeService diaryTypeService = new DiaryTypeServiceImpl();
            List<DiaryType> diaryTypeCountList = diaryTypeService.diaryTypeCountList();
            request.setAttribute("diaryTypeCountList", diaryTypeCountList);
            request.setAttribute("mainPage", "/diaryType/diaryTypeList.jsp");
            request.getRequestDispatcher("/mainTemp.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void diaryTypeDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String diaryTypeIdParam = request.getParameter("diaryTypeIdParam");
            DiaryTypeService diaryTypeService = new DiaryTypeServiceImpl();
            int lineNumber = diaryTypeService.diaryTypeDelete(Integer.parseInt(diaryTypeIdParam));
            if (lineNumber > 0) {
                System.out.println("删除成功");
                request.setAttribute("flag", "success");
                request.setAttribute("message", "删除成功!");
                request.getRequestDispatcher("/DiaryTypeServlet?action=list").forward(request, response);
                return;
            } else {
                System.out.println("删除失败");
                request.setAttribute("flag", "failure");
                request.setAttribute("message", "删除失败!");
                request.getRequestDispatcher("/DiaryTypeServlet?action=list").forward(request, response);
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void diaryTypeSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String diaryTypeNameInput = request.getParameter("diaryTypeNameInput");
            String diaryTypeIdUpdate = request.getParameter("diaryTypeIdUpdate");
            String diaryTypeNameUpdate = request.getParameter("diaryTypeNameUpdate");
            DiaryTypeService diaryTypeService = new DiaryTypeServiceImpl();
            int lineNumber = 0;
            if (StringUtil.isNotEmpty(diaryTypeIdUpdate)) {
                DiaryType diaryType = new DiaryType(Integer.parseInt(diaryTypeIdUpdate), diaryTypeNameUpdate);
                lineNumber = diaryTypeService.diaryTypeUpdate(diaryType);
                if (lineNumber > 0) {

                    System.out.println("修改成功");
                    request.setAttribute("flag", "success");
                    request.setAttribute("message", "修改成功!");
                } else {
                    System.out.println("修改失败");
                    request.setAttribute("flag", "failure");
                    request.setAttribute("message", "修改失败!");

                }
            } else {
                lineNumber = diaryTypeService.diaryTypeAdd(diaryTypeNameInput);
                if (lineNumber > 0) {
                    System.out.println("添加成功");
                    request.setAttribute("flag", "success");
                    request.setAttribute("message", "添加成功!");
                } else {
                    System.out.println("添加失败");
                    request.setAttribute("flag", "failure");
                    request.setAttribute("message", "添加失败!");

                }
            }
            request.getRequestDispatcher("/DiaryTypeServlet?action=list").forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
