<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/views/common/menubar.jsp"%>

<!DOCTYPE html>    
<html>
<head>
    <meta charset="UTF-8">       
	  <!-- Latest compiled and minified CSS -->
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <title>숨은 물건 찾기</title>
</head>
<style>
    div{
    box-sizing: border-box;
    color: #1ABC9C;
    }
    #Withdraw_content_1{
    height: 5%;
    }
    #Withdraw_content_2{
    height: 7%;
    text-align: center;
    }
    #Withdraw_content_3{
    width: 100%;
    height: 20%;
    }
    #box{
    width: 40%;
    height: 30%;
    left:50%;
    top:50%;
    text-align: left;
    border: none 1px solid black;
    resize: none;
   }
   #choice{
    width: 40%;
    height: 30%;
    left:50%;
    top:20%;
    text-align: left;
    margin-left:1px;
    margin-top:60px;
   }
   #agree{
    width: 20%;
    height: 20%;
    text-align: center;
    border-radius: 10px;
    background-color: #1ABC9C;
    border-color: white;
    font-size: large;
    color: white;
   }
 </style>
    <body>
    	<br>
       <div id="Withdraw_content_1">
          <img src="<%=contextPath %>/resources/img/집.png" alt="" /> <b>홈 > 마이페이지 > 회원 탈퇴</b>
       </div>

       <div id="Withdraw_content_2">
           <h1>회원탈퇴</h1>
       </div>

       </form>
       <div id="Withdraw_content_3" align="center">
	        <textarea id="box" name="content" cols="40" rows="10" readonly>숨은 보물찾기를 이용해주셔서 감사합니다. 
신중하게 생각하시고 응답 바랍니다.</textarea>
	        <br>
	        <button id="agree" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">회원 탈퇴</button>
       </div>

       <!-- The Modal -->
<div class="modal" id="deleteForm">
    <div class="modal-dialog">
      <div class="modal-content">
  
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">회원탈퇴</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
  
        <!-- Modal body -->
        <div class="modal-body" align="center">
            <b>회원 탈퇴 후 복구는 불가능 합니다.<br>정말로 탈퇴 하시겠습니까?</b> <br><br>
            <form action="<%=contextPath%>/delete.me" method="post">
            	<input type="hidden" name="userId" value="<%=loginUser.getUserId()%>">
                <table>
                    <tr>
                        <td>비밀번호 입력 :</td>
                        <td><input type="password" name="userPwd" required></td>
                    </tr>
                </table>
                <button type="submit" class="btn btn-danger">탈퇴하기</button>
               </form>
        </div>
  
      </div>
    </div>
  </div>
    </body>