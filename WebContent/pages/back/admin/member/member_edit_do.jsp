<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="wzj.vo.*"%>
<%@ page import="wzj.factory.*"%>
<%@ page import="wzj.service.*"%>
<%!
	public static final String MEMBER_LIST_URL="pages/back/admin/member/member_list.jsp" ;
%>
<jsp:include page="/pages/plugins/include_head.jsp"/>
<%
	request.setCharacterEncoding("UTF-8") ;
	Member vo=new Member() ;
	vo.setMid(request.getParameter("mid")) ;
	vo.setName(request.getParameter("name")) ;
	vo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"))) ;
	vo.setSalary(Double.parseDouble(request.getParameter("salary"))) ;
	vo.setNote(request.getParameter("note"))  ;
	boolean flag=false ;
	IMemberService memberService=Factory.getServiceInstance("member.service") ;
	flag=memberService.edit(vo) ;
	String msg="用户修改失败" ;
	if(flag){
		msg="用户修改成功" ;
	}
%>
<jsp:include page="/pages/plugins/forward.jsp">
	<jsp:param name="msg" value="<%=msg%>" />
	<jsp:param name="url" value="<%=MEMBER_LIST_URL%>" />
</jsp:include>
<jsp:include page="/pages/plugins/include_foot.jsp"/>