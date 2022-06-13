package com.sp.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.sp.product.model.service.ProductService;

@WebServlet("/buy.pr")
public class AjaxProductBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxProductBuyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int buyUserNo = Integer.parseInt(request.getParameter("buyUserNo"));
		
		int userNo = new ProductService().searchProduct(productNo,buyUserNo);
		JSONObject jobj = new JSONObject();
		response.setContentType("application/json; charset=UTF-8");
		if(userNo==0) { //구매한 내역이 없을때
			int result = new ProductService().productBuy(productNo,buyUserNo);
			
			if(result>0) {
				jobj.put("alert", 1); //"구매를 하셨습니다!! 결제를 진행해 주세요!"
			}
		}else if(userNo>0 && userNo == buyUserNo) { //구매한 내역이 있으면서 로그인 유저와 같을때 // "이미 구매를 하셨습니다!! 결제를 진행해 주세요!"
			jobj.put("alert", 2);
		}else if(userNo>0 && userNo != buyUserNo){ //구매한 내역이 있으면서 로그인 유저와 다를때 // "다른분이 이미 구매를 하셨습니다!! 아쉽지만 다른 물건을 찾아주세요 ㅠㅠ"
			jobj.put("alert", 3);
		}
		
		response.getWriter().print(jobj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
