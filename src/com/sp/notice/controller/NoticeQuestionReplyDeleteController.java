package com.sp.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeQuestionReplyDeleteController
 */
@WebServlet("/questionReplyDelete.no")
public class NoticeQuestionReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeQuestionReplyDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionReplyNo = Integer.parseInt(request.getParameter("qrno"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		System.out.println(questionReplyNo);
		int result = new NoticeService().deleteQuestionReply(questionReplyNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "삭제 성공");
			response.sendRedirect(request.getContextPath()+"/questions.no?questionsListPage=1&userNo="+userNo);
		}else {
			request.setAttribute("errorMsg","삭제 실패");
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
