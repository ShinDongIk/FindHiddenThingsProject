<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList,
    		com.sp.product.model.vo.PageInfo,
    		com.sp.notice.model.vo.Questions,
    		com.sp.notice.model.vo.QuestionReply"%>
<%@ include file = "/views/common/menubar.jsp"%>
<%
// 	int questionReplyNo = 0;
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	Questions q = (Questions)request.getAttribute("question");
	QuestionReply qr = (QuestionReply)request.getAttribute("questionReply");
	int getQuestionReplyNo = (int)request.getAttribute("getQuestionReplyNo");
	int getQuestionNo = (int)request.getAttribute("questionNo");
	String getQuestionReplyStatus = (String)request.getAttribute("getQuestionReplyStatus");
// 	QuestionReply questionReplyNo = (QuestionReply)request.getAttribute("questionReplyNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- BootStrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet"  type="text/css" href="<%=contextPath %>/resources/css/noticeStyle.css">
</head>
<body>
	<div id="notic_outer">
	
            <div id="notic_content_1">
               
            </div>   

            <div id="notic_content_2">
                <div id="notic_content_2_1">
                    <table>
                        <td><img src="resources/img/집.png" style="height: 30px;"></td>
                        <td>홈 ></td>
                        <td>고객센터 > </td>
                        <td>FAQ</td>
                    </table>
                </div>
                <div id="notic_content_2_2">
                    <h1 style="color: rgb(44, 201, 110);">1:1 문의</h1> 
                </div>   
                <hr>
                <div id="notic_content_2_3" align="center">
                	 <div class="card text-dark bg-light mb-3" style="height:620px; width:800px;">
					    <div class="card-header"><%=q.getQuestionTitle() %></div>
					    <div class="card-header">글쓴이 : <%=q.getUserName() %> / 조회수 : <%=q.getQuestionView() %> / 등록일 : <%=q.getQuestionEnter() %></div>
						    <div class="card-body">
						    <h5>문의 내용</h5>
						    <p class="card-text"><%=q.getQuestionContent() %>  </p>
						    </div>
						    <hr />
						    
						    <%if(qr!=null && qr.getQuestionReplyContent() != null) {%>
						     <div class="card-body">
						     <h5>답변 내용</h5>
						    <p class="card-text"><%=qr.getQuestionReplyContent() %>  </p>
					    	</div>
						    <% } %>
			 		 </div>
                        <hr>
                    <br>
                    <div align="notic_center">
                        <a href="<%=contextPath%>/questions.no?questionsListPage=1&userNo=<%=loginUser.getUserNo() %>" class="btn btn-success">목록</a>
                        <%if(loginUser!=null && loginUser.getUserNo() == 1){%>
                        	<a href="<%=contextPath%>/questionReplyEnrollForm.no?qno=<%=q.getQuestionNo()%>" class="btn btn-success" >답변 등록</a> 
				            <a href="<%=contextPath%>/questionReplyUpdateForm.no?qrno=<%=getQuestionReplyNo%>" class="btn btn-success">답변 수정</a>
				            <a href="<%=contextPath%>/questionReplyDelete.no?qrno=<%=getQuestionReplyNo%>&userNo=<%=loginUser.getUserNo() %>" class="btn btn-success" >답변 삭제</a> <br>
			            <%}%>
                    </div>
                </div> 
            </div>
            
          </div>



</body>
</html>