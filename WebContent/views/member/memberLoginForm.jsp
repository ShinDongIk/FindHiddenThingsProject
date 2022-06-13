<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sp.member.model.vo.Member" %>
    
    <%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String contextPath = request.getContextPath();
%>

<!doctype html>
<html lang="en">
  <head>
    
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/loginform.css">
    <title>로그인</title>
  </head>
  <body>
        <div class="text-center mt-5">
        <form style="max-width:480px;margin:auto;" action="<%=contextPath%>/login.me" method="post" id="login-form">
            <img class="mt-4 mb-4" src="https://cdn.discordapp.com/attachments/965787913822548065/969494649658015764/7a02fa5b21b188e4.jpg" width="500">
            <hr>
            <label for="userId" class="visually-hidden">아이디</label>
            <input class="form-control form-control-lg" placeholder="아이디를 입력하세요." type="text" name="userId" required autofocus> <br>
            <label for="userPwd" class="visually-hidden">비밀번호</label>
            <input class="form-control form-control-lg" placeholder="비밀번호를 입력하세요."type="password" name="userPwd" required> <br>
        
            <div class="d-grid gap-2 mx-auto">
            <button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
            <button class="btn btn-lg btn-secondary btn-block"type="button" onclick="enrollPage();">회원가입</button>
        </div>  
        
        <script>
            function enrollPage(){
            	location.href="<%=contextPath%>/enrollForm.me";
            }
        </script>

        </form>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>