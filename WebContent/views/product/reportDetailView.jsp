<%@ include file="/views/common/menubar.jsp"%>
<%@page import="com.sp.product.model.vo.Report"%>
<%
	Report r = (Report)request.getAttribute("r");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    



</style>
</head>
<body>
    <body>
        <div id="outer">
      
            <div id="report_content_1">
                <div id="report_content_1_1">
                    <table>
                        <td><img src="<%=contextPath %>/resources/img/집.png" style="height: 30px;"></td>
                        <td><a href="<%=contextPath%>">홈</a> ></td>
                        <td><a href="">마이페이지</a> > </td>
                        <td><a href="">신고관리</a></td>
                        
                    </table>
                </div>  
                <div id="report_content_1_2">
                    <h1 style="color: rgb(44, 201, 110);">신고관리</h1> 
                </div>
                <div id="report_content_2">
                    <div id="report_content_2_1"></div>
                    <div id="report_content_2_2">
                       <table align="center" id="report_table">
                            <tr>
                                <td>신고번호</td>
                                <td><input type="text" readonly value="<%=r.getReportNo()%>"></td>
                            </tr>
                            <tr>
                                <td>신고자 아이디</td>
                                <td><input type="text" readonly value="<%=r.getReporterId()%>"></td>
                            </tr>
                            <tr>
                                <td>피신고자 아이디</td>
                                <td><input type="text" readonly value="<%=r.getReportedId()%>"></td>
                            </tr>
                            <tr>
                                <td>신고사유</td>
                                <td><input type="text" readonly value="<%=r.getReportTab()%>"></td>
                            </tr>
                            <tr>
                                <td colspan="2">신고내용</td>
                            </tr>
                            
                            <tr>
                                <td colspan="2">
                                    <textarea name="" id="" cols="40" rows="10" readonly style="resize: none;"><%=r.getReportContent() %></textarea>
                                </td>  
                            </tr>
                       </table>
                       <div align="center">
                           <a href="<%=contextPath %>/ReportListView.re?pNum=1" class="btn btn-success">목록</a>
                       </div>
    
                    </div>
                    
                </div>
                   
                    
                
                  
      
            </div>     
           
          </div>   
    </body>
</body>
</html>