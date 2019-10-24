package com.ligui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ligui.pojo.Account;
import com.ligui.service.AccountService;
import com.ligui.service.impl.AccountServiceImpl;


@WebServlet("/transfer")
public class TransferServlet extends HttpServlet{
	private AccountService accservice=new AccountServiceImpl();
@Override
protected void service(HttpServletRequest req, HttpServletResponse resq) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	Account accOut=new Account();
	accOut.setAccNo(req.getParameter("accOutAccNo"));
	accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
	accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
	Account accIn=new Account();
	accIn.setAccNo(req.getParameter("accInAccNo"));
	accIn.setName(req.getParameter("accInName"));

	
	
	int index = accservice.transfer(accIn, accOut);
	if(index==AccountService.SUCCESS) {
		resq.sendRedirect("/bank/show");	
	}else {
		HttpSession session=req.getSession();
		session.setAttribute("code", index);
		resq.sendRedirect("/bank/error/error.jsp");
	}
	
	
}
}
