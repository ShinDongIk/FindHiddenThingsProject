<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.sp.product.model.vo.*,java.util.ArrayList"%>
<%@ include file="/views/common/menubar.jsp"%>
<%
	ProductDetail p = (ProductDetail)request.getAttribute("p");
	ArrayList<ProductFile> list = (ArrayList<ProductFile>)request.getAttribute("list");
	String amIpick = (String)request.getAttribute("amIpick");

	String loinUserNickName = loginUser.getUserNickName();
	//String userName = loginUser.getUserName();
	//String userPhone = loginUser.getUserPhone();
	
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.8.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>숨은 물건 찾기</title>


<link rel="stylesheet" href="<%=contextPath %>/resources/css/productDeatil.css">
</head>
<body>
	<!--상품상세페이지-->

	<div id="content_1">
		<br> <img src="<%=contextPath %>/resources/img/집.png" alt="" /> <b>홈 > <%=p.getCategory() %></b>
		<hr>
	</div>
	<div id="content_2">
		<div id="content_2_1">
			<div class="product_view">
				<h2><%=p.getProductTitle() %></h2>
				<div class="price">
					<%=p.getProductPrice() %> <b>원</b>
				</div>
				<hr>
				<div id='container'>
					<div id='box-left'>
						<img id="heart_img" src="<%=contextPath %>/resources\img\빈하트.png" alt=""> <span id="pickNum"><%=p.getProductPick() %></span>
						<img id="eye_img" src="<%=contextPath %>/resources\img\eye.png" alt=""> <span><%=p.getProductView() %></span>
					</div>
					<div id='box-center'>
					</div>
					<div id='box-right'>
						<img id="warning_img" src="<%=contextPath %>/resources\img\warning.png" alt="">
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  							신고하기
						</button>
					</div>
				</div>
				<div id="trade_method">
					<li>거래방법 : <%=p.getProductTransaction() %></li>
				</div>
				<div class="img">
					<img src="<%=contextPath%>/resources/product_upfile/<%=list.get(0).getFileChangeName() %>">
			   	</div>
				<div class="btns">
				<%if(!loinUserNickName.equals(p.getUserNickName())){ %>
					<button id="thisPick" class="btn1 pickBtn" onclick="pickClick();"> 
					<%=amIpick %></button> 
					<a href="<%=contextPath %>/ChatForm.ch?userNo=<%=loginUser.getUserNo() %>&productNo=<%=p.getProductNo()%>" class="btn1">채팅하기</a>
					<button id="thisPay" class="btn1 pickBtn" onclick="requestPay();" style="display: none">결제하기</button>
					<button id="thisBuy" class="btn1 buybtn" onclick="buy();">구매하기</button>
				<%}else{ %>
					<a href="<%=contextPath %>/sell.ch?productNo=<%=p.getProductNo()%>&category=<%=p.getCategory() %>" class="btn1">판매완료하기</a>
				<%} %>
				</div>
			</div>
		</div>
		<div id="content_2_2">
			<div class="product_content">
				<pre"><%=p.getProductContent() %></pre>
			</div>
		</div>
	</div>
	<div class="btns_2">
		<%if(loginUser.getUserNickName().equals(p.getUserNickName()) || loginUser.getUserId().equals("admin")){ %>
		<button onClick="updateProduct();">상품수정</button>
		<button onClick="deleteProduct();">상품삭제</button>
		<%}%>
	</div>
	
	<div class="modal" id="myModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">신고하기</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		        <form action="<%=contextPath %>/InsertReportList.re" method="post">
					<input type="hidden" name="respondentUserNo" value="<%=p.getUserNo()%>">
					<input type="hidden" name="reporterUserNo" value="<%=loginUser.getUserNo()%>">
					<input type="hidden" name="pno" value="<%=p.getProductNo()%>">
					<table align="center">
						<tbody>
							<tr>
								<td>
									<h3 style="color: rgb(44, 201, 110);">신고사유</h3>
								</td>
								<td style="padding-bottom: 7px;">
									<select name="reportTab" id="reportTab">
										<option value="욕설">욕설</option>
										<option value="사기">사기</option>
										<option value="허위매물">허위매물</option>
										<option value="불건전한닉네임">불건전한닉네임</option>
										<option value="도배">도배</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<h3 style="color: rgb(44, 201, 110);">신고내용</h3>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<textarea name="reportContent" cols="35" rows="10" style="resize: none;" required></textarea>
								</td>
							</tr>
							
							<tr>
								<td colspan="2" align="center">
									<button class="btn btn-danger">신고하기</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
		      </div>		
		    </div>
		  </div>
		</div>
	
	<script>
		function pickClick(){
	        $.ajax({
	           url : "productPick.pr",
	           data : {
		           num : <%=p.getProductNo()%>,
		           nickName : "<%=loinUserNickName%>"
	           },
	           type : "post",
	           success : function(result){
	        	   $("#thisPick").html(result.pickBtnText);
	        	   $("#pickNum").html(result.pickCount);
	           },
	           error : function() {
	           		console.log("연결 실패");
	           }
	        })
		};  	
	</script>
	<script>
		    IMP.init('imp11574635');  
		    function requestPay() {
		      // IMP.request_pay(param, callback) 결제창 호출
		      IMP.request_pay({ // param
		          pg: "html5_inicis",
		          pay_method: "card",
		          merchant_uid: "me"+new Date().getTime(),
		          name: "<%=p.getProductTitle()%>",
		          amount: <%=p.getProductPrice()%>,
		          buyer_name: "<%=loginUser.getUserName()%>"

		      }, function (rsp) { // callback
			    	  console.log(rsp);
			      if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
			        // jQuery로 HTTP 요청
			        $.ajax({ 
			            url: "paymentList.pa", 
			            method: "POST",	
			            data: {
			                impUid: rsp.imp_uid,
			                merchantUid: rsp.merchant_uid,
			                applyNo: rsp.apply_num,			                
			                productNo: "<%=p.getProductNo()%>"
			            }			            
			        })
			        var msg = '결제가 완료되었습니다. ';			        
			        msg += '결제 금액 : ' + rsp.paid_amount+'원';
			      } else {
			        alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
			      }
			      alert(msg);
			    })
			    };
			    
			    function buy(){
			    	var msg = "";
						$.ajax({ 
				            url: "buy.pr", 
				            method: "POST",	
				            data: {
				            	buyUserNo: <%=loginUser.getUserNo()%>,
				            	productNo: <%=p.getProductNo()%>
				            },		
							success: function(result){
								if(result.alert == 1){
									msg = "구매를 하셨습니다!! 결제를 진행해 주세요!";
									$("#thisPay").css("display","inline-block");
	 								$("#thisBuy").css("display","none");
								}else if(result.alert == 2){
									msg = "이미 구매를 하셨습니다!! 결제를 진행해 주세요!";
									$("#thisPay").css("display","inline-block");
	 								$("#thisBuy").css("display","none");
								}else if(result.alert == 3){
									msg = "다른분이 이미 구매를 하셨습니다!! 아쉽지만 다른 물건을 찾아주세요 ㅠㅠ";
								}
								
 								alert(msg); 
							},
				            error: function() {
								console.log("연결실패");
							}
				        })
				}
     </script>
     <script>
     	function updateProduct() {
     		if(confirm("게시글을 수정하시겠습니까?")){
     			location.href="<%=contextPath%>/productUpdate.pr?productNo=<%=p.getProductNo()%>";
     		}
		}
     	function deleteProduct() {
     		if(confirm("게시글을 삭제하시겠습니까?")){
     			location.href="<%=contextPath%>/productdelete.pr?productNo=<%=p.getProductNo()%>&category=<%=p.getCategory()%>";
     		}
		}
     </script>
	
</body>
</html>