<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		 import="java.util.ArrayList,
		 		 com.sp.postbox.model.vo.Company,
		 		 com.sp.postbox.model.vo.ProductList,
		 		 com.sp.postbox.model.vo.FileList,
		 		 com.sp.product.model.vo.PageInfo"%>
<% 
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<ProductList> list = (ArrayList<ProductList>)request.getAttribute("list");
	ArrayList<FileList> imageList = (ArrayList<FileList>)request.getAttribute("imageList");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int num = 0;
	int[] pno = new int[5];
%>
<%@ include file="/views/common/menubar.jsp" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- BootStrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<!-- js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	
	<!-- 제작한 css, js 불러오기 -->
	<link rel="stylesheet" type="text/css" href="./resources/css/postboxNumberList.css">
	<script src="./resources/js/postboxNumberlist.js"></script>
    <title>숨은 물건 찾기</title>
</head>
<body>
    <div class="wrap">
    <%if(loginUser!=null){%>
        <div id="content">
            <div id="content_1">
                <br>
                <img src="<%=contextPath %>/resources/img/집.png" alt="" /> <b>홈 > 마이페이지 > 택배 운송장 조회</b>
				<hr>
                <p>
                    <img src="<%=contextPath %>/resources/img/체크.png" alt=""> <b>운송장을 조회할 상품을 선택해주세요.</b>
                </p>
				<br>
            </div>
            <div id="content_2">
                <form action="<%=contextPath%>/PostboxTracking.pb">
                <table class="tn-list-main table table-bordered table-hover">
	            	<thead>
	            		<tr>
	            			<th>상품정보</th>
	            			<th>판매 금액</th>
	            			<th>등록일</th>
	            			<th>구매자 아이디</th>
	            			<th>운송장 번호</th>
	            			<th>택배회사</th>
							<th>선택</th>
	            		</tr>
	            	</thead>
	            	<tbody>
		            	<%if(list.isEmpty()) {%>
		            		<tr>
		            			<td colspan="7">구매중인 상품이 없습니다.</td>
		            		</tr>
		            	<% } else { %>
		            		<%for(ProductList pl : list) { %>
		            			<tr>
			            			<td>
			            				<div class="tn-list-divBorder">
				            			<a href="#" class="img-block">
				            				<img src="<%=contextPath %>/<%=pl.getTitleImg()%>" alt="" />
				            			</a>
				            			<ul class="tn-list-bullet">
				            				<li><a href="#"><b><%=pl.getProductTitle() %></b></a></li>
				            				<li><p><%=pl.getProductContent() %></p></li>
				            			</ul>
				            		</div>
			            			</td>
		            				<td><%=pl.getProductPrice() %></td>
		            				<td><%=pl.getProductDate() %></td>
		            				<td><%=pl.getUserName() %></td>
		            				<td><%=pl.getPostboxNumber() %></td>
		            				<td><%=pl.getPostboxCompanyName() %></td>
		            				<td><button type="submit" name="button<%=num %>" class="btn btn-primary" value="<%=pl.getPostboxNumber()%>" location.href="<%=contextPath%>/PostboxTracking.pb">조회하기</button></td> 
		            				
		            				<%
		            				pno[num] = pl.getProductNo();
		            				num++; 
		            				%>
		            			</tr>
		            		<% } %>
		            	<% } %>
		            	
	            	</tbody>
	            </table>
			</form>

            </div>
            <div id="content_3">
                <form action="test.do" id="subSerch_form">
                    <div id="subSerch_cate">
                        <select name="" id="cateSub" style="cursor: pointer;">
                            <option value="">제목</option>
                            <option value="">판매자</option>
                            <option value="">금액</option>
                        </select>
                    </div>
                    <div id="subSerch_text">
                        <input type="search" name="subKeyword" id="sk" placeholder="찾으실 내용을 입력해주세요!">
                    </div>
                    <div id="subSerch_btn">
                        <input type="submit" value="검색">
                    </div>
                </form>
            </div>
            <div id="content_4">
	            <div class="">
            		<div class="" align="center">
						<%if(currentPage != 1) { %>
							<button class="" onclick="location.href='<%=contextPath%>/PostboxNumberList.pb?postboxListPage=<%=currentPage-1%>'">&lt;</button>
						<% } %>
						
						<%for(int i=startPage; i<=endPage; i++) { %>
							<%if(i != currentPage) { %>
								<button onclick="location.href='<%=contextPath%>/PostboxNumberList.pb?postboxListPage=<%=i%>'"><%=i %></button>
							<% } else {%>
								<button disabled><%=i %></button>
							<% } %>
						<% } %>
						
						<%if(currentPage != maxPage) { %>
							<button class="" onclick="location.href='<%=contextPath%>/PostboxNumberList.pb?postboxListPage=<%=currentPage+1%>'">&gt;</button>
						<% } %>
					</div>
	            </div>
            </div>
            <%} else { %>
				<br /><br />
           		<p style="color:red; font-size:30px; text-align:center;">비회원은 상품을 조회할 수 없습니다.</p>
           	<% } %>
        </div>
        <script type="text/javascript" src="<%=contextPath%>/resources/js/menubar.js"></script>
        
        
    </body>
</html>