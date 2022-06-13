<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String contextPath = request.getContextPath(); %> 
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/memberEnrollForm.css">
        <meta charset="utf-8">
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입</title>
     <!-- Bootstrap CSS -->
      
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">     
    </head>
    <body>
               
                    <div class="container"><!-- 좌우측의 공간 확보 -->
                        <!-- 헤더 들어가는 부분 -->
                                                
                        </div>
                       
                                                
                            <div id="header">
                                <img class="mt-4 mb-4" src="https://cdn.discordapp.com/attachments/965787913822548065/969494649658015764/7a02fa5b21b188e4.jpg" width="300">
                            </div>
                    
                            <form id="enroll-form" action="<%=contextPath %>/insert.me" method="post">
                            <!-- wrapper -->
                            <div id="wrapper">
                    
                                <!-- content-->
                                <div id="content">
                    
                                    <!-- ID -->
                                    <div>
                                       <label for="id">아이디</label>
                                      
                                        <span class="box int_id">
                                            <input type="text" id="id" class="int" name="userId" maxlength="20" required>
                                        </span>
                                        <span class="error_next_box"></span>
                                        <button id="idCkBtn" onClick="idCheck();" disabled>아이디 중복확인</button>
                                    </div>
                    
                                    <!-- PW1 -->
                                    <div>
                                      <label for="pswd1">비밀번호</label>
                                        <span class="box int_pass">
                                            <input type="password" id="pswd1" class="int" name="userPwd" maxlength="20" required>
                                            <span id="alertTxt">사용불가</span>
                                            <img src="https://th.bing.com/th/id/OIP.w71KKSw4tnmZ3xIKXUJfxwHaHa?pid=ImgDet&rs=1" id="pswd1_img1" class="pswdImg">
                                        </span>
                                        <span class="error_next_box"></span>
                                    </div>
                    
                                    <!-- PW2 -->
                                    <div>
                                      <label for="pswd2">비밀번호 재확인</label>
                                        <span class="box int_pass_check">
                                            <input type="password" id="pswd2" class="int" maxlength="20" required>
                                            <img src="https://th.bing.com/th/id/OIP.w71KKSw4tnmZ3xIKXUJfxwHaHa?pid=ImgDet&rs=1" id="pswd2_img1" class="pswdImg">
                                        </span>
                                        <span class="error_next_box"></span>
                                    </div>
                    
                                    <!-- NAME -->
                                    <div>
                                       <label for="name">이름</label>
                                        <span class="box int_name">
                                            <input type="text" id="name" class="int" name="userName" maxlength="20" required>
                                        </span>
                                        <span class="error_next_box"></span>
                                    </div>
                                    <!-- NiCK NAME -->
                                    <div>
                                        <label for="nickname">닉네임</label>
                                         <span class="box int_nickname">
                                             <input type="text" id="nickName" class="int" name="userNickName" maxlength="20" required>
                                         </span>
                                         <span class="error_next_box"></span>
                                         <button id="nickNameCkBtn" onClick="nickNameCheck();">닉네임 중복확인</button>
                                     </div>
                                   
                                    <!-- EMAIL -->
                                    <div>
                                       <label for="email">본인확인 이메일<span class="optional"></span></label>
                                        <span class="box int_email">
                                            <input type="email" id="email" class="int" name="userEmail" maxlength="100" placeholder="선택입력" required>
                                        </span>
                                        <span class="error_next_box"></span>    
                                    </div>
                    
                                    <!-- MOBILE -->
                                    <div>
                                       <label for="phoneNo">휴대전화</label>
                                        <span class="box int_mobile">
                                            <input type="tel" id="mobile" class="int" name="userPhone" maxlength="16" placeholder="전화번호 입력(-포함하여 입력해주세요.)" required>
                                        </span>
                                        <span class="error_next_box"></span>    
                                    </div>
                    
                    
                                    <!-- JOIN BTN-->
                                    <div class="btn_area">
                                    
                                        <button type="submit" id="btnJoin" onClick="return memEnrollBtn();">회원가입</button>
                                    </div>
                                                    
                                </div> 
                                <!-- content-->
                    
                            </div> 
                        </form>
                </div>
        <script>
        	function idCheck(){
                $.ajax({
                    url: "idCheck.me",
                    data: {userId : $("#id").val()},
                    type: "post",
                    success: function(result){
                    	if(result>0){
                    		alert("이미 사용중인 아이디 입니다! 다시 입력해주세요!");
                    		$("#id").val("");
                    		$("#id").focus();
                    	}else{
                    		alert("사용 가능한 아이디 입니다!");
                    		$("#id").attr("disabled",true);
                    	}
                    },
                    error: function(){
                        console.log("연결실패");
                    }
                })
            }
            function nickNameCheck(){
                $.ajax({
                    url: "nickNameCheck.me",
                    data: {userNickName : $("#nickName").val()},
                    type: "post",
                    success: function(result){
                    	if(result>0){
                    		alert("이미 사용중인 닉네임 입니다! 다시 입력해주세요!");
                    		$("#nickName").val("");
                    		$("#nickName").focus();
                    	}else{
                    		alert("사용 가능한 닉네임 입니다!");
                    		$("#nickName").attr("disabled",true);
                    	}
                    },
                    error: function(){
                        console.log("연결실패");
                    }
                })
            }
            function memEnrollBtn(){
                console.log($("#pswd1").val());
                console.log($("#pswd2").val());
            	if($("#id").prop("disabled")==true && $("#nickName").prop("disabled")==true){
            		if($("#pswd1").val()!=$("#pswd2").val()){
                        $("#pswd1").focus();
                        $("#pswd1").val("");
                        $("#pswd2").val("");
                        alert("비밀번호가 서로 다릅니다! 다시 입력해주세요!");
                        return false;
                    }else{
                    	$("#id").attr("disabled",false);
                    	$("#nickName").attr("disabled",false);
                    }
            	}else if($("#id").prop("disabled")==false && $("#nickName").prop("disabled")==false){
            		alert("아이디와 닉네임을 중복 확인해 주세요!");
                    return false;
            	}else if($("#id").prop("disabled")==false && $("#nickName").prop("disabled")==true){
            		alert("아이디를 중복 확인해 주세요!");
                    return false;
            	}else if($("#id").prop("disabled")==true && $("#nickName").prop("disabled")==false){
            		alert("닉네임을 중복 확인해 주세요!");
                    return false;
            	}
            }
        </script>
        <script type="text/javascript" src="<%=contextPath %>/resources/js/memberEnroll.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>