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
 * Servlet implementation class NoticeFaqUpdateController
 */
@WebServlet("/faqUpdate.no")
public class NoticeFaqUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFaqUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int faqNo = Integer.parseInt(request.getParameter("fno"));
		String faqTitle = request.getParameter("faqTitle");
		String faqContent = request.getParameter("faqContent");
	
		Faq f = new Faq();
		
		f.setFaqNo(faqNo);
		f.setFaqTitle(faqTitle);
		f.setFaqContent(faqContent);
		
		int result = new NoticeService().updateFaq(f);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "FAQ 수정 완료");
			response.sendRedirect(request.getContextPath()+"/faqList.no?faqListPage=1");
			
		}else {
			request.setAttribute("errorMsg", "FAQ 수정 실패");
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
