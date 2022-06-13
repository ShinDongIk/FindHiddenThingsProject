<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.sp.notice.model.vo.QuestionReply"%>
<%@ include file="/views/common/menubar.jsp"%>
<%
	int qr = (int)request.getAttribute("questionNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer{
    background-color:  rgb(210, 248, 208);
        color: black;
        width: 1000px;
        margin: auto;
        margin-top: 50px;
	}

  
    #enrollForm input,#enrollForm textarea{
    	width: 100%;
    	box-sizing:border-box;
    }
</style>
</head>
<body>
        <div class="outer">
            <br> <h2 align="center">1:1 문의 답변 작성하기</h2>
                <form id="enrollForm" action="<%=contextPath%>/questionReplyInsert.no" method="post">
                    <input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
                    <input type="hidden" name="qno" value="<%=qr%>">

                    <table align="center">
                        <tr>
                            <th>내용</th>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea name="content" id="" cols="30" rows="10" style="resize: none;" required></textarea>
                            </td>
                        </tr>

                    </table>

					<div align="center">
					<button class="btn btn-success" type="submit">등록하기</button>
					<button class="btn btn-success" type="button" onclick="history.back();">뒤로가기</button>
				
					</div>
	

                </form>



        </div>



</body>
</html>