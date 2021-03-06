package com.sp.payment.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sp.payment.model.service.PaymentService;
import com.sp.payment.model.vo.Payment;
import com.sp.product.model.vo.PageInfo;

/**
 * Servlet implementation class PayListFormController
 */
@WebServlet("/PayListForm.pa")
public class PayListFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayListFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new PaymentService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)(Math.ceil((double)listCount/boardLimit));
		startPage = (currentPage-1)/pageLimit*pageLimit+1;
		endPage = startPage + pageLimit-1;
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		
		String searchTab = request.getParameter("searchTab");
		String input = request.getParameter("input");
		
		
		
	
		ArrayList<Payment> list = new PaymentService().selectPaymentList(pi,searchTab,input);
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);

		request.getRequestDispatcher("/views/payment/paymentList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
