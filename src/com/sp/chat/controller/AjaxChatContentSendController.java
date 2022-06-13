package com.sp.chat.controller;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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

@WebServlet("/chatSend.ch")
public class AjaxChatContentSendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxChatContentSendController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chatContent = request.getParameter("chatContent");
		String userNickName = request.getParameter("userNickName");
		String time = request.getParameter("time");
		int chatNo = Integer.parseInt(request.getParameter("chatNo"));
		
		ChatFileInfo cfi = new ChatService().chatLoad(chatNo);
		
		//파일 내용 저장할 경로
		String path = cfi.getPath()+cfi.getFileName();
		//파일을 작성할 통로 생성
		FileWriter chatFileWrite = new FileWriter(path,true);
		//전달받은 내용으로 파일 내용 작성
		chatFileWrite.write(userNickName+",");
		chatFileWrite.write(chatContent+",");
		chatFileWrite.write(time+",");
		
		//작성 통로 닫음(close()시 내부적으로 flush()(출력 스트림과 버퍼된 출력 바이트를 강제로 쓰게하는 기능)호출)
		chatFileWrite.close();
		
		//txt파일 내용을 담을 공간
		String contentSave = "";
		//변수에 저장한 내용을 객체로 담을 공간
		ChatContent cc = null;
		//객체로 저장한 내용을 ArrayList로 담을 공간
		ArrayList<ChatContent> list = new ArrayList<>();
		
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
		for(int i=0; i<(strArr.length-1);i++) {
			cc=new ChatContent();
			cc.setUserNickName(strArr[i]);
			cc.setChatContent(strArr[++i]);
			cc.setTime(strArr[++i]);
			list.add(cc);
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
