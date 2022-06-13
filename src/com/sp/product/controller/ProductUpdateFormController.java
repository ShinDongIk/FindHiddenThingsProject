package com.sp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.ProductDetail;
import com.sp.product.model.vo.ProductFile;

@WebServlet("/productUpdate.pr")
public class ProductUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductUpdateFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		
		ProductDetail p = new ProductService().selectProduct(productNo);
		ArrayList<ProductFile> list = new ProductService().selectAttachmentList(productNo);
		
		request.setAttribute("list", list);
		request.setAttribute("p",p);
		request.getRequestDispatcher("views/product/updateProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
