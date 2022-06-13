<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sp.member.model.vo.Member" %>
<% 
	String contextPath = request.getContextPath(); 
	Member loginUser = (Member)session.getAttribute("loginUser");
	String alertMsg =(String)session.getAttribute("alertMsg");
// 	System.out.println(session.getMaxInactiveInterval()); 
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<script>		
		var msg = "<%=alertMsg%>"; // "회원가입에 성공했습니다." /"null"
		
		if(msg!="null"){
			alert(msg);
		
			<%session.removeAttribute("alertMsg");%>
		}
	</script>
    <div class="wrap">
        <div id="header">
            <div id="header_1">
                <div id="loginTag" style="width: 800px;">
                	<%if(loginUser == null){ %>
                    	<a href="<%=contextPath%>/loginForm.me">로그인/회원가입</a>
                    <%}else{ %>
	                    <a><%=loginUser.getUserNickName() %> 님</a> &nap;
	                    <%if(loginUser.getUserId().equals("admin")){ %>
	                    	<a href="<%=contextPath%>/PayListForm.pa?cpage=1">결제내역</a> &nap;
	                    <%} %>
	                    <a href="<%=contextPath%>/myPageForm.me">마이페이지</a> &nap;
	                    <a href="<%=contextPath%>/pickList.pr?pNum=1">찜목록</a> &nap;
	                    <a href="<%=contextPath%>/PostboxTrackingList.pb?postboxListPage=1&userNo=<%=loginUser.getUserNo()%>">주문배송조회</a> &nap;
	                    <a href="<%=contextPath%>/ChatForm.ch?userNo=<%=loginUser.getUserNo()%>">채팅목록</a> &nap;
	                    <a href="<%=contextPath %>\views/member/serviceCenter.jsp">고객센터</a> &nap;
	                    <a href="<%=contextPath%>/logout.me">로그아웃</a>
	                 <%} %>
                </div>
            </div>
            <div id="header_2">
                <a href="<%=contextPath %>" onClick="home();">
                	<img src="<%=contextPath %>/resources/img/숨은그림찾기.jpg" id="logo"> 
                </a>
            </div>
        </div>
        <div id="navigator">
            <div id="naviIcon">
                <ul id="listIcon">
                    <li>
                        <a href="" id="Icon"><img src="<%=contextPath %>/resources/img/삼지창.png" id="naviIconImg"></a>
                        <ul id="cate">
                            <li style="border-bottom: 1px solid gray;">전체 카테고리</li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=디지털기기&pNum=1">디지털기기</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=생활가전&pNum=1">생활가전</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=가구/인테리어&pNum=1">가구/인테리어</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=생활/가공품&pNum=1">생활/가공품</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=잡화&pNum=1">잡화</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=의류&pNum=1">의류</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=게임/취미&pNum=1">게임/취미</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=뷰티/미용&pNum=1">뷰티/미용</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=반려동물용품&pNum=1">반려동물용품</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=도서/티켓/음반&pNum=1">도서/티켓/음반</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=식물&pNum=1">식물</a></li>
                            <li><a href="<%=contextPath%>/productListForm.pr?category=기타중고물품&pNum=1">기타중고물품</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div id="naviSearch">
                <form action="<%=contextPath %>/menubarSearchController.pr?pNum=1" id="search_form">
                <input type="hidden" name="pNum" value="1">
                    <div id="search_text">
                        <input type="search" name="keyword" id="ts" placeholder="찾으시는 물품명을 입력해주세요!">
                    </div>
                    <div id="search_btn">
                        <input type="submit" value="검색">
                    </div>
                </form>
            </div>
        </div>
        <script type="text/javascript" src="<%=contextPath %>/resources/js/menubar.js"></script>
    </body>
</html>