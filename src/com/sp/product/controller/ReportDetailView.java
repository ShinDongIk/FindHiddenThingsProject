package com.sp.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.Report;


@WebServlet("/ReportDetail.re")
public class ReportDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReportDetailView() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reportNo = Integer.parseInt(request.getParameter("rno"));
		
		Report r = new ProductService().reportDetailView(reportNo);
		
		request.setAttribute("r", r);
		request.getRequestDispatcher("views/product/reportDetailView.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
