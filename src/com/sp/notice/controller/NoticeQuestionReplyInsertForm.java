package com.sp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.notice.model.service.NoticeService;
import com.sp.notice.model.vo.QuestionReply;

/**
 * Servlet implementation class NoticeQuestionReplyInsertForm
 */
@WebServlet("/questionReplyInsert.no")
public class NoticeQuestionReplyInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeQuestionReplyInsertForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int questionNo = Integer.parseInt(request.getParameter("qno"));
		String questionReplyContent = request.getParameter("content");
		
		QuestionReply qr = new QuestionReply(questionReplyContent,questionNo,userNo);
		
		int result=new NoticeService().insertQuestionReply(qr);
		if(result>0) {//성공했다면
			request.getSession().setAttribute("alertMsg", "1:1 답변 등록 완료");
			response.sendRedirect(request.getContextPath()+"/questions.no?questionsListPage=1&userNo="+userNo);
		}else { //실패했다면 
			request.setAttribute("errorMsg", "공지사항 등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
