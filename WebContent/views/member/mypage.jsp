<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/views/common/menubar.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>
    <style>
        #content_1{
            height: 10%;
            text-align: center;
            padding-top: 30px;
        }
        #content_2{
            height: 25%;
        }
        #content_3{
            height: 25%;
        }
        #content_4{
            height: 25%;
        }
        #mainList{
            width: 80%;
            height: 80%;
            text-align: center;
            margin: auto;
        }
        .list_row{
            list-style-type: none;
            
        }
        .item{
            float: left;
        }
		a{
			text-decoration : none;
			color : black;
		}
		#myPage-naviIconImg{
			z-index: -1;
            position:relative;
		}
    </style>
</head>
<body>
	<br>
    <div class="wrap">
        <img src="<%=contextPath %>\resources\img\집.png" id="myPage-naviIconImg"> 홈 < 마이페이지
        <hr>
        <div id="content">
            <div id="content_2">
                <ul class="list_row" style='margin-left:50px;'>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="<%=contextPath %>/PurchaseList.pu?pNum=1" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\지난구매내역.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                            <a href="<%=contextPath %>/PurchaseList.pu?pNum=1" class="sct_name" style="margin : 30px;">
                                지난구매내역
                            </a>
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="<%=contextPath %>\views/member/serviceCenter.jsp" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\고객센터.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                            <a href="<%=contextPath %>\views/member/serviceCenter.jsp" class="sct_name" style="margin : 40px;">
                                고객센터
                            </a>
                            
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="<%=contextPath%>/pickList.pr?pNum=1" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\찜목록.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                            <a href="<%=contextPath%>/pickList.pr?pNum=1" class="sct_name" style="margin : 30px;">
                                찜한내역
                            </a>
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="<%=contextPath %>/PastSales.pr?userNo=<%=loginUser.getUserNo() %>&cpage=1" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\판매내역.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                            <a href="<%=contextPath %>/PastSales.pr?userNo=<%=loginUser.getUserNo() %>&cpage=1" class="sct_name" style="margin : 40px;">
                                판매내역
                            </a>
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div id="content_3">
                <ul class="list_row" style='margin-left:50px;'>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="<%=contextPath%>/PostboxNumberList.pb?postboxListPage=1&userNo=<%=loginUser.getUserNo()%>" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\운송장등록.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                        <form action="<%=contextPath%>/PostboxNumberList.pb?postboxListPage=1" id="my_form" >
                        	<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
                           	<input type="hidden" name="postboxListPage" value="1">
                            <a onclick="document.getElementById('my_form').submit();" class="sct_name" style="margin : 10px;">
                                택배 운송장 등록
                            </a>
                        </form>
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="#" onclick="document.getElementById('my_form2').submit();" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\택배.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                            <form action="<%=contextPath%>/PostboxTrackingList.pb?postboxListPage=1" id="my_form2" >
	                           	<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
	                           	<input type="hidden" name="postboxListPage" value="1">
	                            <a href="#" onclick="document.getElementById('my_form2').submit();" class="sct_name" style="margin : 20px;">
	                                택배 운송장 조회
	                            </a>
                        </form>
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="<%=contextPath %>/deleteMember.me" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\회원탈퇴.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                            <a href="<%=contextPath %>/deleteMember.me" class="sct_name" style="margin : 40px;">
                                회원탈퇴
                            </a>
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
                <%if(loginUser.getUserId().equals("admin")){ %>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="<%=contextPath%>/ReportListView.re?pNum=1" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\신고하기.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                            <a href="<%=contextPath%>/ReportListView.re?pNum=1" class="sct_name" style="margin : 30px;">
                                신고내역
                            </a>
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
                <%} %>
            </div>
            <div id="content_4">
                <ul class="list_row" style='margin-left:50px;'>
                    
            </div>
            <div id="content_5">
                <ul id="pagingul">
                </ul>
            </div>
            
        </div>
    </div>
</body>
</html>