<%@page import="com.sp.product.model.vo.PageInfo"%>
<%@page import="com.sp.product.model.vo.PickList"%>
<%@page import="com.sp.product.model.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
	ArrayList<PickList> plist = (ArrayList<PickList>)request.getAttribute("plist");
	PageInfo pg = (PageInfo)request.getAttribute("paging");
	String category = request.getParameter("category");
	int isInclude = 0;
%>
<!DOCTYPE html>
<%@ include file="/views/common/menubar.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
        <div id="content">
            <div id="content_1">
                <div id="content_1_1">
                    <div>
                        <img src="<%=contextPath %>/resources/img/집.png" alt="홈">
                        <span>홈> 검색</span>
                    </div>
                </div>
                <div id="content_1_2">
                    <h2>현재 숨은 검색목록</h2>
                </div>
                <%if(loginUser!=null){ %>
                <div id="content_1_3">
                    <button id="insertProduct" onClick="location.href='<%=contextPath%>/insertForm.pr'">물건 올리기</button>
                </div>
            	<%} %>
            </div>
            <hr>
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
                            <span class="title"><%=list.get(i).getProductTitle() %></span><br>
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
                            <input type="hidden" value="<%=list.get(i).getUserNo() %>">
                        </span>
                    </div>	
                <%}%>
                <%}else{%>
                   	<h3 style="text-align:center">게시물이 없습니다!</h3>
                <%}%>
            </div>
            <div id="content_3">
                <form action="test.do" id="subSerch_form">
                    <div id="subSerch_cate">
                        <select name="" id="cateSub" style="cursor: pointer;">
                            <option value="title">제목</option>
                            <option value="seller">판매자</option>
                            <option value="price">금액</option>
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
                <div class="page_wrap">
                    <div class="page_nation">
                    <%if(pg.getCurrentPage()!=1){ %>
                       <a class="arrow prev" onclick="location.href='<%=contextPath%>/menubarSearchController.pr?pNum=<%=pg.getCurrentPage()-1%>'"><</a>
                    <%} %>
                    <%for(int i=pg.getStartPage(); i<=pg.getEndPage(); i++){ %>
                       <a class="active" onclick="location.href='<%=contextPath%>/menubarSearchController.pr?pNum=<%=i%>'"><%=i%></a>
                    <%} %>
                    <%if(pg.getCurrentPage()!=pg.getMaxPage()){ %>
                       <a class="arrow next" onclick="location.href='<%=contextPath%>/menubarSearchController.pr?pNum=<%=pg.getCurrentPage()+1%>'">></a>
                    </div>
                    <%} %>
                 </div>
            </div>
    </div>
  
    <script>
	    $(".heart").click(function(){
	    	<%if(loginUser!=null){%>
		    	if(getUserNo!=$(this).next().next().val()){
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
		    	}else if(getNickName==$(this).next().next().val()){
		    		alert("자신의 게시글을 찜을 할 순  없습니다!");
		    	}
	        <%}else{%>
	    		alert("로그인 후 찜하기가 가능합니다!");
		    <%}%>
	    });
    </script>
</body>
</html> 