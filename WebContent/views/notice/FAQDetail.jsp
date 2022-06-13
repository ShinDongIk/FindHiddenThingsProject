<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sp.notice.model.vo.Faq"%>
<%@ include file = "/views/common/menubar.jsp"%>
<%
	Faq f = (Faq)request.getAttribute("faq");
%>
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
                        <td>홈 ></td>
                        <td>고객센터 > </td>
                        <td>FAQ</td>
                    </table>
                </div>
                <hr>
                <div id="notic_content_2_2">
                    <h1 style="color: rgb(44, 201, 110);">FAQ(자주 묻는 질문)</h1> 
                </div> 
                <hr>  
                <div id="notic_content_2_3" align="center">
	                <div class="card text-dark bg-light mb-3" style="height:620px; width:800px;">
					    <div class="card-header"><%=f.getFaqTitle() %></div>
					    <div class="card-header">글쓴이 : <%=f.getUserName() %> / 조회수 : <%=f.getFaqView() %> / 등록일 : <%=f.getFaqEnter() %></div>
						    <div class="card-body">
						    <p class="card-text"><%=f.getFaqContent() %>  </p>
					    </div>
			 		 </div>
                
<!--                     <table id="notic_detail-area"  style="height:620px; width:800px; border:1px solid black;" > -->
<!-- <!--                         <tr> --> 
<!-- <!--                             <th colspan="4"><b>결제 취소는 어떻게 하나요?</b></th> --> 
<!-- <!--                         </tr> --> 
<!--                         <tr> -->
<%--                             <th colspan="4"><b><%=f.getFaqTitle() %></b></th> --%>
<!--                         </tr> -->
                    
                    
<!--                         <tr id="notic_count" style="height:50px; width:350px;"> -->
<%--                             <td width="40%" align="center" style="text-align: right;"><%=f.getUserName() %></td> --%>
<!--                             <td width="10%" style="text-align: right;">조회수</td> -->
<%--                             <td width="5%"><%=f.getFaqView() %></td> --%>
<%--                             <td width="40px"><%=f.getFaqEnter() %></td> --%>
<!--                         </tr> -->
<!--                         <tr> -->
<!--                             <td colspan="4" id="noticeContent"> -->
<%--                            		<%=f.getFaqContent() %>      --%>
<!--                             </td> -->
<!--                         </tr> -->
<!--                     </table> -->


                    <br>
                    

                    <div align="center">
                        <a href="<%=contextPath%>/faqList.no?faqListPage=1" class="btn btn-success">목록</a>
                        <%if(loginUser!=null && loginUser.getUserNo() == 1){%>
				            <a href="<%=contextPath%>/faqUpdateForm.no?fno=<%=f.getFaqNo()%>" class="btn btn-success" >수정하기</a> 
				            <a href="<%=contextPath%>/faqDelete.no?fno=<%=f.getFaqNo()%>" class="btn btn-success" >삭제하기</a> <br>
			            <%}%>
                    </div>
                </div> 
            </div>
            
          </div>


</body>
</html>