package com.sp.chat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.chat.model.service.ChatService;
import com.sp.chat.model.vo.ChatInfo;

@WebServlet("/chatExit.ch")
public class ChatExitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChatExitController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int chatNo = Integer.parseInt(request.getParameter("chatNo"));
		
		int result = new ChatService().chatExit(chatNo);
		
		if(result>0) {
			ArrayList<ChatInfo> list = new ChatService().chatRoomSearchAll(userNo);
			if(!list.isEmpty()) {
				request.setAttribute("list", list);
			}
			
			request.getSession().setAttribute("alertMsg","체팅방을 정상적으로 나가셨습니다!");
			request.getRequestDispatcher("/views/chat/chatingForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
