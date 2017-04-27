window.onload=function(){
	listener("mid","blur",validateMid) ;
	listener("name","blur",validateName) ;
	listener("birthday","click",laydate) ;
	listener("salary","blur",validateSalary) ;
	listener("note","blur",validateNote) ;
	listener("memberForm","submit",function(e){
		if(validateForm()){
			this.submit() ;
		}else{
			e.preventDefault() ;
		}
	}) ;
}
function validateMid(){
	return validateEmpty("mid") ;
}
function validateName(){
	return validateEmpty("name") ;
}
function validateSalary(){
	return validateRegex("salary","/^\d{1,5}(\.\d{1,3})$/") ;
}
function validateNote(){
	return validateEmpty("note") ;
}
function validateForm(){
	return validateMid() & validateName() & validateSalary() & validateNote() ;
}
