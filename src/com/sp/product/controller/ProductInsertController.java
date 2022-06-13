package com.sp.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.sp.common.MyFileRenamePolicy;
import com.sp.member.model.vo.Member;
import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.Product;
import com.sp.product.model.vo.ProductFile;


@WebServlet("/Insert.th")
public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 10 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/product_upfile/");
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy()); 
			
			
			
			Product p = new Product();
			
			p.setUserNo(Integer.parseInt(multiRequest.getParameter("userNo")));
			p.setProductTitle(multiRequest.getParameter("productTitle"));
//			p.setProductPrice(multiRequest.getParameter("productPrice"));
			p.setProductPrice(Integer.parseInt(multiRequest.getParameter("productPrice")));
			p.setProductContent(multiRequest.getParameter("productContent"));
			p.setCategory(multiRequest.getParameter("category"));
			p.setProductTransaction(multiRequest.getParameter("deal"));
		
			ArrayList<ProductFile> list = new ArrayList<>();
						
				String key = "file";
				
				if(multiRequest.getOriginalFileName(key)!=null) {
					ProductFile pf = new ProductFile();
					
					pf.setFileOriginName(multiRequest.getOriginalFileName(key));
					pf.setFileChangeName(multiRequest.getFilesystemName(key));
					pf.setFilePath("resources/product_upfile/");
					
					list.add(pf);
				}
			
			
			int result = new ProductService().insertProduct(p,list);
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "판매글이 등록되었습니다.");
				response.sendRedirect(request.getContextPath());
			}else {
				request.setAttribute("errorMsg", "판매글 등록 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
