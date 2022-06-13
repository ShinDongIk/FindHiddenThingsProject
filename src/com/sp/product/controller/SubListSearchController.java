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

@WebServlet("/subListSearch.pr")
public class SubListSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubListSearchController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String categorySub = request.getParameter("categorySub");
		String subKeyword = request.getParameter("subKeyword");

		// 페지징 처리 구문
		int listCount = new ProductService().productSubListCount(category,subKeyword); // 현재 총게시글 수
		int currentPage = Integer.parseInt(request.getParameter("pNum")); // 현재페이지
		int pageLimit = 10; // 페이징 최대 갯수
		int boardLimit = 12; // 게시물 수

		int maxPage = (int) Math.ceil((double) listCount / boardLimit); // 가장 마지막 페이지 //1
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1; // 페이징 시작 수 //1
		int endPage = startPage + pageLimit - 1; // 페이지당 페이징 끝 수 //10

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageInfo page = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		ArrayList<Product> list = new ProductService().productSelectSubList(category,categorySub,page,subKeyword);

		Member loginUser = (Member) request.getSession().getAttribute("loginUser");

		if (loginUser != null) {
			int userNo = ((Member) request.getSession().getAttribute("loginUser")).getUserNo();
			ArrayList<PickList> plist = new ProductService().productPickLoad(userNo);
			request.setAttribute("plist", plist);
		}
		request.setAttribute("paging", page);
		request.setAttribute("list", list);
		request.setAttribute("category", category);

		request.getRequestDispatcher("/views/product/productListForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
