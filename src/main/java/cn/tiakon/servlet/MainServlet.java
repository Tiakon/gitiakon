package cn.tiakon.servlet;

import cn.tiakon.entity.Diary;
import cn.tiakon.entity.DiaryType;
import cn.tiakon.entity.PageBean;
import cn.tiakon.service.DiaryService;
import cn.tiakon.service.DiaryTypeService;
import cn.tiakon.service.impl.DiaryServiceImpl;
import cn.tiakon.service.impl.DiaryTypeServiceImpl;
import cn.tiakon.utils.PagingUtil;
import cn.tiakon.utils.PropertiesUtil;
import cn.tiakon.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author tiankai.me@gmail.com on 2022/8/3 19:05.
 */
public class MainServlet extends BaseServlet {

    public MainServlet() {
        LOGGER = LogManager.getLogger(MainServlet.class.getName());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            LOGGER.info(">> doGet...");

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");

            HttpSession session = request.getSession();
            String page = request.getParameter("page");

            String diaryTypeIDParam = request.getParameter("diaryTypeIDParam");
            String diaryDateParam = request.getParameter("diaryDateParam");
            String searchAll = request.getParameter("flag");
            String search = request.getParameter("search");

            DiaryService diaryService = new DiaryServiceImpl();
            DiaryTypeService diaryTypeService = new DiaryTypeServiceImpl();
            Diary diaryParam = new Diary();
            if ("searchAll".equals(searchAll)) {

                if (StringUtil.isNotEmpty(search)) {
                    diaryParam.setTitle(search);
                }
                session.removeAttribute("diaryDateParam");
                session.removeAttribute("diaryTypeIDParam");
                session.setAttribute("search", search);
            } else {

                if (StringUtils.isEmpty(search)) {
                    Object searchObject = session.getAttribute("search");
                    if (searchObject != null) {
                        diaryParam.setTitle((String) searchObject);
                    }
                }

                if (StringUtils.isNotEmpty(diaryTypeIDParam)) {
                    diaryParam.setTypeId(Integer.parseInt(diaryTypeIDParam));
                    session.setAttribute("diaryTypeIDParam", diaryTypeIDParam);
                    session.removeAttribute("diaryDateParam");
                    session.removeAttribute("search");
                }
                if (StringUtil.isEmpty(diaryTypeIDParam)) {
                    Object diaryTypeIDParamObject = session.getAttribute("diaryTypeIDParam");
                    if (diaryTypeIDParamObject != null) {
                        diaryParam.setTypeId(Integer.parseInt(diaryTypeIDParamObject.toString()));
                    }
                }

                if (StringUtils.isNotEmpty(diaryDateParam)) {
                    diaryParam.setRelease_dateStr(diaryDateParam);
                    session.setAttribute("diaryDateParam", diaryDateParam);
                    session.removeAttribute("diaryTypeIDParam");
                    session.removeAttribute("search");
                }
                if (StringUtils.isEmpty(diaryDateParam)) {
                    Object diaryDateParamObject = session.getAttribute("diaryDateParam");
                    if (diaryDateParamObject != null) {
                        diaryParam.setRelease_dateStr((String) diaryDateParamObject);
                    }
                }
            }

            if (StringUtil.isEmpty(page)) {
                page = "1";
            }
            //查询总记录数
            int totalNumber = diaryService.diaryCount(diaryParam);
            String pageSize = PropertiesUtil.getValue("pageSize");
            PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(pageSize));

            String pageCode = PagingUtil.getPageInfo("MainServlet", totalNumber, pageBean.getPage(), pageBean.getPageSize());
            //查询所有记录数
            List<Diary> diaryList = diaryService.diaryList(pageBean, diaryParam);
            //查询所有的文章类别
            List<DiaryType> diaryTypeCountList = diaryTypeService.diaryTypeCountList();
            //查询所有的时间日期
            List<Diary> diaryDateList = diaryService.diaryDateList();

            session.setAttribute("diaryTypeCountList", diaryTypeCountList);
            session.setAttribute("diaryDateList", diaryDateList);

            request.setAttribute("pageCode", pageCode);
            request.setAttribute("diaryList", diaryList);
            request.setAttribute("mainPage", "/diary/diaryList.jsp");
            request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
