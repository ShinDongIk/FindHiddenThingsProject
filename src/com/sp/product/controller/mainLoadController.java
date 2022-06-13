package com.sp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.member.model.vo.Member;
import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.PageInfo;
import com.sp.product.model.vo.PickList;
import com.sp.product.model.vo.Product;

@WebServlet("/mainLoad.pr")
public class mainLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public mainLoadController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		
		ArrayList<Product> list = new ProductService().productMainList(category);

		Member loginUser = (Member)request.getSession().getAttribute("loginUser");

		if(loginUser!= null) {
			int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
			ArrayList<PickList> plist = new ProductService().productPickLoad(userNo);
			request.setAttribute("plist", plist);
		}
		request.setAttribute("list",list);
		request.setAttribute("category",category);
		
		request.getRequestDispatcher("mainPage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
