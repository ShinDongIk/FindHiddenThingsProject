package com.sp.postbox.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.product.model.vo.PageInfo;
import com.sp.postbox.model.vo.ProductList;
import com.sp.postbox.model.vo.TrackingList;
import com.sp.postbox.service.PostboxService;

/**
 * Servlet implementation class PostboxTrackingListController
 */
@WebServlet("/PostboxTrackingList.pb")
public class PostboxTrackingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostboxTrackingListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				listCount = new PostboxService().selectTrackingListCount();
				
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
				
				PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
				
				ArrayList<ProductList> list = new PostboxService().selectTrackingViewList(pi);
				
				// 이미지 출력을 위한 PRODUCT_NO 배열에 담기
				int[] pno = new int[boardLimit];
				int cnt = 0;
				for(ProductList pl : list) {
					pno[cnt] = pl.getProductNo();
					cnt++;
				}
				
				// PRODUCT_NO 조건으로 이미지 검색
				ArrayList<TrackingList> imageList = new PostboxService().selectTrackingImageList(pno);
				
				// 구매자 조회 페이지 생성
				// PRODUCT_NO 조건으로 구매자 회원 번호 가져오기
//				ArrayList<ProductList> buyerNo = new PostboxService().selectBuyerNo(pno);
//				
//				// 구매자 USER_NO 가져오기
//				int[] bno = new int[boardLimit];
//				int cnt2 = 0;
//				for(ProductList pl : buyerNo) {
//					bno[cnt2] = pl.getUserNo();
//					System.out.println(bno[cnt2]);
//					cnt2++;
//				}
				
				// 구매한 물품들만 조회하기
//				ArrayList<ProductList> list2 = new PostboxService().buyerTrackingViewList(pi,userNo);
				ArrayList<ProductList> list2 = new PostboxService().buyerTrackingViewList(pi,userNo);
				request.setAttribute("pi", pi);
				request.setAttribute("pno", pno);
				request.setAttribute("list", list2);
				request.getRequestDispatcher("views/postbox/postboxTrackingList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
