<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.ArrayList,com.sp.notice.model.vo.Notice,com.sp.product.model.vo.PageInfo,java.util.ArrayList,com.sp.notice.model.vo.Notice"%>
    <%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>    
<%
	PageInfo pi =(PageInfo)request.getAttribute("pi");
	
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
 <%@ include file = "/views/common/menubar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet"  type="text/css" href="resources/css/noticeStyle.css">
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
                        <td><a href="">공지사항</a></td>
                    </table>
                </div>
                <div id="notic_content_2_2">
                    <h1 style="color: rgb(44, 201, 110);">공지사항</h1>                    
                </div>
                <div id="notic_content_2_3">
                    <table align="center" id="notic_noticeList"  class="table-hover">
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
                            
                           
				     		<%if(list.isEmpty()){%>
				            		<tr>
				            			<td colspan="5">존재하는 공지사항이 없습니다.</td>
				            		</tr>
				            <%}else{%>
							
							<!-- 비어있지 않을 경우 -->
				            <%for(Notice n : list) {%>
				                <tr>
				                    <td><%=n.getNoticeNo()%></td>
				                    <td><%=n.getNoticeTitle() %></td>
				                    <td><%=n.getUserNo() %></td>
				                    <td><%=n.getNoticeEnter() %></td>
				                    <td><%=n.getNoticeView() %></td>
				                </tr>
				          	<%}%>
				          <%} %>
                        </tbody>
                    </table>
                    <br><br>
                    
                    
                    <form action="test.do" id="notic_subSerch_form" align="center">
                    </form>
                      <%if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
                    <div id="notic_writeBtn"  align="right" >
                        <button class="btn btn-success" onclick="location.href='<%=contextPath %>/enrollForm.no'">글작성</button>
                        
                        </div>
                        <%} %>
                            <script>
    				   $(function(){

       				     $(".table-hover>tbody>tr").click(function(){
           			     var nno = $(this).children().eq(0).text(); //공지사항글 번호
           			     location.href='<%=contextPath%>/detail.no?nno='+nno;
          		
            });

        });


    </script>
                    <br>
                    <div class="page_wrap" align="center">
                    <div class="page_nation">
                        <%if(pi.getCurrentPage()!=1){ %>
                    <a class="arrow prev" onclick="location.href='<%=contextPath%>/list.no?cpage=<%=currentPage-1%>'"><</a>
                    <%} %>  
                    <%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++){ %>
                       <a class="active" onclick="location.href='<%=contextPath%>/list.no?cpage=<%=i%>'"><%=i%></a>
                    <%} %>
                    <%if(pi.getCurrentPage()!=pi.getMaxPage()){ %>
                       <a class="arrow next" onclick="location.href='<%=contextPath%>/list.bo?cpage=<%=currentPage+1%>'">></a>
                    </div>
                    <%} %> 
                 </div>
</body>
</html>