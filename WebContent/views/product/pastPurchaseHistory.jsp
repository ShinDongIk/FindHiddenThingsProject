<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>지난 구매 내역</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/mainStyle.css">

</head>
<body>

 <div class="wrap">
        <div id="header">
            <div id="header_1">
                <div id="loginTag"> <!-- ★로그인 태그 변경 로그인후 상태여야 함 -->
                    <a href="#">???님 환영합니다</a>&nbsp; <!-- ★ ???을 닉네임 변수로 해야할듯? -->
                    <a href="#">마이페이지</a>&nbsp; 
                    <a href="#">로그아웃</a>&nbsp; 
                </div>
                <div id="loginSuccessTag">
                    <a href="#">님</a> &nap;
                    <a href="#">알림<sub>5</sub></a> &nap;
                    <a href="#">마이페이지<sub>5</sub></a> &nap;
                    <a href="#">장바구니<sub>5</sub></a> &nap;
                    <a href="#">주문배송조회<sub>5</sub></a> &nap;
                    <a href="#">고객센터<sub>5</sub></a> &nap;
                    <a href="#">로그아웃<sub>5</sub></a> &nap;
                </div>
            </div>
            <div id="header_2">
                <a href="#"></a>
                <img src="/resources/img/숨은그림찾기.jpg" id="logo" align="left"> <!-- ★이미지 왼쪽정렬-->
            </div>
        </div>
        <div id="navigator">
            <div id="naviIcon">
                <ul id="listIcon">
                    <li>
                        <a href="" id="Icon"><img src="/resources/img/삼지창.png" id="naviIconImg"></a>
                        <ul id="cate">
                            <li style="border-bottom: 1px solid gray;">전체 카테고리</li>
                            <li><a href="">디지털기기</a></li>
                            <li><a href="">생활가전</a></li>
                            <li><a href="">가구/인테리어</a></li>
                            <li><a href="">생활/가공품</a></li>
                            <li><a href="">잡화</a></li>
                            <li><a href="">의류</a></li>
                            <li><a href="">게임/취미</a></li>
                            <li><a href="">뷰티/미용</a></li>
                            <li><a href="">반려동물용품</a></li>
                            <li><a href="">도서/티켓/음반</a></li>
                            <li><a href="">식물</a></li>
                            <li><a href="">기타중고물품</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div id="naviSearch">
                <form action="test.do" id="search_form">
                    <div id="search_text">
                        <input type="search" name="keyword" id="ts" placeholder="찾으시는 물품명을 입력해주세요!">
                    </div>
                    <div id="search_btn">
                        <input type="submit" value="검색"> <!-- ★검색 글씨색 흰색 수정 -->
                    </div>
                </form>
            </div>
        </div>
        <div id="content">
            <!-- ★★★ 글씨체 수정필요함 -->
            <div style=“text decoration : underline”>
                <img src="resources/img/집.png" alt="홈"> <!-- ★홈이미지 추가 -->
                홈> 마이페이지> 지난 구매 내역 </div>
         
            <div id="content_1">
                <h1>&nbsp;지난 구매 내역</h1>
            </div>
           
            <div id="content_2">
                <table id="list">		 	
					<tbody>
                        <tr>
                            <td>
                                <a href="/project/classView.kh?no=964&amp;cpage=1">
                                    <img src="" style="width: 242px; height: 212px;">
                                    <span class="title">글제목</span><br>
                                    <span class="price">가격</span><br>
                                    <span class="nickname">닉네임</span>					
                                </a>
                                <span class="like">
                                    <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                                </span>
                            </td>	
                            <td>
                                <a href="/project/classView.kh?no=941&amp;cpage=1">
                                    <img src="" style="width: 242px; height: 212px;">
                                    <span class="title">글제목</span><br>
                                    <span class="price">가격</span><br>
                                    <span class="nickname">닉네임</span>					
                                </a>
                                <span class="like">
                                    <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                                </span>
                            </td>	
                            <td>
                                <a href="/project/classView.kh?no=947&amp;cpage=1">
                                    <img src="" style="width: 242px; height: 212px;">
                                    <span class="title">글제목</span><br>
                                    <span class="price">가격</span><br>
                                    <span class="nickname">닉네임</span>					
                                </a>
                                <span class="like">
                                    <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                                </span>
                            </td>	
                            <td>
                                <a href="/project/classView.kh?no=954&amp;cpage=1">
                                    <img src="" style="width: 242px; height: 212px;">
                                    <span class="title">글제목</span><br>
                                    <span class="price">가격</span><br>
                                    <span class="nickname">닉네임</span>					
                                </a>
                                <span class="like">
                                    <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                                </span>
                            </td>	
						</tr>
                        <tr>
                            <td>
                                <a href="/project/classView.kh?no=964&amp;cpage=1">
                                    <img src="" style="width: 242px; height: 212px;">
                                    <span class="title">글제목</span><br>
                                    <span class="price">가격</span><br>
                                    <span class="nickname">닉네임</span>					
                                </a>
                                <span class="like">
                                    <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                                </span>
                            </td>	
                            <td>
                                <a href="/project/classView.kh?no=941&amp;cpage=1"> 
                                    <img src="" style="width: 242px; height: 212px;">
                                    <span class="title">글제목</span><br>
                                    <span class="price">가격</span><br>
                                    <span class="nickname">닉네임</span>					
                                </a>
                                <span class="like">
                                    <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                                </span>
                            </td>	
                            <td>
                                <a href="/project/classView.kh?no=947&amp;cpage=1">
                                    <img src="" style="width: 242px; height: 212px;">
                                    <span class="title">글제목</span><br>
                                    <span class="price">가격</span><br>
                                    <span class="nickname">닉네임</span>					
                                </a>
                                <span class="like">
                                    <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                                </span>
                            </td>	
                            <td>
                                <a href="/project/classView.kh?no=954&amp;cpage=1">
                                    <img src="" style="width: 242px; height: 212px;">
                                    <span class="title">글제목</span><br>
                                    <span class="price">가격</span><br>
                                    <span class="nickname">닉네임</span>				
                                </a>
                                <span class="like">
                                    <img src="resources/img/빈하트.png" class="heart" alt="" width="15px" height="15px">
                                </span>	
                            </td>	
						</tr>
                        
				    </tbody>
                </table>
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
                <div class="page_wrap">
                    <div class="page_nation">
                       <a class="arrow pprev" href=""><<</a>
                       <a class="arrow prev" href=""><</a>
                       <a href="" class="active">1</a>
                       <a href="">2</a>
                       <a href="">3</a>
                       <a href="">4</a>
                       <a href="">5</a>
                       <a href="">6</a>
                       <a href="">7</a>
                       <a href="">8</a>
                       <a href="">9</a>
                       <a href="">10</a>
                       <a class="arrow next" href="#">></a>
                       <a class="arrow nnext" href="#">>></a>
                    </div>
                 </div>
            </div>
        </div>
        <script type="text/javascript" src="resources/js/menubar.js"></script>

</body>
</html>