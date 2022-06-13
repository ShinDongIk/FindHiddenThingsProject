/*회원가입 폼 js*/

var id = document.querySelector('#id');

var pw1 = document.querySelector('#pswd1');
var pwMsg = document.querySelector('#alertTxt');

var pw2 = document.querySelector('#pswd2');
var pwMsgArea = document.querySelector('.int_pass');

var userName = document.querySelector('#name');

var gender = document.querySelector('#gender');

var email = document.querySelector('#email');

var mobile = document.querySelector('#mobile');

var error = document.querySelectorAll('.error_next_box');
 id.addEventListener("keyup", checkId);
// pw1.addEventListener("keyup", checkPw);
// pw2.addEventListener("keyup", comparePw);
userName.addEventListener("keyup", checkName);
email.addEventListener("keyup", isEmailCorrect);
mobile.addEventListener("keyup", checkPhoneNum);


$(pw1).on({ 
    keyup : function(){
        checkPw();
        comparePw();
    },
});
$(pw2).on({ 
    keyup : function(){
        checkPw();
        comparePw();
    },
});


function checkId() {
    var idPattern = /^[a-zA-Z0-9]{5,20}$/;
    if(id.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
    } else if(!idPattern.test(id.value)) {
        error[0].innerHTML = "5~20자의 영문 소문자, 숫자만 사용 가능합니다.";
        error[0].style.color = "red";
        error[0].style.display = "block";
        $("#idCkBtn").attr("disabled",true);
    } else {
        error[0].innerHTML = "멋진 아이디네요!";
        error[0].style.color = "#08A600";
        error[0].style.display = "block";
        $("#idCkBtn").attr("disabled",false);
    }
}

function checkPw() {
    var pwPattern = /^[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}$/;
    if(pw1.value === "") {
        error[1].innerHTML = "필수 정보입니다.";
        pwMsg.style.display = "block";
        pwMsgArea.style.paddingRight = "40px";
        error[1].style.display = "block";
    } else if(!pwPattern.test(pw1.value)) {
        error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        error[1].style.color = "red";
        pwMsg.innerHTML = "사용불가";
        pwMsgArea.style.paddingRight = "93px";
        error[1].style.display = "block";
        pwMsg.style.color = "red";
        pwMsg.style.display = "block";
    } else {
        error[1].innerHTML = "사용가능한 비밀번호 입니다!";
        error[1].style.color = "#08A600";
        error[1].style.display = "block";
        pwMsg.innerHTML = "안전";
        pwMsgArea.style.paddingRight = "93px";
        pwMsg.style.color = "#03c75a";
        pwMsg.style.display = "block";
    }
}

function comparePw() {
    if(pw2.value === pw1.value) {
        error[2].style.display = "none";
        error[2].innerHTML = "비밀번호가 일치합니다!";
        error[2].style.color = "#08A600";
        error[2].style.display = "block";
    } else if(pw2.value !== pw1.value) {
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.color = "red";
        error[2].style.display = "block";
    } 
    if(pw2.value === "") {
        error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block";
    }
}

function checkName() {
    var namePattern = /^[a-zA-Z가-힣]{3,16}$/;
    if(userName.value === "") {
        error[3].innerHTML = "필수 정보입니다.";
        error[3].style.display = "block";
    } else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
        error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[3].style.color = "red";
        error[3].style.display = "block";
    } else {
        error[3].innerHTML = "이름을 잘 입력하셨습니다!";
        error[3].style.color = "#08A600";
        error[3].style.display = "block";
    }
}

function isEmailCorrect() {
    var emailPattern = /^[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9.]{2,}$/;

    if(email.value === ""){ 
        error[5].innerHTML = "필수 정보입니다.";
        error[5].style.display = "none"; 
    } else if(!emailPattern.test(email.value)) {
        error[5].innerHTML = "이메일 형식이 틀렸습니다!";
        error[5].style.color = "red";
        error[5].style.display = "block";
    } else {
        error[5].innerHTML = "이메일을 잘 입력하셨습니다!";
        error[5].style.color = "#08A600";
        error[5].style.display = "block"; 
    }

}

function checkPhoneNum() {
    var isPhoneNum= /^\d{3}-\d{3,4}-\d{4}$/;
    if(mobile.value === "") {
        error[6].innerHTML = "필수 정보입니다.";
        error[6].style.display = "block";
    } else if(!isPhoneNum.test(mobile.value)) {
        error[6].innerHTML = "형식에 맞지 않는 전화번호입니다.";
        error[6].style.color = "red";
        error[6].style.display = "block";
    } else {
        error[6].innerHTML = "전화번호를 잘 입력하셨습니다!";
        error[6].style.color = "#08A600";
        error[6].style.display = "block";
    }

    
}