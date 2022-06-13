package com.sp.chat.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.chat.model.service.ChatService;
import com.sp.chat.model.vo.Chat;
import com.sp.chat.model.vo.ChatFileInfo;
import com.sp.chat.model.vo.ChatInfo;

@WebServlet("/ChatForm.ch")
public class ChatingFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChatingFormController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));

		if(request.getParameter("productNo")!=null) {
			int productNo = Integer.parseInt(request.getParameter("productNo"));
			
			Chat c = new ChatService().chatRoomSearch(userNo,productNo);
			
			//파일 내용 저장할 경로
			String path = null;
			String fileName = null;
			String fullPath = null;
			
			ChatFileInfo cfi = null;
			
			if(c==null) {
				int result = new ChatService().chatRoomCreate(userNo,productNo);
				if(result>0) {
					c = new ChatService().chatRoomSearch(userNo,productNo);
					
					//파일 내용 저장할 경로
					path = request.getSession().getServletContext().getRealPath("/resources/chatContent/");
					//파일 이름
					fileName = "chatContent"+c.getChatNo()+".txt";
					//파일 풀 경로
					fullPath = path+fileName;
					//파일을 작성할 통로 생성
					FileWriter chatFileWrite = new FileWriter(fullPath,true);
					
					cfi = new ChatFileInfo(c.getChatNo(),fileName,path);
					
					int fileresult = new ChatService().insertChatFile(cfi);
					
					chatFileWrite.close();
				}
			}
			request.setAttribute("Chat", c);
		}
		ArrayList<ChatInfo> list = new ChatService().chatRoomSearchAll(userNo);
		
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
		}
		
		request.getRequestDispatcher("/views/chat/chatingForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
