<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
		 import="com.sp.postbox.model.vo.Company"%>
<% 
	Company companyInfo = (Company)request.getAttribute("companyInfo");
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
	<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/postboxTrackingList.css">
	<script
	  src="https://code.jquery.com/jquery-3.2.1.min.js"
	  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	  crossorigin="anonymous">
	</script>
    <title>숨은 물건 찾기</title>
</head>
<body>
    <div class="wrap">
        <div id="content">
            <div id="content_1">
                <br>
                <img src="<%=contextPath %>/resources/img/집.png" alt="" /> <b>홈 > 마이페이지 > 택배 운송장 조회</b>
				<hr>
                    <b class="tn-register-title">택배 운송장 등록</b>
				<br>
            </div>
            <div id="content_2">
	            <div class="postbox_ignore">
		            <%if(loginUser!=null){%>
		            <br />
		                <div class="content_2_1 row mb-3 justify-content-center">	
						  <label for="inputEmail3" class="col-sm-2 col-form-label">택배회사</label>
						  <div class="col-sm-4">
							<input type="text" name="productName" class="form-control" id="inputEmail3" value="<%=companyInfo.getCompanyName() %>" readonly>
						  </div>
						  <label for="inputEmail3" class="col-sm-2 col-form-label">송장번호</label>
						  <div class="col-sm-4">
							<input type="text" name="productName" class="form-control" id="inputEmail3" value="<%=companyInfo.getCompanyNumber() %>" readonly>
						  </div>
						</div>
						<div style="text-align:center">
				            <img src="<%=contextPath %>/resources/img/PostboxList.png" alt="" />
						</div>
			            
			           <script>
				        	// 배송정보와 배송추적 tracking-api
				           $(function() {
				        	   var myKey = "EKL2nAiQVFQ2A7JPt4ZJMQ";
				               $.ajax({
				                   type:"GET",
				                   dataType : "json",
				                   <%if(companyInfo.getCompanyCode() < 10) { %>
					                   url:"http://info.sweettracker.co.kr/api/v1/trackingInfo?t_key="+myKey+"&t_code=0"+<%=companyInfo.getCompanyCode()%>+"&t_invoice="+<%=companyInfo.getCompanyNumber()%>,
				                   <% } else { %>
					                   url:"http://info.sweettracker.co.kr/api/v1/trackingInfo?t_key="+myKey+"&t_code="+<%=companyInfo.getCompanyCode()%>+"&t_invoice="+<%=companyInfo.getCompanyNumber()%>,
				                   <% } %>
				                   success:function(data){
				                	   console.log(data.status);
				                   	var myInvoiceData = "";
				                   	if(data.status == false){
				                   		myInvoiceData += ('<p>'+data.msg+'<p>');
				                   	}
				           			
				                   	
				                   	$("#myPtag").html(myInvoiceData)
				                   	
				                   	var trackingDetails = data.trackingDetails;
				                   	
				               		var myTracking="";
				               		var header ="";
				               		header += ('<tr>');            	
				               		header += ('<th>'+"시간"+'</th>');
				               		header += ('<th>'+"장소"+'</th>');
				               		header += ('<th>'+"유형"+'</th>');
				               		header += ('<th>'+"전화번호"+'</th>');     				
				           			header += ('</tr>');     
				               		
				               		$.each(trackingDetails,function(key,value) {
				   	            		myTracking += ('<tr>');            	
				               			myTracking += ('<td>'+value.timeString+'</td>');
				               			myTracking += ('<td>'+value.where+'</td>');
				               			myTracking += ('<td>'+value.kind+'</td>');
				               			myTracking += ('<td>'+value.telno+'</td>');     				
				   	            		myTracking += ('</tr>');     
				   	            		
				               		});
				               		
				               		$("#myPtag2").html(header+myTracking);
				                   	
				                   }
				               });
				           });
			           </script>
			           <div>
							<table id="myPtag"></table>
						</div>
						<br/>
						<div>
							<table id="myPtag2"></table>
						</div>
					<%} else { %>
						<br /><br />
		           		<p style="color:red; font-size:30px; text-align:center;">비회원은 상품을 조회할 수 없습니다.</p>
		           	<% } %>
	            </div>
            </div>
            <div id="content_3">
            </div>
            <div id="content_4">
            </div>
        </div>
        <script type="text/javascript" src="<%=contextPath %>/resources/js/menubar.js"></script>
        
    </body>
</html>