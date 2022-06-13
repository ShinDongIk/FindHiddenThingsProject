package com.sp.payment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.member.model.vo.Member;
import com.sp.payment.model.service.PaymentService;
import com.sp.payment.model.vo.Payment;

@WebServlet("/paymentList.pa")
public class AjaxPaymentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxPaymentListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		String impUid = request.getParameter("impUid");
		String merchantUid = request.getParameter("merchantUid");
		String applyNo = request.getParameter("applyNo");
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		
		
		Payment p = new Payment();
		
		p.setBuyerNo(userNo);
		p.setImpUid(impUid);
		p.setMerchantUid(merchantUid);
		p.setApplyNo(applyNo);
		p.setProductNo(productNo);
		
		int result = new PaymentService().insertPaymentList(p);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
