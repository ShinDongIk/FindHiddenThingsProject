<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.sp.notice.model.vo.Faq,
    		com.sp.product.model.vo.PageInfo,
    		java.util.ArrayList"%>
<%@ include file = "/views/common/menubar.jsp"%>
<%
	ArrayList<Faq> list = (ArrayList<Faq>)request.getAttribute("list");
	Faq f = (Faq)request.getAttribute("faq");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	int count = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- BootStrap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" />
	<link rel="stylesheet"  type="text/css" href="<%=contextPath %>/resources/css/noticeStyle.css">
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!-- 	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script> -->
<!-- 	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script> -->
<!-- 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> -->
	
	
</head>
<body>
	 <!-- 관리자만 등록/수정/삭제 가능하게 -->
	 <div id="notic_outer">
            <div id="notic_content_1">
            </div>   

            <div id="notic_content_2">
                <div id="notic_content_2_1">
                    <table>
                        <td><img src="resources/img/집.png" style="height: 30px;"></td>
                        <td><a href="">홈</a> ></td>
                        <td><a href="">고객센터</a> > </td>
                        <td><a href="">FAQ</a></td>
                    </table>
                </div>
                <div id="notic_content_2_2">
                    <h1 style="color: rgb(44, 201, 110);">FAQ(자주 묻는 질문)</h1> 
                </div>
                <br>
                <div id="notic_content_2_3">
	              <table align="center" id="notic_noticeList"  class="table-hover">
                        <thead>
                            <tr>
                                <th width="100">글번호</th>
                                <th width="400">제목</th>
                                <th width="100">작성자</th>
                                <th width="100">작성일</th>
                                <th width="100">조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                           
				     		<%if(list.isEmpty()){%>
				            		<tr>
				            			<td colspan="5">존재하는 FAQ가 없습니다.</td>
				            		</tr>
				            <%}else{%>
							
							<!-- 비어있지 않을 경우 -->
				            <%for(Faq faq : list) {%>
				                <tr>
				                    <td><%=faq.getFaqNo()%></td>
				                    <td><%=faq.getFaqTitle() %></td>
				                    <td><%=faq.getUserNo() %></td>
				                    <td><%=faq.getFaqEnter() %></td>
				                    <td><%=faq.getFaqView() %></td>
				                </tr>
				          	<%}%>
				          <%} %>
                        </tbody>
                    </table>
                    <br><br>
                    
                    <script>
    				   $(function(){
       				     $(".table-hover>tbody>tr").click(function(){
           			     var fno = $(this).children().eq(0).text(); 
           			     location.href='<%=contextPath%>/faqDetail.no?fno='+fno;
			            });
			        });
    				</script>
			                
                    <br><br>
                    <%if(loginUser!=null && loginUser.getUserNo() == 1){%>
                    <div id="notic_writeBtn"  align="right" >
                        <button class="btn btn-success" onclick="location.href='<%=contextPath %>/faqEnrollForm.no'";>글작성</button>
<%-- 	                        <button class="btn btn-success" onclick="location.href='<%=contextPath%>/faqUpdateForm.no?fno=<%=f.getFaqNo()%>'";>글수정</button> --%>
<%-- 	                        <button class="btn btn-success" onclick="location.href='<%=contextPath%>/faqDelete.no?fno=<%=f.getFaqNo()%>'";>글삭제</button> --%>
                    </div>
                <% } %>
                    
                    <div class="page_wrap" align="center">
                    <div class="page_nation">
                        <%if(pi.getCurrentPage()!=1){ %>
                    <a class="arrow prev" onclick="location.href='<%=contextPath%>/faqList.no?faqListPage=<%=pi.getCurrentPage()-1%>'"><</a>
                    <%} %>  
                    <%for(int i=pi.getStartPage(); i<=pi.getEndPage(); i++){ %>
                       <a class="active" onclick="location.href='<%=contextPath%>/faqList.no?faqListPage=<%=i%>'"><%=i%></a>
                    <%} %>
                    <%if(pi.getCurrentPage()!=pi.getMaxPage()){ %>
                       <a class="arrow next" onclick="location.href='<%=contextPath%>/faqList.no?faqListPage=<%=pi.getCurrentPage()+1%>'">></a>
                    </div>
                    <%} %> 
                 </div>
            </div>
          </div>
        </div>
</body>
</html>