package com.sp.chat.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.sp.chat.model.dao.ChatDao;
import com.sp.chat.model.vo.Chat;
import com.sp.chat.model.vo.ChatFileInfo;
import com.sp.chat.model.vo.ChatInfo;

import static com.sp.common.JDBCTemplate.*;

public class ChatService {

	public Chat chatRoomSearch(int userNo, int productNo) {
		Connection conn = connect();
		
		Chat c = new ChatDao().chatRoomSearch(conn,userNo,productNo);
		
		close(conn);
		
		return c;
	}

	public int chatRoomCreate(int userNo, int productNo) {
		Connection conn = connect();
		
		int result = new ChatDao().chatRoomCreate(conn,userNo,productNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<ChatInfo> chatRoomSearchAll(int userNo) {
		Connection conn = connect();
		
		ArrayList<ChatInfo> list = new ChatDao().chatRoomSearchAll(conn,userNo);
		
		close(conn);
		
		return list;
	}

	public int insertChatFile(ChatFileInfo cfi) {
		Connection conn = connect();
		
		int result = new ChatDao().insertChatFile(conn,cfi);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ChatFileInfo chatLoad(int chatNo) {
		Connection conn = connect();
		
		ChatFileInfo cfi = new ChatDao().chatLoad(conn,chatNo);
		
		close(conn);
		
		return cfi;
	}

	public int chatExit(int chatNo) {
		Connection conn = connect();
		
		int result = new ChatDao().chatExit(conn,chatNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
