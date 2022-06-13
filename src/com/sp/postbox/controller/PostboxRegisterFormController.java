package com.sp.postbox.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.postbox.model.vo.Company;
import com.sp.postbox.model.vo.ProductList;
import com.sp.postbox.model.vo.Tracking;
import com.sp.postbox.service.PostboxService;

/**
 * Servlet implementation class PostboxNumberRegister
 */
@WebServlet("/PostboxNumberRegister.pb")
public class PostboxRegisterFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostboxRegisterFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardLimit = 5;
		int mapValue = 0;
		HashMap<Integer, String> map = new HashMap<>();
		
		// 버튼 value 가져오기
		for(int i=0; i<boardLimit; i++) {
			map.put(i, request.getParameter("button"+i));
		}
		
		// HashMap에서 null이 아닌 값 가져오기
		for(int i=0; i<boardLimit; i++) {
			if(map.get(i) != null ? true : false) {
				mapValue = Integer.parseInt(map.get(i));
			}
		}
		
		// 택배 회사 목록 조회
		ArrayList<Company> company = new PostboxService().selectCompany();
		request.setAttribute("company", company);
		
		// 상품 불러와 화면에 띄우기
		ProductList product = new PostboxService().selectRegisterProduct(mapValue);
		request.setAttribute("product", product);
		request.getRequestDispatcher("views/postbox/postboxNumberRegister.jsp").forward(request, response);
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub`
		doGet(request, response);
	}

}
