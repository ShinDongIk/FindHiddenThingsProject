<%@page import="com.sp.product.model.vo.PageInfo"%>
<%@ include file="/views/common/menubar.jsp"%>
<%@page import="com.sp.product.model.vo.Report"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Report> list = (ArrayList<Report>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/reportList.css">
</head>
<body>
    <div id="outer">

        <div id="reportList_content_1">
            <div id="reportList_content_1_1">
                <table>
                    <td><img src="<%=contextPath %>/resources/img/집.png" style="height: 30px;"></td>
                    <td><a href="">홈</a> ></td>
                    <td><a href="">마이페이지</a> > </td>
                    <td><a href="">신고관리</a></td>
                </table>
            </div> 
            <br>
            <div id="reportList_content_1_2">
                <h1 style="color: rgb(44, 201, 110);">신고관리</h1> 
            </div>
            <br><br><br>
            <div id="purchaseList_content_1_3" align="center">
                <table id="reportTable" class="table table-hover" >              
                    <thead>
                        <tr align="center">
                            <th>신고번호</th>
                            <th>신고자아이디</th>
                            <th>피신고자아이디</th>
                            <th>신고사유</th>
                            <th>신고날짜</th>                            
                        </tr>
                    </thead>
                    
                    <tbody>
                    <%if(!list.isEmpty()){%>
                    	<%for(int i=0; i<list.size(); i++){%>
                        <tr align="center">
                            <input type="hidden" value="<%=list.get(i).getReportNo() %>">
                            <td><%=list.get(i).getReportNo() %></td>
                            <td><%=list.get(i).getReporterId() %></td>
                            <td><%=list.get(i).getReportedId() %></td>
                            <td><%=list.get(i).getReportTab() %></td>
                            <td><%=list.get(i).getReportDate() %></td>
                        </tr>
                        <%} %>
     				    <%}else{ %>   
     				  		<br><br><br><br><br>              
							<td colspan="6" align="center">신고내역이 없습니다.</td>
 						<%} %>
                   
 					
                    </tbody>
                </table>
                <br><br>
 
            </div>

            <div id="purchaseList_content_2" align="center">
                <%if(currentPage!=1){ %>
              <a onclick="location.href='<%=contextPath%>/ReportListView.re?pNum=<%=currentPage-1%>'">&lt;</a>
              <%} %>
              
              <%for(int i = startPage; i<=endPage; i++){ %>
                  <%if(i!=currentPage){ %>
                      <a onclick="location.href='<%=contextPath%>/ReportListView.re?pNum=<%=i%>'"><%=i %></a>	            
                  <%}else{ %>
                       <a disabled><%=i %></a>
                  <%} %>
                  <%} %>
              
              <%if(currentPage!=maxPage){ %>
                      <a onclick="location.href='<%=contextPath%>/ReportListView.re?pNum=<%=currentPage+1%>'">&gt;</a>
              <%} %>   
            </div>
        </div>           
      </div>


      <script>
          $("#reportTable>tbody>tr").click(function(){
                location.href="<%=contextPath%>/ReportDetail.re?rno="+$(this).children().val();
          });
      </script>
</body>
</html>