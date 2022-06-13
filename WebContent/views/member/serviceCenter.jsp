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
        #naviIconImg2 {
        	    z-index: -1;
    			position:relative;
        }
        a{
			text-decoration : none;
			color : black;
		}

    </style>
</head>
<body>
	<br>
    <div class="wrap">
        <img src="<%=contextPath %>\resources\img\집.png" id="naviIconImg2">마이페이지
        <hr>
        <div id="content">
            <div id="content_2">
                <ul class="list_row" style='margin-left:50px;'>
                    <li class="item" style="width:200px">
                        <div class="sct_img">
                            <a href="<%=contextPath %>/list.no?cpage=1" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\공지사항.png" width="150" height="150" >
                            </a>
                        </div>
                        <div class="sct_txt">
                            <a href="<%=contextPath %>/list.no?cpage=1" class="sct_name" style="margin : 50px;">
                  	공지사항
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
                            <a href="<%=contextPath %>/faqList.no?faqListPage=1" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\faq.png" width="150" height="150">
                            </a>
                        </div>
                        <div class="sct_txt">
                            <a href="<%=contextPath %>/faqList.no?faqListPage=1" class="sct_name" style="margin : 60px;">
                   FAQ
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
                            <a href="<%=contextPath%>/questions.no?questionsListPage=1&userNo=<%=loginUser.getUserNo()%>" class="sct_a">
                            <img src="<%=contextPath %>\resources\img\myPageImg\일대일문의.png" width="150" height="150">
                            </a>
                        </div>
                        <div class="sct_txt">
                            <form action="<%=contextPath%>/questions.no?questionsListPage=1" id="my_form" >
	                        	<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
	                           	<input type="hidden" name="questionsListPage" value="1">
	                            <a onclick="document.getElementById('my_form').submit();" class="sct_name" style="margin : 40px;">
	              1:1 문의
	                            </a>
	                        </form>
                            <div>
                                <div>
                                    <span class="sct_icon"></span>
                                </div>
                            </div>
                        </div>
                    </li>
            	</ul>
            </div>
                    
            <div id="content_5">
                <ul id="pagingul">
                </ul>
            </div>
            
        </div>
    </div>
</body>
</html>