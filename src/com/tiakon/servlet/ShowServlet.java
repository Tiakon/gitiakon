package com.tiakon.servlet;

import com.tiakon.entity.Diary;
import com.tiakon.service.DiaryService;
import com.tiakon.service.impl.DiaryServiceImpl;
import com.tiakon.utils.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Hoictas on 2017/8/18.
 */

public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("**************ShowServlet.java");
        String action = request.getParameter("action");
        if ("show".equals(action)) {
            diaryShow(request, response);
        } else if ("presave".equals(action)) {
            diaryPreSave(request, response);
        } else if ("save".equals(action)) {
            diarySave(request, response);
        } else if ("delete".equals(action)) {
            diaryDelete(request, response);
        } else if ("update".equals(action)) {
            diaryPreSave(request, response);
        }
    }

    protected void diaryShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiaryService diaryService = new DiaryServiceImpl();
        Diary diary = null;
        try {
            String diaryIdParam = request.getParameter("diaryIdParam");
            diary = diaryService.diaryShow(diaryIdParam);
            //System.out.println(diary);
            request.setAttribute("diary", diary);
            request.setAttribute("mainPage", "/diary/diaryShow.jsp");
            request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void diaryPreSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String diaryIdParam = request.getParameter("diaryIdParam");

            if (StringUtil.isEmpty(diaryIdParam)) {
                //diaryIdInput为空时执行preSave
                request.setAttribute("mainPage", "/diary/diaryPreSave.jsp");
                request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
                return;
            } else {
                //diaryIdInput不为空时执行show
                DiaryService diaryService = new DiaryServiceImpl();
                Diary diary = diaryService.diaryShow(diaryIdParam);

                request.setAttribute("diary", diary);
                request.setAttribute("mainPage", "/diary/diaryPreSave.jsp");
                request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void diarySave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String titleInput = request.getParameter("titleInput");
            String contentInput = request.getParameter("contentInput");
            String diaryTypeIdInput = request.getParameter("diaryTypeIdInput");
            String diaryIdInput = request.getParameter("diaryIdInput");

            Diary diaryInput = new Diary(titleInput, contentInput, Integer.parseInt(diaryTypeIdInput));

            DiaryService diaryService = new DiaryServiceImpl();
            int lineNumber = -1;
            if (StringUtil.isNotEmpty(diaryIdInput)) {
                diaryInput.setDiaryId(Integer.parseInt(diaryIdInput));
                lineNumber = diaryService.diaryUpdate(diaryInput);

            } else {
                lineNumber = diaryService.diaryAdd(diaryInput);
            }
            if (lineNumber < 0) {
                request.setAttribute("error", "保存失败");
                request.setAttribute("mainPage", "/diary/diaryPreSave.jsp");
                request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/MainServlet").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void diaryDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String diaryIdParam = request.getParameter("diaryIdParam");
        DiaryService diaryService = new DiaryServiceImpl();

        try {
            int lineNumber = diaryService.diaryDelete(diaryIdParam);

            if (lineNumber > 0) {
                System.out.println("删除成功！");
                request.getRequestDispatcher("/MainServlet").forward(request, response);
                return;
            } else {
                System.out.println("删除失败！");
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}