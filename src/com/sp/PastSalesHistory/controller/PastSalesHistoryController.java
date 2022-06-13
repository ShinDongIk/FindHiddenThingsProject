package com.sp.PastSalesHistory.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sp.PastSalesHistory.model.service.PastSalesHistoryService;
import com.sp.PastSalesHistory.model.vo.PastSalesHistoryList;
import com.sp.product.model.vo.PageInfo;


@WebServlet("/PastSales.pr")
public class PastSalesHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PastSalesHistoryController() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// -- 페이징 처리
		int listCount; //현재 총 게시글 개수
		int currentPage; //현재 페이지 (사용자가 요청한 페이지)
		int pageLimit; //페이지 하단에 보이는 페이징 페이지 최대 개수
		int boardLimit; //한 페이지에서 몇개의 글을 보여줄건지
		
		int maxPage; //가장 마지막 페이지가 몇번페이지인지 (총 페이지수)
		int startPage; // 페이지 하단에 보여질 페이징 시작 수
		int endPage; //페이지 하단에 보여질 페이징 끝 수
		
		//System.out.println(request.getParameter("userNo"));
		
		int userNo = Integer.parseInt(request.getParameter("userNo")); // 클릭한 로그인 유저 넘버
		
		listCount = new PastSalesHistoryService().selectListCount(userNo); //listCount 현재 총 게시글 개수 
		
//		System.out.println(listCount);
		
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		// 1. 조인
		
		// 2. 이미지파일 가져오는 서비스 하나, 상품 정보 가져오는 서비스하나, 채팅 수 가져오는 서비스하나
		
		//하단 몇개인지 
		pageLimit = 10;
		
		//몇개씩 보여주기
		boardLimit = 10;
		
		//maxpage 총 107개 한페이지 표현 10개 -> 11개 
		//listCount 와 boardLimit 영향 받음 (총갯수 표현갯수)
		// 나머지가 있으면 +1 없으면 +0
		// (listCount / boardLimit)+1 하면 딱 나누어 떨어질때도 +1이 되기에
		// 나누고 난 뒤 올림처리 이용해서 계산 (나머지가 있을때만 +1됨)
		//1) listCount를 double형으로 변환            (double)listCount
		//2) listCount/boardLimit           (double)listCount/boardLimit
		//3) 결과를 올림처리 Math.ceil()메소드 호출  Math.ceil((double)listCount/boardLimit)
		//4) 결과값을 다시 int 자료형으로 형변환          (int)Math.ceil((double)listCount/boardLimit)
		
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		//statrPage 페이지 하단에 보여질 페이징 시작 수 
		//pageLimit와 currentPage 에 영향을 받는다 
		//startPage = 1,11,21,31,41 ... 10의 배수 +1
		// 만약 pageLimit을 5로 설정 = 1,6,11,16 ... 5의 배수 +1
		// n * pageLimit+1
		// startPage = 1 n=0*10+1   1   1~10 = 0
		// startPage = 11 n=1*10+1  11 11~20 = 1
		// startPage = 21 n=2*10+1  21 21~30 = 2
		// 0~9 	 / 10 = 0
		// 10~19 / 10 = 1
		// 20~29 / 10 = 2 
		// n= (currentPage-1)/pageLimit
		
		//startPage = n * pageLimit +1
		startPage = (currentPage-1)/pageLimit * pageLimit +1;
		
		//endPage = 페이지 하단에 보여질 페이징 끝 수 
		//startPage, pageLimit에 영향을 받는다
		//pageLimit을 10이라고 가정 했을때
		// startPage=1 endPage=10  pageLimit=10
		// startPage=11 engPage=20 pageLimit=10
		// startPage=21 nedPage=30 pageLimit=10
		
		endPage = startPage+pageLimit -1;
		
				// maxPage 13일 경우 endPage가 20이 나오기 때문에 13으로 변경해주는 처리가 필요함 
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		//페이지 정보들을 요청 처리 보내면 된다. 
		//1. 페이징바를 만들때 필요한 객체
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage, userNo);
		
		//2. 사용자가 요청한 페이지(currentPage)에 보여질 게시글 리스트 요청하기
		ArrayList<PastSalesHistoryList> list = new PastSalesHistoryService().PastSaleList(pi,userNo);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		
		
		

		// 3. list랑 Dao까지 똑같이하고 mapper에서 beetween라인만 빼고
		ArrayList<PastSalesHistoryList> PastlistCount = new  PastSalesHistoryService().HistoryCount(userNo);
		
		// 4. for문 돌려서 list2.getProductStatus()로 Y인지 N인지 확인하기위해 IF문
//		System.out.println(PastlistCount);
		int saleIngCount = 0;
		int saleFinishCount =0;
		
		for(PastSalesHistoryList b : PastlistCount) {
			if(b.getProductSellStatus().equals("Y")) {
				saleIngCount = saleIngCount+1;
			
			}else {
				saleFinishCount = saleFinishCount+1;
			}
			
		}
//		System.out.println(saleIngCount);
//		System.out.println(saleFinishCount);
		
		//판매중
		request.setAttribute("saleIngCount", saleIngCount);
		//판매완료
		request.setAttribute("saleFinishCount", saleFinishCount);
		
		
		request.getRequestDispatcher("views/pastSalesHistory/PastSalesHistory.jsp").forward(request, response);

	}
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
