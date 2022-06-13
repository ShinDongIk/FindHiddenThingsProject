package com.sp.product.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.sp.common.MyFileRenamePolicy;
import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.ProductDetail;
import com.sp.product.model.vo.ProductFile;

@WebServlet("/productUpdating.pr")
public class ProductUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int fileSize = 10*1024*1024;
			
			String path = request.getSession().getServletContext().getRealPath("/resources/product_upfile/");
			
			MultipartRequest multiRequest = new MultipartRequest(request,path,fileSize,"UTF-8",new MyFileRenamePolicy());
			
			int productNo = Integer.parseInt(multiRequest.getParameter("productNo"));
			String productTitle = multiRequest.getParameter("productTitle");
			int productPrice = Integer.parseInt(multiRequest.getParameter("productPrice"));
			String deal = multiRequest.getParameter("deal");
			String category = multiRequest.getParameter("category");
			String productContent = multiRequest.getParameter("productContent");
			int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));
			
			ProductDetail pd = new ProductDetail(productNo,productTitle,productPrice,category,deal,productContent);
			ProductFile pf = null;
			
			if(multiRequest.getOriginalFileName("file") != null) {
				pf = new ProductFile();
				
				pf.setFileOriginName(multiRequest.getOriginalFileName("file"));
				pf.setFileChangeName(multiRequest.getFilesystemName("file"));
				pf.setFilePath("resources/product_upfile/");
				
				pf.setFileNo(Integer.parseInt(multiRequest.getParameter("fileNo"))); 
				new File(path+multiRequest.getParameter("originFileName")).delete();
			}
			
			int result = new ProductService().updateProduct(pd,pf);
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "게시글 수정을 성공했습니다!");
				response.sendRedirect(request.getContextPath()+"/ProductDetail.pr?userNo="+userNo+"&pno="+productNo);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
