package com.sp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.sp.member.model.vo.Member;
import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.PageInfo;
import com.sp.product.model.vo.Product;


@WebServlet("/PurchaseList.pu")
public class PurchaseListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PurchaseListController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		int listCount = new ProductService().purchaseListCount(userNo);
		int currentPage = Integer.parseInt(request.getParameter("pNum"));
		int pageLimit = 10;
		int boardLimit = 6;
		int maxPage = (int)(Math.ceil((double)listCount/boardLimit));
		int startPage = (currentPage-1)/pageLimit*pageLimit+1;
		int endPage = startPage + pageLimit - 1;
		
		if(endPage>maxPage) {
	    	endPage=maxPage;
	    }
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		ArrayList<Product> list = new ProductService().purchaseList(userNo,pi);
		ArrayList<Product> list2 = new ProductService().purchaseFileName(userNo);
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("views/product/purchaseList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
