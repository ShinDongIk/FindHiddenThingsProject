<%@page import="com.sp.product.model.vo.PickList"%>
<%@page import="com.sp.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/common/menubar.jsp"%>
<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
	ArrayList<PickList> plist = (ArrayList<PickList>)request.getAttribute("plist");
	String category = request.getParameter("category");
	int isInclude = 0;
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>숨은 물건 찾기</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/mainStyle.css">
    <style>
		.txt_line {
	      	width: 240px;
	        white-space: nowrap;
	        overflow: hidden;
	        text-overflow: ellipsis;
	        display: inline-block;
	  	}
    </style>
</head>
<body>
    <div class="wrap">
        <div id="content">
            <div id="content_1">
                <div id="content_1_1">
                    <div>
                        <img src="<%=contextPath %>/resources/img/집.png" alt="홈">
                        <span>홈</span>
                    </div>
                </div>
                <div id="content_1_2">
                    <h2 style="margin-top:50px;">현재 저렴한 숨은 물건들</h2>
                </div>
                <div id="content_1_3">
                    <select name="cateListSub" id="cateSubList" style="cursor: pointer;">
                        <option value="디지털기기">디지털기기</option>
                        <option value="생활가전">생활가전</option>
                        <option value="가구/인테리어">가구/인테리어</option>
                        <option value="생활/가공품">생활/가공품</option>
                        <option value="잡화">잡화</option>
                        <option value="의류">의류</option>
                        <option value="게임/취미">게임/취미</option>
                        <option value="뷰티/미용">뷰티/미용</option>
                        <option value="반려동물용품">반려동물용품</option>
                        <option value="도서/티켓/음반">도서/티켓/음반</option>
                        <option value="식물">식물</option>
                        <option value="기타중고물품">기타중고물품</option>
                    </select>
                </div>
            </div>
            <hr><br>
            <div id="content_2">
                 <%if(!list.isEmpty()){%>
                 <%for(int i=0; i<list.size(); i++){%>
                    <div class="product-list">
                    	<input type="hidden" value="<%=list.get(i).getProductNo() %>">
                    	<%if(loginUser != null){ %>
                        <a href="<%=contextPath%>/ProductDetail.pr?pno=<%=list.get(i).getProductNo() %>&userNo=<%=loginUser.getUserNo()%>">
                        <%}else{ %>
                        <a>
                        <%} %>
                            <img src="<%=contextPath%>/resources/product_upfile/<%=list.get(i).getChangeFileName() %>" style="width: 242px; height: 212px;"><br>
                            <span class="title txt_line"><%=list.get(i).getProductTitle() %></span><br>
                            <span class="price"><%=list.get(i).getProductPrice() %> 원</span><br>
                            <span class="nickname"><%=list.get(i).getUserName() %></span>			
                        </a>
                       
                        <span class="like" style="padding-right: 10px;">
                        <%if(loginUser!=null){ %>
	                        <%if(!plist.isEmpty()){%>
		                        <%for(int j=0; j<plist.size(); j++){%>
		                        	<%if(list.get(i).getProductNo()== plist.get(j).getProductNo()){isInclude=1;}%>
		                        <%} %>
		                        <%if(isInclude==1){%>
		                            <img src="resources/img/색깔하트.png" class="heart" alt="" width="15px" height="15px">
		                            <%isInclude=0; %>
		                        <%}else{%>
			                        <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
		                        <%}%>
	                        <%}else{ %>
	                        	<img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
	                        <%} %>
                        <%}else{%>
                        	<img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                        <%} %>
                        	<input type="hidden" value="<%=list.get(i).getProductNo() %>">
                            <input type="hidden" value="<%=list.get(i).getUserName() %>">
                        </span>
                    </div>	
                <%}%>
                <%}else{%>
                   	<h3 style="text-align:center">게시물이 없습니다!</h3>
                <%}%>
                
            </div>
  	<script>
  		$("#cateSubList").val("<%=category%>").prop("selected", true);
        $("#cateSubList").change(function(){
           location.href = "mainLoad.pr?category="+$(this).val();
        });
    </script>
    <script> 
	    $(".heart").click(function(){
	    	<%if(loginUser!=null){%>
		    	if("<%=loginUser.getUserNickName()%>"!=$(this).next().next().val()){
			        if($(this).attr("src")=="resources/img/빈하트.png"){
			            $(this).attr("src","resources/img/색깔하트.png");
			            $.ajax({
			                url : "productPick.pr",
			                data : {
			                    num : $(this).next().val(),
			                    nickName : "<%=loginUser.getUserNickName() %>"
			                },
			                type : "post",
			                error : function() {
			                    console.log("연결 실패");
			                }
			            })
			        }else{
			            $(this).attr("src","resources/img/빈하트.png");
			            $.ajax({
			                url : "productPick.pr",
			                data : {
			                    num : $(this).next().val(),
			                    nickName : "<%=loginUser.getUserNickName() %>"
			                },
			                type : "post",
			                error : function() {
			                    console.log("연결 실패");
			                }
			            })
			        }
		    	}else if("<%=loginUser.getUserNickName()%>"==$(this).next().next().val()){
		    		alert("자신의 게시글을 찜을 할 순  없습니다!");
		    	}
	        <%}else{%>
	    		alert("로그인 후 찜하기가 가능합니다!");
		    <%}%>
	    });
    </script>
</body>
</html>