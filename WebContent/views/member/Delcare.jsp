<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보수정</title>
    <style>
        /*세부 구조 스타일*/
        *{
            box-sizing: border-box;
        }
        div{
            border: 1px solid rgb(202, 201, 201);
        }
        .wrap{
            width: 1000px;
            height: 1500px;
            margin: auto;
        }
        .wrap>div{
            width: 100%;
        }
        #header{
            height: 15%;
        }
        
        #navigator{
            height: 5%;
            background-color: rgb(210, 248, 208);
        }
        #header>div{
            float: top;
        }
        #title{
            text-align: center;
        }
        #FD{
            width: 500px;
            height: 600px;
        }

        /*로그인/회원가입, 마이페이지 파트*/
        #header_1{
            width: 100%;
            height: 15%;
            border-bottom: 1px solid gray;
        }
        #header_1>div{
            height: 100%;
            width: 25%;
            float: right;
        }
        #header_1>div>a{
            text-decoration: none;
            font-weight: bold;
            color: rgb(110, 109, 109);
        }
        #header_1>div>a:hover{
            color: rgb(129, 224, 180);
        }
        #loginTag{
            text-align: right;
        }
        /*로그인/회원가입, 마이페이지 파트 끝*/
        
        /*로고 파트*/
        #header_2{
            width: 100%;
            height: 85%;
            text-align: center;
        }
        #logo{
            height: 180px;
            width: 330px;
        }
        #header_2_2>h1{
            display: inline;
        }
        /*로고 파트 끝*/

        /*네비게이터 스타일*/
        #navigator>div{
            float: left;
        }
        #naviIcon{
            height: 100%;
            width : 5%;
            align-items: center;
            display: flex;
            justify-content:center;
        }
        #naviIconImg{
            width: 30px;
            height: 30px;
            filter: invert(80%) sepia(54%) saturate(6320%) hue-rotate(126deg) brightness(97%) contrast(80%);  
        }
        #naviIconImg:hover{
            cursor: pointer;
            filter: invert(25%) sepia(99%) saturate(3583%) hue-rotate(94deg) brightness(90%) contrast(108%); 
        }
        #naviSearch{
            height: 100%;
            width : 95%;
            position: relative;
        }
        #search_form{
            width: 60%;
            height: 50%;
            margin: auto;
            position: absolute;
            right: 0px;
            left: 0px;
            top: 0px;
            bottom: 0px;
        }
        #search_form>div{
            height: 100%;
            float: left;
        }
        #search_text{
            width: 80%;
        }
        #search_text>input{
            border-radius: 5px;
        }
        #search_btn{
            width: 20%;
            
        }
        #search_btn>input{
            background-color: rgb(26, 188, 156);
            border-radius: 5px;
            border: 0px;
        }
        #search_btn>:hover{
            background-color: rgb(14, 104, 86);
            cursor: pointer;
        }
        #search_form input{
            width: 100%;
            height: 100%;
        }
        /*네비게이터 스타일 끝*/
        
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

    </style>
</head>
<body>
    <div class="wrap">
        <div id="header">
            <div id="header_1">
                <div id="loginTag">
                    <a href="#">로그인/회원가입</a> &nap;
                    <a href="#">마이페이지</a> &nap;
                </div>
            </div>
            <div id="header_2">
                <a href="#"></a>
                <img src="D:\Semi-Project\resources\img\숨은그림찾기.jpg" id="logo"> 
            </div>
        </div>
        <div id="navigator">
            <div id="naviIcon">
                <img src="D:\Semi-Project\resources\img\삼지창.png" id="naviIconImg">
            </div>
                
            <div id="naviSearch">
                <form action="test.do" id="search_form">
                    <div id="search_text">
                        <input type="search" name="keyword" id="ts" placeholder="찾으시는 물품명을 입력해주세요!">
                    </div>
                    <div id="search_btn">
                        <input type="submit" value="검색">
                    </div>
                </form>
            </div>
        </div>
        <hr>
        <img src="D:\Semi-Project\resources\img\집.png" id="naviIconImg">
        <b>마이페이지 > 신고</b>
        <hr>
        
        <br><br><br>

        <fieldset id="FD">
            <h1 id="title">신고</h1>
             <form action="test.do">
                신고 사유 : <select name="declare" id="delcarelist">
                    <option value="fr">사기</option>
                    <option value="fs">허위 매물</option>
                    <option value="ss">불건전한 닉네임</option>
                    <option value="nb">도배</option>
                </select>
                <br><br>
                신고내용
                <br><br>

                <textarea name="content" cols="30" rows="10"></textarea>
                
                <br><br>
                
                <input type="submit" value="신고하기">
            </form>
        </fieldset>
</body>
</html>