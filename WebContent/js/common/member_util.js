function listener(eleId,eventType,fun){
	document.getElementById(eleId).addEventListener(eventType,fun,false) ;
}
function validateEmpty(eleId){
	 obj=document.getElementById(eleId) ;
	 if(obj!=null) {
		 if(obj.value == ""){
		 	obj.className="wrong" ;
		 	return false ;
		 }else{
		 	obj.className="right" ;
		 	return true ;
		 }
	 }else{
		 obj.className="wrong" ;
		 return false ;
	 }
}
function validateRegex(eleId,regex){
	if(validateEmpty(eleId)){
		obj=document.getElementById(eleId) ;
		if(regex.test(obj.value)){
			obj.className="right" ;
			return true ;
		}else{
			obj.className="wrong" ;
			return false ;
		}
	}
}
function checkboxSelectAll(ctlId,eleId){
	ctlObject=document.getElementById(ctlId) ;
	eleObject=document.all(eleId) ;
	if(eleObject.length==undefined){
		eleObject.checked=ctlObject.checked ;
	}else{
		for(x=0 ;x<eleObject.length ; x++){
			eleObject[x].checked=ctlObject.checked ;
		}
	}
}
function handleDelete(eleId,delUrl) {
	eleObject=document.all(eleId) ;
	idsValue = "" ;
	if(eleObject.length==undefined){
		if(eleObject.checked){
			idsValue+=eleObject.value ;
		}	
	}else{
		for(x=0 ;x<eleObject.length ; x++){
			if(eleObject[x].checked){
				idsValue+=eleObject[x].value+"," ;
			}
		}
	}
	if(idsValue==""){
		alert("对不起，您还未选择数据，请选择") ;
	}else{
		if(window.confirm("您确定要执行此操作吗？")){
			window.location=delUrl+"?ids="+idsValue  ;
		}
	}
}
