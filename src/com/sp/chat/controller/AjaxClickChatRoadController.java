package com.sp.chat.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sp.chat.model.service.ChatService;
import com.sp.chat.model.vo.ChatContent;
import com.sp.chat.model.vo.ChatFileInfo;

@WebServlet("/chatClickLoad.ch")
public class AjaxClickChatRoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxClickChatRoadController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int chatNo = Integer.parseInt(request.getParameter("chatNo"));
		
		ChatFileInfo cfi = new ChatService().chatLoad(chatNo);

		//txt파일 내용을 담을 공간
		String contentSave = "";
		//변수에 저장한 내용을 객체로 담을 공간
		ChatContent cc = null;
		//객체로 저장한 내용을 ArrayList로 담을 공간
		ArrayList<ChatContent> list = new ArrayList<>();
				
		
		//파일 경로
		String path = cfi.getPath()+cfi.getFileName();
		
		
		//파일 내용 읽어들일 통로 생성
		FileReader chatFileRead = new FileReader(path);
				
		//chatFileRead에 2byte 단위로 읽어올 내용을 담을 공간
		int result = 0; 
		while((result=chatFileRead.read())!=-1) {
			//반복하여 char형으로 변환하여  contentSave에 담음
			contentSave+=(char)result;
		}
				
		//","단위로 문자열을 잘라 배열에 저장
		String[] strArr = contentSave.split(",");

		//strArr을 반복하여 객체에 담고 그것을 list에 담음(ps.(strArr.length-1)한 이유는 마지막","뒤에도 읽히기 때문)
		if(strArr.length>0) {
			for(int i=0; i<(strArr.length-1);i++) {
				cc=new ChatContent();
			
				cc.setUserNickName(strArr[i]);
				cc.setChatContent(strArr[++i]);
				cc.setTime(strArr[++i]);
	
				list.add(cc);
			}
		}	
		//contentType을 맞춰주고 인코딩 설정(한글때문에)
		response.setContentType("application/json; charset=UTF-8");
		//GSON을 이용하여 JSON방식으로 변환하여 list를 전달하여 응답
		new Gson().toJson(list,response.getWriter());
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
