package com.sp.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sp.notice.model.service.NoticeService;
import com.sp.notice.model.vo.Questions;
import com.sp.product.model.vo.PageInfo;

/**
 * Servlet implementation class NoticeOneononeListController
 */
@WebServlet("/questions.no")
public class NoticeQuestionsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeQuestionsListController() {
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
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		if(userNo > 1) { // 관리자가 아닐때 userNo로 조회
			listCount = new NoticeService().userQuestionsListCount(userNo);
		} else { // 관리자일때 전체 조회
			listCount = new NoticeService().adminQuestionsListCount();
		}
		
		// 현재 페이지
		currentPage = Integer.parseInt(request.getParameter("questionsListPage"));
		
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
		
		ArrayList<Questions> list = new ArrayList<>();
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage, userNo);
		
		if(userNo > 1) { // 관리자가 아닐때 userNo로 조회
			list = new NoticeService().userQuestionList(userNo, pi);
		} else { // 관리자일때 전체 조회
			list = new NoticeService().adminQuestionList(pi);
		}
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/notice/questions.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
