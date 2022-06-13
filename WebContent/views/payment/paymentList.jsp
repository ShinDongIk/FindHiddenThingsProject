<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sp.payment.model.vo.*,java.util.ArrayList,com.sp.product.model.vo.PageInfo"%>
<%
	ArrayList<Payment> list = (ArrayList<Payment>)request.getAttribute("list");
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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<title>숨은 물건 찾기</title>
<%@ include file="/views/common/menubar.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/paymentListStyle.css">
</head>
<body>
	<div id="pay_outer">
      <div id="pay_content_1">
         
      </div>   

      <div id="pay_content_2">
          <div id="pay_content_2_1">
              <table id="pay_table-css">
                  <td><img src="<%=contextPath %>/resources/img/집.png" style="height: 30px;"></td>
                  <td><a href="">홈</a> ></td>
                  <td><a href="">마이페이지</a> > </td>
                  <td><a href="PayListForm.pa?cpage=1">결제 목록</a></td>
              </table>
    
          </div>
          <div id="pay_content_2_2">
              <h1 style="color: rgb(44, 201, 110);">결제 목록</h1> 
          </div>
           <div id="pay_content_2_3">
              <table class="pay_table" align="center" id="itemtable">
                  <thead>
                     <tr align="center">
                         <th>상품번호</th>
                         <th>상품명</th>
                         <th>상품가격</th>                        
                         <th>이름</th>
                         <th>회원번호</th>
                         <th>거래고유번호</th>
                         <th>결제고유번호</th>
                         <th>카드승인번호</th>
                         <th>결제일</th>
                         
                     </tr>
                  </thead>
                  <tbody> 
                  <%if(list.isEmpty()) {%>
                  		<tr>
                  			<td colspan="9">결제정보가 없습니다.</td>
                  		</tr> 
                  <%}else{ %>	
                  
                  <%for(Payment p:list) {%>	    
                    <tr> 
                        <td><%=p.getProductNo() %></td>
                        <td><%=p.getProductTitle() %></td>
                        <td><%=p.getProductPrice() %></td>                       
                        <td><%=p.getBuyerName() %></td>
                        <td><%=p.getBuyerNo() %></td>
                        <td><%=p.getMerchantUid() %></td>
                        <td><%=p.getImpUid() %></td>
                        <td>
                        	<%if(p.getApplyNo() != null){ %>
                        		<%=p.getApplyNo() %>
                        	<%}else{%>
                        		카카오페이
                        	<%}%>
                        </td>    
                        <td><%=p.getPayDate() %></td>
                    </tr>  
                  <%} %>  
                  <%} %>                        
                  </tbody>
              </table>
              
          </div>
          <br>
          <form action="" class="pay_table-form" align="center">
                    <input type="hidden" name="cpage" value="${param.cpage}">
                    <select name="searchTab" id="searchTab"> 
                        <option value="product_no">상품번호</option> 
                         <option value="merchant_uid">거래번호</option> 
                        <option value="imp_uid">결제번호</option>
                    </select> 
                    <script>
                        const param__searchTab = '${param.searchTab}';

                        if( param__searchTab ){
                            $('select[name="searchTab"]').val(param__searchTab);
                        }                      
                    </script>
                    <input type="text" name="input" id="input" value="${param.input}" style="width: 300px;"> 
                    <input type="submit" class="btn btn-success" value="검색">
                
          </form>
          
          
          <div id="pay_content_2_4" align="center">
          	<%if(currentPage!=1){ %>
            <a onclick="location.href='<%=contextPath%>/PayListForm.pa?cpage=<%=currentPage-1%>'">&lt;</ㅁ>
            <%} %>
            
            <%for(int i = startPage; i<=endPage; i++){ %>
            	<%if(i!=currentPage){ %>
	            	<a onclick="location.href='<%=contextPath%>/PayListForm.pa?cpage=<%=i%>'"><%=i %></a>	            
	            <%}else{ %>
	             	<a disabled><%=i %></a>
	            <%} %>
	            <%} %>
            
            <%if(currentPage!=maxPage){ %>
            <a onclick="location.href='<%=contextPath%>/PayListForm.pa?cpage=<%=currentPage+1%>'">&gt;</a>
            <%} %>
          
          </div>
</body>
</html>