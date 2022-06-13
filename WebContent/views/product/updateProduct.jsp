<%@page import="com.sp.product.model.vo.ProductFile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sp.product.model.vo.ProductDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/views/common/menubar.jsp"%>
<%
	ProductDetail p = (ProductDetail)request.getAttribute("p");
	ArrayList<ProductFile> list = (ArrayList<ProductFile>)request.getAttribute("list");
%>
    
    <!DOCTYPE html>    
 	<html>
    <head>
        <meta charset="UTF-8">       
        <title>숨은 물건 찾기</title>
<link rel="stylesheet" href="<%=contextPath %>/resources/css/submitProduct.css">        
        
    </head>

    <body>
        <div id="product_content">
            <div id="prduct_content_1">
                <img src="<%=contextPath %>/resources/img/집.png" alt="" /> <b>홈 > 마이페이지 > 상품 수정</b>
            </div>
    
            <div id="prduct_content_2">
                <h1>상품등록</h1>
            </div>

            <div id="product_head">
                <label for="fileUpload">  
                    <div id="prduct_header_3">
                        <img src="<%=contextPath %>/resources/product_upfile/<%=list.get(0).getFileChangeName() %>" id="titleImg" width="400px" height="100%">  
                    </div>
                </label>   
            </div>    
                <form action="<%=contextPath %>/productUpdating.pr" method="post" enctype="multipart/form-data">
                	<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
                	<input type="hidden" name="originFileName" value="<%=list.get(0).getFileChangeName()%>">
                	<input type="hidden" name="fileNo" value="<%=list.get(0).getFileNo()%>">
                	<input type="hidden" name="productNo" value="<%=p.getProductNo() %>">
                    <div id="prduct_header_4">
                    	<input type="hidden" name="fileNo" value="<%=list.get(0).getFileNo()%>">
                		<input id="fileUpload" type="file" accept="image/jpg, image/jpeg, image/png" onchange="thumbImg(this);" name="file" multiple style="display: none;" width="100%">
                        <table id="product-table">
                            <tr>
                                <td><b>상품명 :</b></td>
                                <td><input type="text" name="productTitle" value="<%=p.getProductTitle() %>" required></td>
                            </tr>
                            <tr>
                                <td><b>가격 :</b></td>
                                <td><input type="text" name="productPrice" value="<%=p.getProductPrice() %>" required></td>
                            </tr>
                            <tr>
                                <td><b>거래 방법 :</b></td>
                                <td><b>
                                    <select name="deal" value="<%=p.getProductTransaction() %>" id="deallist">
                                        <option value="직거래">직거래</option>
                                        <option value="택배거래">택배거래</option>
                                    </select>
                                    </b>
                                </td>
                            </tr>
                            <tr>
                                <td><b>카테고리 :</b></td>
                                <td>
                                    <b>
                                        <select name="category" id="categorilist" value="<%=p.getCategory() %>"> 
                                            <option value="디지털기기">디지털기기</option>
                                            <option value="생활가전">생활가전</option>
                                            <option value="가구/인테리어">가구/인테리어</option>
                                            <option value="l생활/가공품">생활/가공품</option>
                                            <option value="잡화">잡화</option>
                                            <option value="의류">의류</option>
                                            <option value="게임/취미">게임/취미</option>
                                            <option value="뷰티/미용">뷰티/미용</option>
                                            <option value="반려동물용품">반려동물용품</option>
                                            <option value="도서/티켓/음반">도서/티켓/음반</option>
                                            <option value="식물">식물</option>
                                            <option value="기타중고물품">기타중고물품</option>
                                        </select>
                                    </b>
                                </td>
                            </tr>
                        </table>
                    </div>       
                    
                        <div id="product_write">
                            <div id="prduct_content_3">
                                <br><br>
                                <div id="contentTitle"><h3 align="center">상품 설명</h3></div>
                                <div id="product-text-area"><textarea name="productContent" id="explain" cols="131" rows="20" style="resize: none; width: 100%;" placeholder="상품 설명을 입력해주세요!" required><%=p.getProductContent() %></textarea></div>
                                <br>
                                <div id="product-insert-button"><button id="product_btn" onClick="imgTorF();">상품등록</button></div>
                            </div>
                        </div>                       
                    
                </form> 
    
            
                        
        </div>
         
        <script>
        	var isImg = false; //사진이 있으면 true 없으면 false
            function thumbImg(inputfile){
                if(inputfile.files.length==1){ //사진이 있을때
                    var reader = new FileReader();

                    reader.readAsDataURL(inputfile.files[0]);

                    reader.onload = function(e){
                        $("#titleImg").attr("src",e.target.result);
                    }
                    isImg = true;
                }
            }
        </script>
    </body>
    </html>