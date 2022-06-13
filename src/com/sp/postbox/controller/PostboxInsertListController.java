package com.sp.postbox.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sp.postbox.model.vo.FileList;
import com.sp.postbox.model.vo.ProductList;
import com.sp.postbox.service.PostboxService;
import com.sp.product.model.vo.PageInfo;

@WebServlet("/PostboxNumberList.pb")
public class PostboxInsertListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostboxInsertListController() {
        super();
    }

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
		int userNo;
		
		// 현재 총 게시글 수
		listCount = new PostboxService().selectListCount();
		
		// 현재 페이지
		currentPage = Integer.parseInt(request.getParameter("postboxListPage"));
		
		// 최대 페이징 개수
		pageLimit = 10;
		
		// 페이지에서 보여질게시글 수
		boardLimit = 5;
		
		// 가장 마지막 페이지 체크
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		// 페이징 수
		startPage = (currentPage-1)/pageLimit*pageLimit+1;
		
		// 페이지 하단에 보여질 끝 수
		endPage = startPage+pageLimit-1;
		
		userNo = Integer.parseInt(request.getParameter("userNo"));
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage,userNo);
		ArrayList<ProductList> list = new PostboxService().selectViewList(pi);
		
		// 이미지 출력을 위한 PRODUCT_NO 배열에 담기
		int[] pno = new int[boardLimit];
		int cnt = 0;
		for(ProductList pl : list) {
			pno[cnt] = pl.getProductNo();
			cnt++;
		}
		
		// PRODUCT_NO 조건으로 이미지 검색
		ArrayList<ProductList> imageList = new PostboxService().selectImageList(pno);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/postbox/postboxNumberList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
