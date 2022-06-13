<%@page import="com.sp.chat.model.vo.ChatInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sp.chat.model.vo.Chat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalTime,java.time.format.DateTimeFormatter"%>
<% 
	Chat c = (Chat)request.getAttribute("Chat");
	ArrayList<ChatInfo> list = (ArrayList<ChatInfo>)request.getAttribute("list");
	int chatNo = 0;
%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/views/common/menubar.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <title>숨은 물건 찾기 체팅목록</title>
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/css/chat.css">
</head> 
<body>
	<br>
    <div class="wrap">
        <div id="chat_content" class="clear">
            <div id="chat_content_1">
            	<%if(list!=null){ %>
	            	<%for(ChatInfo ch : list){ %>
		            	<div class="chatlist-area">
                        <input type="hidden" value="<%=ch.getChatNo()%>">
					            글제목 : <%=ch.getProductTitle()%><br>
					            판매자 : <%=ch.getSellerNickName() %><br>
					            구매자 : <%=ch.getBuyerNickName() %><br>
		                </div>
		            <%} %>
	            <%} %>
            </div>
            <div id="chat_content_2">
                <div id="chat_content2_0" >
                    <div id="chat-title" align="center">
                        <h3>채팅내용</h3> 
                    </div>
                </div>
                <div id="chat-button-area">
                    <div id="chatExit-area">
                        <button id="exit">나가기</button>
                    </div>
                </div>
                
                <div id="chat_content2_1" style="clear:both;">
                    <textarea name=""  id="chatContent" readonly></textarea>
                </div>
                <div id="chat_content2_2">
                       <div id="chatContent_area" style="display: inline-block; width: 83%;">
                           <input type="text" id="sendContent" onkeypress="enter();" required>
                       </div>     
                       <div id="send" style="display: inline-block; width: 17%;">
                       		<input id="textarea-hidden" type="hidden">
                           <button id="sendBtn">전송</button>
                       </div>
                </div> 
            </div>
        </div>
       </div>
       <script>
       function startChat(){
	       	setInterval(function(){
	       	var str = "";
			 $.ajax({
	             url : "chatLoad.ch",
	             data : {
	                chatNo : $("#textarea-hidden").val()
	             },
	             type : "post",
	             success : function(result){
	        		if(result.length != 0){
	        			for(var i in result){
	                          str += result[i].userNickName+"["+result[i].time+"] : "+result[i].chatContent+"\n";
	                          $("#chatContent").text(str);
	                     }
	        		}else{
	        			str += "";
	                    $("#chatContent").text(str);
						console.log("실행됨");
	        		}
	              },
	              error : function(){
	                  console.log("연결 실패");
	              }
	            });
				console.log("실행됨");
			}, 1000);
       }
       </script>
       
        <%if(c != null){ %>
        <script>
	            $(".chatlist-area").each(function(){
	             	var str = "";
	              if($(this).children().first().val()  == <%=c.getChatNo()%>){
	                       $.ajax({
	                          url : "chatLoad.ch",
	                          data : {
	                             chatNo : $(this).children().first().val()
	                          },
	                          type : "post",
	                          success : function(result){
	                     		if(result.length != 0){
	                     			for(var i in result){
		                                   str += result[i].userNickName+"["+result[i].time+"] : "+result[i].chatContent+"\n";
		                                   $("#chatContent").text(str);
		                              }
	                     		}else{
	                     			str += "";
	                                 $("#chatContent").text(str);
	                     		}
	                             
	                           },
	                           error : function(){
	                               console.log("연결 실패");
	                           }
	                         });
                             $("#textarea-hidden").attr("value",$(this).children().first().val());
                             startChat();
	                 	}
	              });
	  </script>
	  <%}%>
	  <%if(list!=null){ %>
	  <script>
	        $(".chatlist-area").click(function(){
                var str = "";
                $.ajax({
	                    url : "chatClickLoad.ch",
	                    data : {
	                        chatNo : $(this).children().first().val()
	                    },
	                    type : "post",
	                    success : function(result){
	                    	if(result.length != 0){
                     			for(var i in result){
	                                   str += result[i].userNickName+"["+result[i].time+"] : "+result[i].chatContent+"\n";
	                                   $("#chatContent").text(str);
	                              }
                     		}else{
                     			str += "";
                                 $("#chatContent").text(str);
                     		}
	                    	
	                    },
	                    error : function(){
	                        console.log("연결 실패");
                        }
	            });
                $("#textarea-hidden").attr("value",$(this).children().first().val());
                startChat();
            })
        	
            $("#sendBtn").click(function(){
            	var time = new Date();
            	var times = time.getHours()+"시 "+time.getMinutes()+"분 ";
                var str = "";
                $.ajax({
                    url : "chatSend.ch",
                    data : {
                    	chatContent : $("#sendContent").val(),
                    	userNickName : "<%=loginUser.getUserNickName()%>",
                    	time : times,
                        chatNo : $("#textarea-hidden").attr("value")
                    },
                    type : "post",
                    success : function(params) {
                        for(var i in params){
                            str += params[i].userNickName+"["+params[i].time+"] : "+params[i].chatContent+"\n";
                            $("#chatContent").text(str);
                        }
                    },
                    error : function() {
                        console.log("연결 실패");
                    }
                })
                $("#sendContent").val("");
                $("#sendContent").focus();
            })
            function enter(){
               if(event.keyCode==13) {
                    var time = new Date();
                    var times = time.getHours()+"시 "+time.getMinutes()+"분 ";
                    var str = "";
                    $.ajax({
                        url : "chatSend.ch",
                         data : {
                            chatContent : $("#sendContent").val(),
                            userNickName : "<%=loginUser.getUserNickName()%>",
                            time : times,
                            chatNo : $("#textarea-hidden").attr("value")
                        },
                        type : "post",
                        success : function(params) {
                            for(var i in params){
                                str += params[i].userNickName+"["+params[i].time+"] : "+params[i].chatContent+"\n";
                                $("#chatContent").text(str);
                            }
                        },
                        error : function() {
                            console.log("연결 실패");
                        }
                    })
                    $("#sendContent").val("");
                    $("#sendContent").focus();
                }
            }
            $("#exit").click(function(){
            	var val = $("#textarea-hidden").attr("value");
            	if(typeof val =="undefined"){
            		alert("나가실 체팅방을 선택해주세요!!");
            	}else{
            		location.href = "<%=contextPath%>/chatExit.ch?userNo=<%=loginUser.getUserNo()%>&chatNo="+val;
            	}
            	clearInterval(startChat());
            })
        </script>
        <%}%>
    </body>
</html>