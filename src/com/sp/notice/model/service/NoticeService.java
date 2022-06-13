package com.sp.notice.model.service;
import static com.sp.common.JDBCTemplate.close;
import static com.sp.common.JDBCTemplate.commit;
import static com.sp.common.JDBCTemplate.connect;
import static com.sp.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;


import com.sp.notice.model.dao.NoticeDao;
import com.sp.notice.model.vo.Faq;
import com.sp.notice.model.vo.Notice;
import com.sp.notice.model.vo.QuestionReply;
import com.sp.notice.model.vo.Questions;
import com.sp.product.model.vo.PageInfo;

public class NoticeService {

public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		
		Connection conn = connect();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn,pi);
		
		close(conn);
		
		return list;
		
	}

		public int insertNotice(Notice n) {
			Connection conn = connect();
			
			int result = new NoticeDao().insertNotice(conn,n);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		}
		public int increaseCount(int noticeNo) {
			Connection conn = connect();
			
			int result = new NoticeDao().increaseCount(conn,noticeNo);
			
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			return result;
			
		}
	public Notice selectNotice(int noticeNo) {
			
			Connection conn = connect();
			
			Notice n=new NoticeDao().selectNotice(conn,noticeNo);
			
			close(conn);
			
			return n;
		}
	
	public int updateNotice(Notice n) {
		Connection conn = connect();
		
		int result=new NoticeDao().updateNotice(conn,n);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	public int deleteNotice(int noticeNo) {
		Connection conn = connect();
		
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
		
		if(result>0) { //성공했으면 
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int selectListCount() {
		Connection conn = connect();
		
		int listCount = new NoticeDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	
	
	
	
	
	
	public ArrayList<Faq> selectNoticeFaqList(PageInfo pi) {
		Connection conn = connect();
		
		ArrayList<Faq> list = new NoticeDao().selectNoticeFaqList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public int selectFaqListCount() {
		Connection conn = connect();
		
		int listCount = new NoticeDao().selectFaqListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public int faqIncreaseCount(int faqNo) {
		Connection conn = connect();
		
		int result = new NoticeDao().faqIncreaseCount(conn,faqNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	public Faq selectFaq(int faqNo) {
		Connection conn = connect();
		
		Faq f=new NoticeDao().selectFaq(conn,faqNo);
		
		close(conn);
		
		return f;
	}

	public int faqInsertNotice(Faq f) {
		Connection conn = connect();
		
		int result = new NoticeDao().faqInsertNotice(conn,f);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Faq selectFaqUpdateForm(int faqNo) {
		Connection conn = connect();
		
		Faq f=new NoticeDao().selectFaqUpdateForm(conn,faqNo);
		
		close(conn);
		
		return f;
	}

	public int updateFaq(Faq f) {
		Connection conn = connect();
		
		int result = new NoticeDao().faqUpdate(conn,f);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteBoard(int faqNo) {
		Connection conn = connect();
		
		int result = new NoticeDao().faqDelete(conn,faqNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int userQuestionsListCount(int userNo) {
		Connection conn = connect();
		
		int listCount = new NoticeDao().userQuestionsListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int adminQuestionsListCount() {
		Connection conn = connect();
		
		int listCount = new NoticeDao().adminQuestionsListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Questions> userQuestionList(int userNo, PageInfo pi) {
		Connection conn = connect();
		
		ArrayList<Questions> list = new NoticeDao().userQuestionList(conn, userNo, pi);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Questions> adminQuestionList(PageInfo pi) {
		Connection conn = connect();
		
		ArrayList<Questions> list = new NoticeDao().adminQuestionList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int questionIncreaseCount(int questionNo) {
		Connection conn = connect();
		
		int result = new NoticeDao().questionIncreaseCount(conn,questionNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Questions selectQuestion(int questionNo) {
		Connection conn = connect();
		
		Questions q= new NoticeDao().selectQuestion(conn,questionNo);
		
		close(conn);
		
		return q;
	}

	public ArrayList<QuestionReply> questionReplySelect(int questionNo) {
		Connection conn = connect();
		
		ArrayList<QuestionReply> list= new NoticeDao().questionReplySelect(conn,questionNo);
		
		close(conn);
		
		return list;
	}

	public int questionInsertNotice(Questions q) {
		Connection conn = connect();
		
		int result = new NoticeDao().insertQuestion(conn,q);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteQuestionReply(int questionReplyNo) {
		Connection conn = connect();
		
		int result = new NoticeDao().deleteQuestionReply(conn,questionReplyNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertQuestionReply(QuestionReply qr) {
		Connection conn = connect();
		
		int result = new NoticeDao().insertQuestionReply(conn,qr);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public QuestionReply selectQuestionReplyUpdateForm(int questionReplyNo) {
		Connection conn = connect();
		
		QuestionReply qr=new NoticeDao().selectQuestionReplyUpdateForm(conn,questionReplyNo);
		
		close(conn);
		
		return qr;
	}

	public int updateQuestionReply(QuestionReply qr) {
		Connection conn = connect();
		
		int result = new NoticeDao().updateQuestionReply(conn,qr);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public QuestionReply questionReplyNoSelect(int questionNo) {
		Connection conn = connect();
		
		QuestionReply qrn= new NoticeDao().questionReplyNoSelect(conn,questionNo);
		
		close(conn);
		
		return qrn;
	}

	public QuestionReply questionReplySelectOne(int questionNo) {
		Connection conn = connect();
		
		QuestionReply qr= new NoticeDao().questionReplySelectOne(conn,questionNo);
		
		close(conn);
		
		return qr;
	}


}
