package com.sp.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.Report;

@WebServlet("/InsertReportList.re")
public class InsertReportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertReportListController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int respondentUserNo = Integer.parseInt(request.getParameter("respondentUserNo"));
		int reporterUserNo = Integer.parseInt(request.getParameter("reporterUserNo"));
		String reportTab = request.getParameter("reportTab");
		String reportContent = request.getParameter("reportContent");
		
		
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		Report r = new Report();
		
		r.setRespondentUserNo(Integer.parseInt(request.getParameter("respondentUserNo")));
		r.setReporterUserNo(Integer.parseInt(request.getParameter("reporterUserNo")));
		r.setReportTab(request.getParameter("reportTab"));
		r.setReportContent(request.getParameter("reportContent"));
		
		int result = new ProductService().insertReport(r);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "신고 완료");
			response.sendRedirect(request.getContextPath()+"/ProductDetail.pr?pno="+pno+"&userNo="+reporterUserNo);
		}else {
			request.setAttribute("errorMsg", "신고에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
