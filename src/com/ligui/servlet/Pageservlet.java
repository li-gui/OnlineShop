package com.ligui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ligui.pojo.PageInfo;
import com.ligui.service.LogService;
import com.ligui.service.impl.LogServiceImpl;
@WebServlet("/show")
public class Pageservlet extends HttpServlet{
	private LogService logService = new LogServiceImpl();
@Override
protected void service(HttpServletRequest req, HttpServletResponse resq) throws ServletException, IOException {
	
	
	//第一次访问的验证,如果没有传递参数,设置默认值
			String pageSizeStr = req.getParameter("pageSize");
			int pageSize = 3;
			if(pageSizeStr!=null&&!pageSizeStr.equals("")){
				pageSize = Integer.parseInt(pageSizeStr);
			}
			String pageNumberStr = req.getParameter("pageNumber");
			int pageNumber = 1;
			if(pageNumberStr!=null&&!pageNumberStr.equals("")){
				pageNumber = Integer.parseInt(pageNumberStr);
			}
			PageInfo pi = logService.showPage(pageSize, pageNumber);
			req.setAttribute("PageInfo", pi);
			req.getRequestDispatcher("log.jsp").forward(req, resq);
}
}
