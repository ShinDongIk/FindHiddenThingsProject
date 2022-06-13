package com.sp.chat.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.sp.chat.model.vo.Chat;
import com.sp.chat.model.vo.ChatFileInfo;
import com.sp.chat.model.vo.ChatInfo;

import static com.sp.common.JDBCTemplate.*;

public class ChatDao {
	
	Properties prop = new Properties();
	
	public ChatDao() {
		String fileName = ChatDao.class.getResource("/db/chat/chat-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Chat chatRoomSearch(Connection conn, int userNo, int productNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Chat c = null;
		
		String sql = prop.getProperty("chatRoomSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, productNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c = new Chat(rset.getInt("CHAT_NO")
						,rset.getString("FIRST_USER_NO")
						,rset.getString("SECOND_USER_NO")
						,rset.getString("PRODUCT_NO")
						,rset.getDate("CHAT_DATE")
						,rset.getString("CHAT_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return c;
	}

	public int chatRoomCreate(Connection conn, int userNo, int productNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertChatList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, productNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ChatInfo> chatRoomSearchAll(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<ChatInfo> list = new ArrayList<>();
		
		String sql = prop.getProperty("chatRoomSearchAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new ChatInfo(rset.getInt("CHAT_NO")
						,rset.getString("SU")
						,rset.getString("BU")
						,rset.getString("PT")
						,rset.getDate("CHAT_DATE")
						,rset.getString("CHAT_STATUS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertChatFile(Connection conn, ChatFileInfo cfi) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertFileInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cfi.getChatNo());
			pstmt.setString(2, cfi.getFileName());
			pstmt.setString(3, cfi.getPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ChatFileInfo chatLoad(Connection conn, int chatNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ChatFileInfo cfi = null;
		
		String sql = prop.getProperty("searchFileInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, chatNo);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cfi = new ChatFileInfo(rset.getInt("FILE_NO")
										,rset.getInt("CHAT_NO")
										,rset.getString("FILE_NAME")
										,rset.getString("FILE_PATH")
										,rset.getDate("UPLOAD_DATE")
										,rset.getString("FILE_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return cfi;
	}

	public int chatExit(Connection conn, int chatNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("deleteChatFile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, chatNo);
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				sql = prop.getProperty("exitChat");
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, chatNo);
				
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		return result;
	}

}
