<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.sp.notice.model.vo.Notice"%>
    
    <%
	
	Notice notice = (Notice)request.getAttribute("n");
	

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

  
    #updateForm input,#updateForm textarea{
    	width: 100%;
    	box-sizing:border-box;
    }


</style>
</head>
<body>
        <%@ include file="/views/common/menubar.jsp"%>

        <div class="outer">
            <br> <h2 align="center">공지사항 수정하기</h2>
                <form id="updateForm" action="<%=contextPath%>/update.no" method="post">
                    <input type="hidden" name="nno" value="<%=notice.getNoticeNo()%>">

                    <table align="center">
                        <tr>
                            <th width="50px">제목</th>
                            <td width="400px"><input type="text" name="title" value="<%=notice.getNoticeTitle()%>"required required></td>
                        </tr>
                        <tr>
                            <th>내용</th>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea name="content" id="" cols="30" rows="10" style="resize: none;" value=""required><%=notice.getNoticeContent()%></textarea>
                            </td>
                        </tr>

                    </table>
                    
					<div align="center">
					<button class="btn btn-success" type="submit">수정하기</button>
					<button class="btn btn-success" type="button" onclick="history.back();">뒤로가기</button>
				
					</div>
					

                </form>



        </div>



</body>
</html>