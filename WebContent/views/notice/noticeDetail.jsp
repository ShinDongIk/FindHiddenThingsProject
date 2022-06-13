<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sp.notice.model.vo.Notice"%>
    <%
	
	Notice notice = (Notice)request.getAttribute("notice");
	

%>
     <%@ include file = "/views/common/menubar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- BootStrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<link rel="stylesheet"  type="text/css" href="<%=contextPath %>/resources/css/noticeDetailStyle.css">
</head>
<body>
	<div id="notic_outer">
            <div id="notic_content_1">
               
            </div>   

            <div id="notic_content_2">
                <div id="notic_content_2_1">
                    <table>
                        <td><img src="resources/img/집.png" style="height: 30px;"></td>
                        <td>홈  > </td>
                        <td>고객센터 > </td>
                        <td>FAQ</td>
                    </table>
                </div>
                <div id="notic_content_2_2">
                    <h1 style="color: rgb(44, 201, 110);">공지사항</h1> 
                </div>
                <hr>
                
                 <div class="card text-dark bg-light mb-3" style="height:620px; width:800px;" >
					    <div class="card-header"><%=notice.getNoticeTitle() %></div>
					    <div class="card-header">글쓴이 : <%=notice.getUserNo()%>/ 조회수 : <%=notice.getNoticeView() %> / 등록일 : <%=notice.getNoticeEnter()%></div>
						    <div class="card-body">
						    <p class="card-text"><%=notice.getNoticeContent() %>  </p>
					    </div>
			 		 </div>
                    <br>
                    <div align="center">
                        <a href="<%=contextPath%>/list.no?cpage=1" class="btn btn-success">목록</a>
							<!-- 관리자 아이디 1개로 가정했음 -->
	                     <%if(loginUser!=null && loginUser.getUserId().equals("admin")){%>
				            <a href="<%=contextPath%>/updateForm.no?nno=<%=notice.getNoticeNo()%>" class="btn btn-success" >수정하기</a> 
				            <a href="<%=contextPath%>/delete.no?nno=<%=notice.getNoticeNo()%>" class="btn btn-success" >삭제하기</a> <br>
			            <%}%>
                    </div>
                </div> 
                


</body>
</html>