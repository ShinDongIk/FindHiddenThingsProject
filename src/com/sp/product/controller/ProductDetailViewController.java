package com.sp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.Product;
import com.sp.product.model.vo.ProductDetail;
import com.sp.product.model.vo.ProductFile;

@WebServlet("/ProductDetail.pr")
public class ProductDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductDetailViewController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int productNo = Integer.parseInt(request.getParameter("pno"));	
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int result = new ProductService().increaseCount(productNo);
		
		if(result>0) {
			ProductDetail p = new ProductService().selectProduct(productNo);
			ArrayList<ProductFile> list = new ProductService().selectAttachmentList(productNo);
			
			boolean pick = new ProductService().amIPcik(productNo,userNo);
			
			if(pick) {
				request.setAttribute("amIpick", "찜 중!!");
			}else {
				request.setAttribute("amIpick", "찜하기");
			}
			request.setAttribute("p",p);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/product/productDetailForm.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
