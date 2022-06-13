package com.sp.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.sp.product.model.service.ProductService;
import com.sp.product.model.vo.PickList;

@WebServlet("/productPick.pr")
public class AjaxProductLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxProductLikeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ProductNo = Integer.parseInt(request.getParameter("num"));
		String nickName = request.getParameter("nickName");
		
		PickList pk = new ProductService().productPickSelect(ProductNo,nickName);
		
		String pickBtnText = ""; //btnPick의 Text를 담을 공간
		int pickCount = 0; //현재 찜한 수를 저장할 공간
		
		
		if(pk != null) { // 찜 삭제
			int result = new ProductService().productPickDelete(pk);
			if(result>0) {
				int result2 = new ProductService().productPickDeleteUpdate(ProductNo);
				if(result2>0) {
					pickCount = new ProductService().productPickCount(ProductNo);
					pickBtnText="찜하기";
				}
			}
		}else { // 찜 추가
			int result = new ProductService().productPickInsert(ProductNo,nickName);
			if(result>0) {
				int result2 = new ProductService().productPickAddUpdate(ProductNo);
				if(result2>0) {
					pickCount = new ProductService().productPickCount(ProductNo);
					pickBtnText="찜 중!!";
				}
			}
		}
		
		JSONObject jobj = new JSONObject();
		jobj.put("pickBtnText", pickBtnText);
		jobj.put("pickCount", pickCount);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jobj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
