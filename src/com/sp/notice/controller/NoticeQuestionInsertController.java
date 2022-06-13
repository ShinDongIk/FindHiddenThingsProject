package com.sp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.notice.model.service.NoticeService;
import com.sp.notice.model.vo.Questions;

@WebServlet("/questionInsert.no")
public class NoticeQuestionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeQuestionInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String questionTitle = request.getParameter("title");
		String questionContent = request.getParameter("content");
		
		Questions q = new Questions(questionTitle,questionContent,userNo);
		
		int result=new NoticeService().questionInsertNotice(q);
		
		if(result>0) {//성공했다면
			request.getSession().setAttribute("alertMsg", "1:1문의 등록 완료");
			response.sendRedirect(request.getContextPath()+"/questions.no?questionsListPage=1&userNo="+userNo);
		}else { //실패했다면 
			request.setAttribute("errorMsg", "1:1문의 등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
