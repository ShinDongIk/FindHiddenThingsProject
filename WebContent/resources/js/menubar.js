/*카테코리 메뉴바 hover 이벤트 */
$("#Icon").hover(function(){
    $("#cate").css("display","block");
},function(){
    $("#cate").css("display","none");
});
    
$("#cate").hover(function(){
    $("#cate").css("display","block");
},function(){
    $("#cate").css("display","none");
});
/*카테코리 메뉴바 hover 이벤트 끝*/
/*찜하기 이벤트 */
$(".heart").click(function(){
    if($(this).attr("src")=="resources/img/빈하트.png"){
        $(this).attr("src","resources/img/색깔하트.png");
    }
    else{
        $(this).attr("src","resources/img/빈하트.png");
    }
});
/*찜하기 이벤트 끝*/


