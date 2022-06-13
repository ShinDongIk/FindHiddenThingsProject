package com.sp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.notice.model.service.NoticeService;
import com.sp.notice.model.vo.QuestionReply;

@WebServlet("/questionReplyUpdate.no")
public class NoticeQuestionReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeQuestionReplyUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int questionReplyNo = Integer.parseInt(request.getParameter("qrno"));
		String questionReplyContent = request.getParameter("Content");
	
		QuestionReply qr = new QuestionReply();
		
		qr.setQuestionReplyNo(questionReplyNo);
		qr.setQuestionReplyContent(questionReplyContent);
		
		int result = new NoticeService().updateQuestionReply(qr);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "1:1 답변 수정 완료");
			response.sendRedirect(request.getContextPath()+"/questions.no?questionsListPage=1&userNo="+userNo);
			
		}else {
			request.setAttribute("errorMsg", "1:1 답변 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
