package com.tiakon.utils;

public class PageUtil {
    /**
     * 方法名: getPagation
     * 参数名: [请求地址： targetUrl]
     * 参数名: [总记录数: totalNum]
     * 参数名: [第几页: currentPage]
     * 参数名: [每页记录数: pageSize]
     * 返回类型:java.lang.String
     **/
    public static String getPagation(String targetUrl, int totalNum, int currentPage, int pageSize) {

        int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        StringBuffer pageCode = new StringBuffer();
        pageCode.append("<li><a href='" + targetUrl + "?page=1'>首页</a></li>");
        if (currentPage == 1) {
            pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
        } else {
            pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage - 1) + "'>上一页</a></li>");
        }
        for (int i = currentPage - 2; i <= currentPage + 2; i++) {
            if (i < 1 || i > totalPage) {
                continue;
            }
            if (i == currentPage) {
                pageCode.append("<li class='active'><a href='#'>" + i + "</a></li>");
            } else {
                pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "'>" + i + "</a></li>");
            }
        }
        if (currentPage == totalPage) {
            pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
        } else {
            pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage + 1) + "'>下一页</a></li>");
        }
        pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "'>尾页</a></li>");
        return pageCode.toString();
    }
}
