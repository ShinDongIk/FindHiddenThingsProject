<%@page import="com.sp.product.model.vo.PageInfo"%>
<%@page import="com.sp.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/menubar.jsp"%>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
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
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/productPickList.css">
</head>
<body>
	<div id="outer">
      <div id="content_1">
         
      </div>   

      <div id="pickList_content_2">
          <div id="pickList_content_2_1">
              <table>
                  <td><img src="<%=contextPath %>/resources/img/집.png" style="height: 30px;"></td>
                  <td><a href="">홈</a> ></td>
                  <td><a href="">마이페이지</a> > </td>
                  <td><a href="">찜한 목록</a></td>
              </table>
            </div>  
          <div id="pickList_content_2_2">
              <h1 style="color: rgb(44, 201, 110);">찜한 목록</h1> 
          </div>
             
              
          </div id="pickList_content_3">
                <table id="pick_list">
                    <tbody>
                    <%if(!list.isEmpty()){%>
                 	  <%for(int i=0; i<list.size(); i++){%>
                        <tr>
                            <td align="center">
                                <a href="<%=contextPath%>/ProductDetail.pr?pno=<%=list.get(i).getProductNo() %>&userNo=<%=loginUser.getUserNo()%>">
                                    <img src="<%=contextPath%>/resources/product_upfile/<%=list.get(i).getChangeFileName() %>" style="width: 242px; height: 212px;"><br>
                                    <span class="title"><%=list.get(i).getProductTitle() %></span><br>
                                    <span class="price"><%=list.get(i).getProductPrice() %> 원</span><br>
                                    <span class="nickname"><%=list.get(i).getUserNickName() %></span>
                                </a>
                            </td>
                        </tr>
					<%} %>
     				  <%}else{ %>   
     				  		<br><br><br><br><br>              
							<h3 style="text-align:center">찜한 물품이 없습니다!</h3>
						<%} %>
                    </tbody>
                </table>
          		<br><br>
          		
          		<div id="pickList_content_3_1" align="center">
		          	<%if(currentPage!=1){ %>
		            <a onclick="location.href='<%=contextPath%>/pickList.pr?pNum=<%=currentPage-1%>'">&lt;</ㅁ>
		            <%} %>
		            
		            <%for(int i = startPage; i<=endPage; i++){ %>
		            	<%if(i!=currentPage){ %>
			            	<a onclick="location.href='<%=contextPath%>/pickList.pr?pNum=<%=i%>'"><%=i %></a>	            
			            <%}else{ %>
			             	<a disabled><%=i %></a>
			            <%} %>
			            <%} %>
		            
		            <%if(currentPage!=maxPage){ %>
		            <a onclick="location.href='<%=contextPath%>/pickList.pr?pNum=<%=currentPage+1%>'">&gt;</a>
		            <%} %>
          
          		</div>
            </div>
            

        </div>     
     
    </div>    
	      
	
	          
	      

</body>
</html>