<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.ArrayList,
		    com.sp.postbox.model.vo.Company,
		    com.sp.postbox.model.vo.ProductList"%>
<% 
	ArrayList<Company> company = (ArrayList<Company>)request.getAttribute("company");
	ProductList product = (ProductList)request.getAttribute("product");
%>
<%@ include file="/views/common/menubar.jsp" %> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/postboxNumberRegister.css">
	<script
	  src="https://code.jquery.com/jquery-3.2.1.min.js"
	  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	  crossorigin="anonymous"></script>
	<script>
	</script>
    <title>숨은 물건 찾기</title>
</head>
<body>
    <div class="wrap">
        <div id="content">
            <div id="content_1">
                <br>
                <img src="<%=contextPath %>/resources/img/집.png" alt="" /> <b>홈 > 마이페이지 > 택배 운송장 등록</b>
				<hr>
				<b class="tn-register-title">택배 운송장 등록</b>
				
            </div>
			<div id="content_2">
					<%if(loginUser!=null){%>
						<br>
						<table class="tn-list-main table table-bordered table-hover">
			            	<thead>
			            		<tr>
			            			<th>상품정보</th>
			            			<th>판매 금액</th>
			            			<th>등록일</th>
			            			<th>구매자 아이디</th>
			            			<th>받은 찜</th>
			            			<th>조회수</th>
			            		</tr>
			            	</thead>
			            	<tbody>
			           			<tr>
			            			<td>
			            				<div class="tn-list-divBorder">
				            			<a href="#" class="img-block">
				            				<img src="<%=contextPath %>/<%=product.getTitleImg()%>" alt="" />
				            			</a>
				            			<ul class="tn-list-bullet">
				            				<li><a href="#"><b><%=product.getProductTitle() %></b></a></li>
				            				<li><p><%=product.getProductContent() %></p></li>
				            			</ul>
				            		</div>
			            			</td>
			           				<td><%=product.getProductPrice() %></td>
			           				<td><%=product.getProductDate() %></td>
			           				<td><%=product.getUserName() %></td>
			           				<td><%=product.getProductPick() %></td>
			           				<td><%=product.getProductViews() %></td>
			           			</tr>
							</tbody>
						</table>
						<br>
						<form action="<%=contextPath%>/PostboxNumberInsert.pb" method="post" >
							 <input type="hidden" name="buyerNo" value="<%=product.getUserNo()%>">
							<div class="content_2_1 row mb-3 justify-content-center">	
							  <label for="inputEmail3" class="col-sm-2 col-form-label">상품이름</label>
							  <div class="col-sm-4">
								<input type="text" name="productName" class="form-control" id="inputEmail3" value="<%=product.getProductTitle() %>" readonly>
							  </div>
							</div>
							
							<div class="row mb-3 justify-content-center">
							  <label for="inputPassword3" class="col-sm-2 col-form-label" >송장번호</label>
							  <div class="col-sm-4">
								<input type="text" name="trakingNumber" id="invoiceNumberText" name="invoiceNumberText" class="form-control" id="inputPassword3">
							  </div>
							</div>
		
							<div class="row mb-3 justify-content-center">
								<label for="specificSizeSelect" class="col-sm-2 col-form-label" >택배회사</label>
							  <div class="col-sm-4">
								  <select class="form-select"  name="postboxCompany" aria-label="Default select example"> 
								  <option selected >택배 회사를 선택해주세요.</option>
							  		<%for(Company c : company) { %>
								  		<option value="<%=c.getCompanyName() %>"> <%=c.getCompanyName() %>  </option>
							  		<% } %>
							  		</select> 
							  </div>
							</div>
		
							<br>
							<div class="d-grid gap-2 d-md-flex justify-content-center">
								<button type="submit" id="trackerButton" class="btn btn-outline-success" >등록하기</button>
								<button type="button" class="btn btn-outline-danger">등록취소</button>
							  </div>
						</form>
						<%} else { %>
							<br /><br />
			           		<p style="color:red; font-size:30px; text-align:center;">비회원은 상품을 등록할 수 없습니다.</p>
			           	<% } %>
				</div>
            <div id="content_3">
            </div>
            <div id="content_4">
        </div>
        <script type="text/javascript" src="<%=contextPath %>/resources/js/menubar.js"></script>
        
<div>
	<table id="myPtag"></table>
</div>
<br/>
<div>
	<table id="myPtag2"></table>
</div>
    </body>
</html>