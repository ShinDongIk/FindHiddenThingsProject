package com.sp.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.notice.model.service.NoticeService;
import com.sp.notice.model.vo.Faq;

/**
 * Servlet implementation class NoticeFaqDetailController
 */
@WebServlet("/faqDetail.no")
public class NoticeFaqDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFaqDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int faqNo=Integer.parseInt(request.getParameter("fno"));
		
		int result = new NoticeService().faqIncreaseCount(faqNo);
		
		if(result>0) {//성공시
			Faq f = new NoticeService().selectFaq(faqNo);
			request.setAttribute("faq", f);
			request.getRequestDispatcher("views/notice/FAQDetail.jsp").forward(request, response);
		}else {//실패시
			
			request.setAttribute("errorMsg","공지사항 조회 실패");
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
