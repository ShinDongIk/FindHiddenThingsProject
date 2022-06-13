package com.sp.postbox.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.postbox.model.vo.Company;
import com.sp.postbox.model.vo.Tracking;
import com.sp.postbox.service.PostboxService;

/**
 * Servlet implementation class PostboxRegisterInsertController
 */
@WebServlet("/PostboxNumberInsert.pb")
public class PostboxRegisterInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostboxRegisterInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 상품 이름으로 상품 번호 조회
		String productName = (String)request.getParameter("productName");
		Tracking productNo = new PostboxService().selectProductNo(productName);
		
		// 송장번호 등록 (조회는 jQuery)
		Long trackingNumber = Long.parseLong(request.getParameter("trakingNumber"));
//		int trackingNumber = Integer.parseInt(request.getParameter("trakingNumber"));
		String postboxCompany = (String)request.getParameter("postboxCompany");
		int buyerNo = Integer.parseInt(request.getParameter("buyerNo"));

		Tracking tk = new Tracking(trackingNumber, productNo.getProductNo(), postboxCompany, buyerNo);
		
		int insertNumber = new PostboxService().InsertTracking(tk);
//		int insertPurchase = new PostboxService().InsertPurchase(tk);
		
		// 택배사 코드 가져오기
//		Company cp = new Company();
//		int selectCompanyCode = new PostboxService().selectCompanyCode(tk.getPostboxCompany(), tk.getProductNo());
		
		if(insertNumber>0) {
//			request.setAttribute("product", product);
//			request.getRequestDispatcher("views/postbox/postboxNumberRegister.jsp").forward(request, response);
			request.getSession().setAttribute("alertMsg", "운송장 등록이 정상적으로 처리 되었습니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			// 아직 구현 X, 등록 실패시
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
