package com.sp.postbox.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.postbox.model.vo.Company;
import com.sp.postbox.service.PostboxService;

/**
 * Servlet implementation class PostboxTrackingController
 */
@WebServlet("/PostboxTracking.pb")
public class PostboxTrackingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostboxTrackingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardLimit = 5;
		Long mapValue = 0L;
		HashMap<Integer, String> map = new HashMap<>();
		
		// 버튼 value 가져오기
		for(int i=0; i<boardLimit; i++) {
			map.put(i, request.getParameter("button"+i));
		}
		
		// HashMap에서 null이 아닌 값 가져오기
		for(int i=0; i<boardLimit; i++) {
			if(map.get(i) != null ? true : false) {
				mapValue = Long.parseLong(map.get(i));
//				mapValue = Integer.parseInt(map.get(i));
			}
		}
		
		// 택배사 코드, 회사 이름 가져오기
		Company companyInfo = new PostboxService().selectTrackingCompany(mapValue);
		request.setAttribute("companyInfo", companyInfo);
		request.getRequestDispatcher("views/postbox/postboxTrackingSelect.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
