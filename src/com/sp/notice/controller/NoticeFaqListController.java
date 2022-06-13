package com.sp.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sp.notice.model.service.NoticeService;
import com.sp.notice.model.vo.Faq;
import com.sp.postbox.service.PostboxService;
import com.sp.product.model.vo.PageInfo;

/**
 * Servlet implementation class NoticeFaqListController
 */
@WebServlet("/faqList.no")
public class NoticeFaqListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFaqListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 페이징 처리 //
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		// 현재 총 게시글 수
		listCount = new NoticeService().selectFaqListCount();
		
		// 현재 페이지
		currentPage = Integer.parseInt(request.getParameter("faqListPage"));
		
		// 최대 페이징 개수
		pageLimit = 10;
		
		// 페이지에서 보여질게시글 수
		boardLimit = 10;
		
		// 가장 마지막 페이지 체크
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		// 페이징 수
		startPage = (currentPage-1)/pageLimit*pageLimit+1;
		
		// 페이지 하단에 보여질 끝 수
		endPage = startPage+pageLimit-1;
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		ArrayList<Faq> list = new NoticeService().selectNoticeFaqList(pi);
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/notice/FAQ.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
