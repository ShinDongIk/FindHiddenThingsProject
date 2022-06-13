<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/views/common/menubar.jsp" %>
    
<%@ page import="com.sp.product.model.vo.PageInfo, java.util.ArrayList, com.sp.PastSalesHistory.model.vo.PastSalesHistoryList" %>
    
    <% PageInfo pi = (PageInfo)request.getAttribute("pi");
       ArrayList<PastSalesHistoryList> list = (ArrayList<PastSalesHistoryList>)request.getAttribute("list");
       int PastlistCount = (int)request.getAttribute("saleFinishCount");
       int PastlistCountIng = (int)request.getAttribute("saleIngCount");
       
       int currentPage = pi.getCurrentPage();
       int startPage = pi.getStartPage();
       int endPage = pi.getEndPage();
       int maxPage = pi.getMaxPage();
       
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="</resources/js/postboxNumberlist.js"></script>


    <!-- 추가한 부분 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    
    
    <title>판매 내역 조회 </title>
    
    <style>
    	   /*세부 구조 스타일*/
*{
    box-sizing: border-box;
}
 ul{
    list-style-type: none;
}
a{
    text-decoration: none;
}
/* 전체 div 색 지움
div{
    border: 1px solid rgb(202, 201, 201);
}
*/ 
.wrap{
    width: 1000px;
    height: 1200px;
    margin: auto;
}
.wrap>div{
    width: 100%;
}
#header{
    height: 20%;
}

#navigator{
    height: 6%;
    background-color: rgb(210, 248, 208);
}
#content{
    height: 74%;
}
#header>div{
    float: top;
}

.btn_form {
	display: inline-block;
}

/*로그인/회원가입, 마이페이지 파트*/
#header_1{
    width: 100%;
    height: 15%;
   
    border-bottom: 1px solid gray;
}
#header_1>div{
    width: 35%;   /* 우측상단 마이페이지 크기 변환*/
    height: 100%;
    float: right;
}
#header_1>div>a{
    text-decoration: none;
    font-weight: bold;
    color: rgb(110, 109, 109); /*우측 상단 글자색 */
}
#header_1>div>a:hover{
    color: rgb(129, 224, 180);
}

/* 헤더 왼쪽 정렬 
#header_2>img{
    text-align:left;
}
*/


#loginTag{
    text-align: right;
}
#logining{
    text-align: right; /* 신설 */
}


#loginSuccessTag{
    text-align: right;
    display: none;
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
    color:white;  
}
#search_btn>:hover{
    background-color: rgb(14, 104, 86);
    cursor: pointer;
}
#search_form input{
    width: 100%;
    height: 100%;
}

#naviIcon{
    position: relative;
}
#listIcon{
    margin: 0px;
    padding: 0px;
    height: 100%;
    width: 100%;
    position: absolute;
}
#listIcon>a>img{
   vertical-align: middle;
   align-items: center;
}
#listIcon>li{
    /* border: 1px solid black; */
    display: block;
    width: 100%;
    height: 100%;
    text-align: center;
    line-height: 65px;
    
}
#listIcon>li>a>img{
    margin-top: 15px;
}
#listIcon a,#listIcon>li>ul>li{
   color: rgb(26, 188, 156);
    font-size: 15px;
    font-weight: bold;
    width: 100%;
    height: 100%;
    display: block;
    line-height: 40px;
}
#listIcon>li>ul{
    /* border: 1px solid black; */
    display: none;
    padding: 0px;
}
#listIcon>li>ul a{
    font-size: 12px;
}
#listIcon>li a:hover{
    font-size: 20px ;
    color: rgb(17, 129, 107);
}
#naviIcon>ul>li>ul>li{
    width: 200px;      
    text-align: center;
    font-size: 15px;
    background-color: rgb(234, 247, 233);
}
/*네비게이터 스타일 끝*/

/*content 스타일 시작*/
#content_0{
    color: rgb(179, 185, 181); /*글씨색 수정*/ 
}
#content_0>div{
    border: 1px solid rgb(202, 201, 201);
    
}

#content_1{
    height: 15%;
    width: 100%;
    color: rgb(46, 204, 113); /*글씨색 수정*/
}

#content_1>div{
    float: left;
}
#content_1_1{
    height: 100%;
    width: 20%;
}
#content_1_1>div{
    margin-top: 105px;
}
#content_1_1>div>img{
    vertical-align: bottom;
    width: 20px;
    height: 20px;
    
}
#content_1_2{
    height: 100%;
    width: 60%;
    color: rgb(46, 204, 113);
    text-align: center;
    line-height: 90px;
}
#content_1_3{
    height: 100%;
    width: 20%;
    position: relative;
}
#content_1_3>select{
    height: 30px;
    width: 70%;
    position: absolute;
    left: 30%;
    top: 75%;
    border-radius: 5px;
}
#content_2{
    height: 70%;
}
.like{
    float: right;
    padding-right: 5px;
}
table{
    border-collapse: separate;
    border-spacing: 4px 20px;
}
#content_3{
    height: 30%;
    position: relative;
}
#content_3>form{
    display: table-cell;
    vertical-align: middle;
}
#content4>div{
    margin: auto;
}

#content5{
    height: 3%;
}

#content_5>table th, table td{ /* 테이블 가운데 정렬 */
    text-align:center;
    vertical-align: middle !important ;
}
 

#subSerch_form{
    width: 40%;
    height: 50%;
    margin: auto;
    position: absolute;
    right: 0px;
    left: 0px;
    top: 0px;
    bottom: 0px;
}
#subSerch_form>div{
    height: 100%;
    float: left;
}
#subSerch_cate{
    width: 20%;
}
#subSerch_cate>select{
    height: 100%;
    width: 100%;
}
#subSerch_text{
    width: 60%;
}
#subSerch_text>input{
    border-radius: 5px;
}
#subSerch_btn{
    width: 20%;
    
}
#subSerch_btn>input{
    background-color: rgb(26, 188, 156);
    border-radius: 5px;
    border: 0px;
    color:white;
}
#subSerch_btn>:hover{
    background-color: rgb(14, 104, 86);
    cursor: pointer;
}
#subSerch_form input{
    width: 100%;
    height: 100%;
}
#content_4{
    height: 7%;
}
.paging-div{ 
    padding: 15px 0 5px 10px; 
    display: table; 
    margin-left: auto; 
    margin-right: auto; 
    text-align: center;
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
/*content 스타일 끝*/
/*페이징 스타일*/
.page_wrap {
    text-align:center;
    font-size:0;
}
.page_nation {
    display:inline-block;
}
.page_nation .none {
    display:none;
}
.page_nation a {
    display:block;
    margin:0 3px;
    float:left;
    border:1px solid #e6e6e6;
    width:28px;
    height:28px;
    line-height:28px;
    text-align:center;
    background-color:rgb(210, 248, 208);
    font-size:13px;
    color:#999999;
    text-decoration:none;
}
.page_nation .arrow {
    border:1px solid #ccc;
}
.page_nation .pprev {
    background:rgb(46, 204, 113) no-repeat center center;
    color: black;
    margin-left:0;
}
.page_nation .prev {
    background:rgb(46, 204, 113) no-repeat center center;
    color: black;
    margin-right:7px;
}
.page_nation .next {
    background:rgb(46, 204, 113) no-repeat center center;
    color: black;
    margin-left:7px;
}
.page_nation .nnext {
    background:rgb(46, 204, 113) no-repeat center center;
    color: black;
    margin-right:0;
}
.page_nation>a:hover{
    background-color:rgb(52, 152, 219);
    color:#fff;
    border:1px solid rgb(52, 152, 219);
}
.heart{
    cursor: pointer;
}
    </style>
</head>
<body>

 <div class="wrap">
        <div id="header">

            <div style=“text decoration : underline”>
                <img src="<%=contextPath %>/resources/img/집.png" alt="홈"> <!-- ★홈이미지 추가 -->
                홈> 마이페이지> 판매 내역 조회 </div>
         
            <div id="content_1">
                <h1>&nbsp;판매 내역 조회</h1>
                <br><br>
                
                <!-- 뿌려주기 --> 
	            
                <div id="content_0"> 판매중인 상품 - <%=PastlistCountIng %> 판매 완료 - <%=PastlistCount %>  </div>
            </div>

            <div id="content_5">
                <table id="psh-table" class="tn-list-main table table-bordered table-hover">
	            	<thead>
	            		<tr>
	            			<th>상품정보</th>
	            			<th>판매 금액</th>
	            			<th>등록일</th>
	            			<th>받은 찜</th>
	            			<th>조회수</th>
							<th>상태</th>
	            		</tr>
	            	</thead>
	            	
                    <tbody>

                        <!-- 뿌려주기 -->
                        <!-- 조회된 결과 없을떄-->
                        <%if(list.isEmpty()){ %>
                        	<tr>
                        	
                        		<td colspan="7">작성된 게시글이 없습니다.</td>
                        		
                        	</tr>
                        	
                        	
                        <!-- 조회된 결과 있을때 -->
                       <%}else {%>
                       		<%for (PastSalesHistoryList b : list) { %>
		                       <tr>
 		                       	<input type="hidden" value="<%=b.getProductNo() %>" >
				            		<td>
					            		<div class="tn-list-divBorder">  			           
					            			<ul class="tn-list-bullet">
					            				<li>
					            					<b><%=b.getProductTitle() %></b>
					            				</li>
					            			</ul>
					            		</div>
				            		</td>
				            		
				            		<td><%=b.getProductPrice() %></td>
				            		
				            		<td><%=b.getProductEnterDate() %></td>
		 		            		
				            		<td><%=b.getProductPick() %></td>
				            		
				            		<td><%=b.getProductViews() %></td>
				            		
					            		<%if (b.getProductSellStatus().equals("Y")) { %>
					            		<td> 판매중 </td>
										
										<%}else {%>
										<td> 판매완료 </td>
										<%} %>
	            		</tr>
	            		
	            		
	            		<%} %>
                       
                       <%} %>
	            	
	            	</tbody>

	            </table>    

            </div>
            <div id="content_4">
            	<div class="" align="center">
            	
                       <%if(pi.getCurrentPage()!=1){ %>
                       	<form action="<%=contextPath%>/PastSales.pr?cpage=<%=pi.getCurrentPage()-1%>" id="btn_form1" class="btn_form">
                                    <input type="hidden" name="userNo" value="<%=pi.getUserNo() %>" />
                                    <input type="hidden" name="cpage" value="<%=pi.getCurrentPage()-1%>">
                                    <button onclick="document.getElementById('btn_form1').submit();">&lt;</button>
                        </form>
                       <%} %>
                      
                       <%for(int i=startPage; i<=endPage; i++ ) { %>
                       <form action="<%=contextPath%>/PastSales.pr?cpage=<%=i%>" id="btn_form2" class="btn_form">
                                    <input type="hidden" name="userNo" value="<%=pi.getUserNo() %>" />
                                    <input type="hidden" name="cpage" value="<%=i%>">
                                    <button onclick="document.getElementById('btn_form2').submit();"><%=i %></button>
                                </form>
                       <%} %>
                     
                     <%if(pi.getCurrentPage()!=maxPage){ %>
                      <form action="<%=contextPath%>/PastSales.pr?cpage=<%=pi.getCurrentPage()+1%>" id="btn_form3" class="btn_form">
                                    <input type="hidden" name="userNo" value="<%=pi.getUserNo() %>" />
                                    <input type="hidden" name="cpage" value="<%=pi.getCurrentPage()+1%>">
                                    <button onclick="document.getElementById('btn_form3').submit();">&gt;</button>
                                </form>
                       <%} %>
			</div>
           
        </div>
        <script>
	        $("#psh-table>tbody>tr").click(function(){
	     		location.href="<%=contextPath%>/ProductDetail.pr?pno="+$(this).children().val()+"&userNo=<%=loginUser.getUserNo()%>";
	     	});
        </script>
        <script type="text/javascript" src="resources/js/menubar.js"></script>

</body>
</html>