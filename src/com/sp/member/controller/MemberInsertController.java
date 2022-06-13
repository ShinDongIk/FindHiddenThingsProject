package com.sp.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sp.member.model.service.MemberService;
import com.sp.member.model.vo.Member;

@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				request.setCharacterEncoding("UTF-8");
			
				String userId = request.getParameter("userId");
				String userPwd = request.getParameter("userPwd");
				String userNickName = request.getParameter("userNickName");
				String userName = request.getParameter("userName");
				String userPhone = request.getParameter("userPhone");
				String userEmail = request.getParameter("userEmail");

				Member m = new Member(userName,userId,userPwd,userNickName,userEmail,userPhone);
			
				int result=new MemberService().insertMember(m);
				
				if(result>0) {					
					HttpSession session = request.getSession();
					session.setAttribute("alertMsg", "회원가입에 성공했습니다.");
					response.sendRedirect(request.getContextPath());//인덱스페이지로 보내기
				}else {
					
					request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
					
					RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
					view.forward(request, response);
				}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
