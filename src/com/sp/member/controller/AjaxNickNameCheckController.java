package com.sp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.member.model.service.MemberService;

@WebServlet("/nickNameCheck.me")
public class AjaxNickNameCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxNickNameCheckController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userNickName = request.getParameter("userNickName");

		int result = new MemberService().NickNameCheck(userNickName);
		
		response.setContentType("text/html; charset=UTF-8");
	
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
