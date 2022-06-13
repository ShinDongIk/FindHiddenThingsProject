<%@page import="com.sp.product.model.vo.PageInfo"%>
<%@page import="com.sp.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/menubar.jsp"%>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
 	ArrayList<Product> list2 = (ArrayList<Product>)request.getAttribute("list2"); 
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
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/purchaseList.css">
</head>
<body>
    <div id="outer">
        <div id="content_1">
           
        </div>   
  
        <div id="purchaseList_content_2">
            <div id="purchaseList_content_2_1">
                <table>
                    <td><img src="<%=contextPath %>/resources/img/집.png" style="height: 30px;"></td>
                    <td><a href="">홈</a> ></td>
                    <td><a href="">마이페이지</a> > </td>
                    <td><a href="">지난 구매 내역</a></td>
                </table>
            </div> 

            <div id="purchaseList_content_2_2">
                <h1 style="color: rgb(44, 201, 110);">지난 구매 내역</h1> 
            </div>
            <br><br><br>
            <div id="purchaseList_content_2_3" align="center">
                <table id="purchaseTable" class="table table-hover" >              
                    <thead>
                        <tr align="center">
                            <th>게시글번호</th>
                            <th>상품사진</th>
                            <th>상품명</th>
                            <th>상품가격</th>
                            <th>판매자닉네임</th>
                            <th>결제일</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                    <%if(!list.isEmpty()){%>
                    	<%for(int i=0; i<list.size(); i++){%>
                        <tr align="center">
                            <input type="hidden" value="<%=list.get(i).getProductNo() %>">
                            <td><%=list.get(i).getProductNo() %></td>
                            <td>
                                <img style="width: 60px; height: 60px;" src="<%=contextPath%>/resources/product_upfile/<%=list2.get(i).getChangeFileName() %>" alt="">
                            </td>
                            <td><%=list.get(i).getProductTitle() %></td>
                            <td width="100"><%=list.get(i).getProductPrice() %></td>
                            <td width="230"><%=list.get(i).getUserNickName() %></td>
                            <td width="150">
                            	<%if(list.get(i).getPayDate() != null){ %>
                            		<%=list.get(i).getPayDate() %>
                            	<%}%>
                            </td>
                        </tr>
                    <%} %>
     				    <%}else{ %>   
     				  		<br><br><br><br><br>              
							<td colspan="6" align="center">구매한 상품이 없습니다.</td>
 						<%} %>
                    </tbody>
                </table>
                <br><br>
          		
                <div id="purchase_list_content_3_1" align="center">
                    <%if(currentPage!=1){ %>
                  <a onclick="location.href='<%=contextPath%>/PurchaseList.pu?pNum=<%=currentPage-1%>'">&lt;</a>
                  <%} %>
                  
                  <%for(int i = startPage; i<=endPage; i++){ %>
                      <%if(i!=currentPage){ %>
                          <a onclick="location.href='<%=contextPath%>/PurchaseList.pu?pNum=<%=i%>'"><%=i %></a>	            
                      <%}else{ %>
                           <a disabled><%=i %></a>
                      <%} %>
                      <%} %>
                  
                  <%if(currentPage!=maxPage){ %>
                  		<a onclick="location.href='<%=contextPath%>/PurchaseList.pu?pNum=<%=currentPage+1%>'">&gt;</a>
                  <%} %>
        
                </div>
                
            </div>
        </div>     
       
      </div>
      <script>
          $("#purchaseTable>tbody>tr").click(function(){
                location.href="<%=contextPath%>/ProductDetail.pr?pno="+$(this).children().val()+"&userNo=<%=loginUser.getUserNo()%>";
          });
      </script>
      
</body>
</html>