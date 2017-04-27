window.onload=function(){
	listener("selectall","click",function(){
		checkboxSelectAll("selectall","mid") ;
	}) ;
	listener("deleteBtn","click",function(){
		handleDelete("mid",deleteUrl) ;
	}) ;
}