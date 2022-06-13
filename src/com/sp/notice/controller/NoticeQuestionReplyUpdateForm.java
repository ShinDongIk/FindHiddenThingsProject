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
 * Servlet implementation class NoticeQuestionReplyUpdateForm
 */
@WebServlet("/questionReplyUpdateForm.no")
public class NoticeQuestionReplyUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeQuestionReplyUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int questionReplyNo = Integer.parseInt(request.getParameter("qrno"));
		
		QuestionReply qr = new NoticeService().selectQuestionReplyUpdateForm(questionReplyNo);
		//글 번호,제목,내용,작성자,작성일
		System.out.println(questionReplyNo);
		request.setAttribute("questionReply", qr);
		request.getRequestDispatcher("views/notice/questionReplyUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
