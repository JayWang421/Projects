<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="wzj.vo.*"%>
<%@ page import="wzj.factory.*"%>
<%@ page import="wzj.service.*"%>
<%@ page import="java.util.*"%>
<%!
	public static final String MEMBER_LIST_URL="pages/back/admin/member/member_list.jsp" ;
%>
<jsp:include page="/pages/plugins/include_head.jsp"/>

<%
	request.setCharacterEncoding("UTF-8") ;
	String ids=request.getParameter("ids") ;
	Set<String> set=new HashSet<String>() ;
	String result [] =ids.split(",") ;
	for(int x=0 ;x<result.length ; x++){
		set.add(result[x]) ;
	}
	boolean flag=false ;
	IMemberService memberService=Factory.getServiceInstance("member.service") ;
	flag=memberService.delete(set) ;
	String msg="用户删除失败" ;
	if(flag){
		msg="用户删除成功" ;
	}
%>
<jsp:include page="/pages/plugins/forward.jsp" >
	<jsp:param name="msg" value="<%=msg%>"/>
	<jsp:param name="url" value="<%=MEMBER_LIST_URL%>" />
</jsp:include>
<jsp:include page="/pages/plugins/include_foot.jsp"/>