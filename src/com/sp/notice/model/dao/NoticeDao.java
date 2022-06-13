package com.sp.notice.model.dao;
import static com.sp.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.sp.notice.model.vo.Faq;
import com.sp.notice.model.vo.Notice;
import com.sp.notice.model.vo.QuestionReply;
import com.sp.notice.model.vo.Questions;
import com.sp.product.model.vo.PageInfo;


public class NoticeDao {
	private Properties prop = new Properties();

	
	public NoticeDao() {
		String fileName = NoticeDao.class.getResource("/db/notice/notice-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi) {
		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO")  
									,rset.getString("NOTICE_TITLE")
									,rset.getString("USER_ID")  
									,rset.getDate("NOTICE_ENTER")
									,rset.getInt("NOTICE_VIEW")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public int insertNotice(Connection conn, Notice n) {
	int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, Integer.parseInt(n.getUserNo()));
			
			result=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int increaseCount(Connection conn, int noticeNo) {
	
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
		
	}




	public Notice selectNotice(Connection conn, int noticeNo) {
	
		Notice n = null;
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		
		String sql=prop.getProperty("selectNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				n=new Notice(rset.getInt("NOTICE_NO")
							,rset.getString("NOTICE_TITLE")
							,rset.getString("NOTICE_CONTENT")
							,rset.getString("USER_ID")
							,rset.getInt("NOTICE_VIEW")
							,rset.getDate("NOTICE_ENTER"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return n;
	}

	public int updateNotice(Connection conn, Notice n) {
		
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateNotice");
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	
	
	public int deleteNotice(Connection conn, int noticeNo) {
	
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			result=pstmt.executeUpdate();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	public int selectListCount(Connection conn) {
		int listCount = 0; 
		
		PreparedStatement pstmt = null;
		
		ResultSet rset=null;
		
		String sql= prop.getProperty("selectListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT"); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}







public ArrayList<Faq> selectNoticeFaqList(Connection conn, PageInfo pi) {
	ArrayList<Faq> list = new ArrayList<>();
	
	PreparedStatement pstmt = null;
	
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectNoticeFaqList");
	
	try {
		pstmt = conn.prepareStatement(sql);
		int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			list.add(new Faq(rset.getInt("FAQ_NO")  
								,rset.getString("FAQ_TITLE")
								,rset.getString("FAQ_CONTENT")  
								,rset.getInt("USER_NO")  
								,rset.getString("USER_NAME")  
								,rset.getDate("FAQ_ENTER")
								,rset.getInt("FAQ_VIEW")
								,rset.getString("FAQ_STATUS")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(rset);
		close(pstmt);
	}
	
	return list;
	}



	public int selectFaqListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String sql = prop.getProperty("selectFaqListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount=rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCount;
	}
	
	
	
	public int faqIncreaseCount(Connection conn, int faqNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("faqIncreaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, faqNo);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Faq selectFaq(Connection conn, int faqNo) {
		Faq f = null;
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		
		String sql=prop.getProperty("selectFaq");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, faqNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				f=new Faq(rset.getInt("FAQ_NO")
							,rset.getString("FAQ_TITLE")
							,rset.getString("FAQ_CONTENT")
							,rset.getString("USER_ID")
							,rset.getDate("FAQ_ENTER"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return f;
	}

	public int faqInsertNotice(Connection conn, Faq f) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("faqInsertNotice");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getFaqTitle());
			pstmt.setString(2, f.getFaqContent());
			pstmt.setInt(3, f.getUserNo());
			
			result=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public Faq selectFaqUpdateForm(Connection conn, int faqNo) {
		Faq f = null;
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		
		String sql=prop.getProperty("selectFaqUpdateForm");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, faqNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				f=new Faq(rset.getInt("FAQ_NO")
							,rset.getString("FAQ_TITLE")
							,rset.getString("FAQ_CONTENT")
							,rset.getInt("USER_NO")
							,rset.getDate("FAQ_ENTER"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return f;
	}



	public int faqUpdate(Connection conn, Faq f) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateFaq");
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, f.getFaqTitle());
			pstmt.setString(2, f.getFaqContent());
			pstmt.setInt(3, f.getFaqNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public int faqDelete(Connection conn, int faqNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteFaq");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faqNo);
			
			result = pstmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;	
	}



	public int userQuestionsListCount(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String sql = prop.getProperty("userQuestionsListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount=rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCount;
	}



	public int adminQuestionsListCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String sql = prop.getProperty("adminQuestionsListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount=rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCount;
	}



	public ArrayList<Questions> userQuestionList(Connection conn, int userNo, PageInfo pi) {
		ArrayList<Questions> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("userQuestionList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Questions(rset.getInt("QUESTION_NO")  
									,rset.getString("QUESTION_TITLE")
									,rset.getString("QUESTION_CONTENT")  
									,rset.getInt("USER_NO")  
									,rset.getString("USER_NAME")  
									,rset.getDate("QUESTION_ENTER")
									,rset.getInt("QUESTION_VIEW")
									,rset.getString("QUESTION_STATUS")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public ArrayList<Questions> adminQuestionList(Connection conn, PageInfo pi) {
		ArrayList<Questions> list = new ArrayList<>();
			
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("adminQuestionList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Questions(rset.getInt("QUESTION_NO")  
									,rset.getString("QUESTION_TITLE")
									,rset.getString("QUESTION_CONTENT")  
									,rset.getInt("USER_NO")  
									,rset.getString("USER_NAME")  
									,rset.getDate("QUESTION_ENTER")
									,rset.getInt("QUESTION_VIEW")
									,rset.getString("QUESTION_STATUS")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int questionIncreaseCount(Connection conn, int questionNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("questionIncreaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, questionNo);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public Questions selectQuestion(Connection conn, int questionNo) {
		Questions q = null;
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		
		String sql=prop.getProperty("selectQuestion");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, questionNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				q=new Questions(rset.getInt("QUESTION_NO")
							,rset.getString("QUESTION_TITLE")
							,rset.getString("QUESTION_CONTENT")
							,rset.getString("USER_ID")
							,rset.getDate("QUESTION_ENTER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return q;
	}



	public ArrayList<QuestionReply> questionReplySelect(Connection conn, int questionNo) {
		ArrayList<QuestionReply> list = new ArrayList<>();
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		
		String sql=prop.getProperty("questionReplySelect");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, questionNo);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new QuestionReply(rset.getInt("QUESTION_NO")
							,rset.getInt("QUESTION_REPLY_NO")
							,rset.getInt("USER_NO")
							,rset.getString("USER_ID")
							,rset.getString("QUESTION_REPLY_CONTENT")
							,rset.getDate("QUESTION_REPLY_ENTER")
							,rset.getString("QUESTION_REPLY_STATUS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}



	public int insertQuestion(Connection conn, Questions q) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQuestion");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q.getQuestionTitle());
			pstmt.setString(2, q.getQuestionContent());
			pstmt.setInt(3, q.getUserNo());
			
			result=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public int deleteQuestionReply(Connection conn, int questionReplyNo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteQuestionReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, questionReplyNo);
			
			result = pstmt.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;	
	}



	public int insertQuestionReply(Connection conn, QuestionReply qr) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQuestionReply");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, qr.getQuestionNo());
			pstmt.setString(2, qr.getQuestionReplyContent());
			pstmt.setInt(3, qr.getUserNo());
			
			result=pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public QuestionReply selectQuestionReplyUpdateForm(Connection conn, int questionReplyNo) {
		QuestionReply qr = null;
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		
		String sql=prop.getProperty("selectQuestionReplyUpdateForm");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, questionReplyNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				qr=new QuestionReply(rset.getInt("QUESTION_REPLY_NO")
									,rset.getInt("QUESTION_NO")
									,rset.getString("QUESTION_REPLY_CONTENT")
									,rset.getString("USER_ID")
									,rset.getDate("QUESTION_REPLY_ENTER"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return qr;
	}



	public int updateQuestionReply(Connection conn, QuestionReply qr) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateQuestionReply");
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qr.getQuestionReplyContent());
			pstmt.setInt(2, qr.getQuestionReplyNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public QuestionReply questionReplyNoSelect(Connection conn, int questionNo) {
		QuestionReply qrn = null;
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		
		String sql=prop.getProperty("questionReplyNoSelect");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, questionNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				qrn=new QuestionReply(rset.getInt("QUESTION_REPLY_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return qrn;
	}



	public QuestionReply questionReplySelectOne(Connection conn, int questionNo) {
		QuestionReply qr = null;
		ResultSet rset=null;
		PreparedStatement pstmt = null;
		
		String sql=prop.getProperty("questionReplySelectOne");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, questionNo);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				qr=new QuestionReply(rset.getInt("QUESTION_NO")
							,rset.getInt("QUESTION_REPLY_NO")
							,rset.getInt("USER_NO")
							,rset.getString("USER_ID")
							,rset.getString("QUESTION_REPLY_CONTENT")
							,rset.getDate("QUESTION_REPLY_ENTER")
							,rset.getString("QUESTION_REPLY_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return qr;
	}

	

}
