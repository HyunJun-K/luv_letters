function chk_data() {
		var frm = document.forms['myforms'];
		var name = frm['name'].value.trim();
		var email = frm['email'].value.trim();
		var text = frm['text'].value.trim();
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		
	    if(name == ""){
	        alert("이름은 필수 사항 입니다");
	        frm['name'].focus();
	        return false;
	    }
	    
	    
	    
	    if(email == "") {
	    	alert("email은 필수 사항 입니다");
	    	frm['email'].focus();
	    	return false;
	    }else if(!regExp.test(email)){
	    	alert("email 형식에 맞지 않습니다.");
	    	frm['email'].focus();
	    	return false;
	    }
	    
	    
	    if(text == ""){
	        alert("내용은 필수 사항 입니다");
	        frm['text'].focus();
	        return false;
	    }
	    
	    var v = grecaptcha.getResponse();
		  
	    if(v.length == 0)
	    {
	    	alert("Captcha 를 체크해주세요");
	        return false;
	    }
	    
	    if(v.length != 0)
	    {
	    	$('#form-div').hide();
	    	$('#loading').show();
	    	return true;
	    }
	    
	    
	    
}// end form function 




$(document).ready(function(){
	
	$('#loading').hide();
})




