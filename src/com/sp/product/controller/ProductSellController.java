package com.sp.product.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.product.model.service.ProductService;

@WebServlet("/sell.ch")
public class ProductSellController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductSellController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String category = request.getParameter("category");
		
		int result = new ProductService().productSell(productNo);
		
		if(result>0) {
			request.getSession().setAttribute("alert", "판매완료처리 되었습니다!");
			String encodedParam = URLEncoder.encode(category, "UTF-8"); //한글깨짐으로 인한 url에 한글을 담을시 인코딩 변환
			response.sendRedirect(request.getContextPath()+"/productListForm.pr?category="+encodedParam+"&pNum=1");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
