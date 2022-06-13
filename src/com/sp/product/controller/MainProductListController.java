package com.sp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.Product;

@WebServlet("/mainList.pr")
public class MainProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainProductListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		System.out.println(category);
		
		ArrayList<Product> list = new ProductService().mainProductSelectList(category);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/mainPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
