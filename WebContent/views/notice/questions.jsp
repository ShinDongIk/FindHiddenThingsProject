<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList
    		,com.sp.product.model.vo.PageInfo
    		,com.sp.notice.model.vo.Questions"%>
<%@ include file = "/views/common/menubar.jsp"%>
<%
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Questions> list = (ArrayList<Questions>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
                        <td><a href="">홈</a> ></td>
                        <td><a href="">고객센터</a> > </td>
                        <td><a href="">1:1문의</a></td>
                    </table>
                </div>
                <div id="notic_content_2_2">
                    <h1 style="color: rgb(44, 201, 110);">1 : 1 문의</h1> 
                </div>
                <div id="notic_content_2_3">
                    <table align="center" id="notic_noticeList"  class="notic_table-hover">
                        <thead>
                            <tr>
                                <th width="100">글번호</th>
                                <th width="400">제목</th>
                                <th width="100">작성자</th>
                                <th width="100">작성일</th>
                                <th width="100">조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<%if(list.isEmpty()) { %>
                        		<tr>
                        			<td colspan="5">존재하는 1:1 문의가 없습니다.</td>
                        		</tr>
                        	<% } else { %>
		                        <% for(Questions q : list) { %>
		                            <tr>
		                                <td><%=q.getQuestionNo() %></td>
		                                <td><%=q.getQuestionTitle() %></td>
		                                <td><%=q.getUserName() %></td>
		                                <td><%=q.getQuestionEnter() %></td>
		                                <td><%=q.getQuestionView() %></td>
		                            </tr>
								<% } %>                        
                        	<% } %>
                        </tbody>
                    </table>
                    <script>
	                    $(function(){
	     				     $(".notic_table-hover>tbody>tr").click(function(){
	         			     var qno = $(this).children().eq(0).text();
	         			     location.href='<%=contextPath%>/questionsDetail.no?userNo='+<%=loginUser.getUserNo()%>+'&qno='+qno;
	          						});
	     				});
                    </script>
                    <br><br>
                    <br>
                  	<%if(loginUser!=null){%>
	                    <div id="notic_writeBtn"  align="right" >
	                        <button onclick="location.href='<%=contextPath %>/questionEnrollForm.no'" class="btn btn-success">글작성</button>
	                    </div>
                    <% } %>
                    <div class="page_wrap">
                        <div class="page_nation">
<%-- 	                        <%if(pi.getCurrentPage()!=1){ %> --%>
<%-- 	                        <a class="arrow prev" onclick="location.href='<%=contextPath%>/questions.no?questionsListPage=<%=pi.getCurrentPage()-1%>'"><</a> --%>
<%-- 		                    <%} %>   --%>
		                    <%if(pi.getCurrentPage() != 1) { %>
							<form action="<%=contextPath%>/questions.no?questions.no?questionsListPage=<%=pi.getCurrentPage()-1%>" id="btn_form1" class="btn_form">
								<input type="hidden" name="userNo" value="<%=pi.getUserNo() %>" />	
								<input type="hidden" name="questionsListPage" value="<%=pi.getCurrentPage()-1%>">
								<a class="arrow prev" onclick="document.getElementById('btn_form1').submit();">&lt;</a>
							</form>
							<% } %>
<%-- 		                    <%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++){ %> --%>
<%-- 		                       <a class="active" onclick="location.href='<%=contextPath%>/questions.no?questionsListPage=<%=i%>'"><%=i%></a> --%>
<%-- 		                    <%} %> --%>
		                    
		                    <%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++) { %>
							<%if(i != pi.getCurrentPage()) { %>
								<form action="<%=contextPath%>/questions.no?questionsListPage=<%=i%>" id="btn_form2" class="btn_form">
									<input type="hidden" name="userNo" value="<%=pi.getUserNo() %>" />
									<input type="hidden" name="questionsListPage" value="<%=i%>">
									<a class="active" onclick="document.getElementById('btn_form2').submit();"><%=i %></a>
								</form>
							<% } else {%>
								<form action="" class="btn_form">
									<a disabled><%=i %></a>
								</form>
							<% } %>
						<% } %>
<%-- 		                    <%if(pi.getCurrentPage()!=pi.getMaxPage()){ %> --%>
<%-- 		                       <a class="arrow next" onclick="location.href='<%=contextPath%>/questions.no?questionsListPage=<%=pi.getCurrentPage()+1%>'">></a> --%>
<%-- 		                    <%} %>  --%>
		                    
		                <%if(pi.getCurrentPage() != pi.getMaxPage()) { %>
							<form action="<%=contextPath%>/questions.no?questionsListPage=<%=pi.getCurrentPage()+1%>" id="btn_form3" class="btn_form">
								<input type="hidden" name="userNo" value="<%=pi.getUserNo() %>" />
								<input type="hidden" name="questionsListPage" value="<%=pi.getCurrentPage()+1%>">
								<a class="arrow next" onclick="document.getElementById('btn_form3').submit();">&gt;</a>
							</form>
						<% } %>
		                    
                        </div>
                     </div>
                </div>
            </div>
        </div>


</body>
</html>