package com.sp.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.notice.model.service.NoticeService;
import com.sp.notice.model.vo.QuestionReply;
import com.sp.notice.model.vo.Questions;

/**
 * Servlet implementation class NoticeQuestionsDetailController
 */
@WebServlet("/questionsDetail.no")
public class NoticeQuestionsDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeQuestionsDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo=Integer.parseInt(request.getParameter("userNo"));
		int questionNo=Integer.parseInt(request.getParameter("qno"));
		int result = new NoticeService().questionIncreaseCount(questionNo);
		int getQuestionReplyNo = 0;
		String replyStatus = "N";
		QuestionReply qr = new QuestionReply();
		
		// 답글 가져오기
		ArrayList<QuestionReply> list = new NoticeService().questionReplySelect(questionNo);
		
		// questionReplyNo 가져오기
		QuestionReply qrn = new NoticeService().questionReplyNoSelect(questionNo);
		
		if(list.size() >= 1) {
			qr = new NoticeService().questionReplySelectOne(questionNo);
			try {
				replyStatus = qr.getQuestionReplyStatus();
				request.setAttribute("getQuestionReplyNo", qr.getQuestionReplyNo());
			} catch (NullPointerException npe) {
				replyStatus = "N";
			}
		}
		
		
		if(result>0) {//성공시
			Questions q = new NoticeService().selectQuestion(questionNo);
			request.setAttribute("question", q);
			if(qr != null) {
				request.setAttribute("questionReply", qr);
				request.setAttribute("getQuestionReplyNo", qr.getQuestionReplyNo());
			}  else {
				qr = null;
				request.setAttribute("questionReply", qr);
				request.setAttribute("getQuestionReplyNo", getQuestionReplyNo);
				
			}
			request.setAttribute("questionNo", questionNo);
			request.setAttribute("getQuestionReplyStatus", replyStatus);
			request.getRequestDispatcher("views/notice/questionDetail.jsp").forward(request, response);
		}else {//실패시
			request.setAttribute("errorMsg","1:1문의 조회 실패");
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
