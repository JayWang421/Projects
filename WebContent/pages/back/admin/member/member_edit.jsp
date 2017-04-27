<%@page import="wzj.factory.Factory"%>
<%@page import="wzj.service.IMemberService"%>
<%@page import="wzj.vo.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%!
	public static final String MEMBER_EDIT_URL="pages/back/admin/member/member_edit_do.jsp" ;
%>
<jsp:include page="/pages/plugins/include_head.jsp"/>
<script type="text/javascript" src="js/back/admin/member/member_edit.js"></script>
<script type="text/javascript" src="js/common/laydate/laydate.js"></script>
<%
	request.setCharacterEncoding("UTF-8") ;
	String mid=request.getParameter("mid") ;
	IMemberService memberService=Factory.getServiceInstance("member.service") ;
	Member vo=memberService.editPre(mid) ;
%>
<form action="<%=MEMBER_EDIT_URL%>" method="post" id="memberForm">
	<table border="1">
		<tr bgcolor="#ffffff">
			<td width=10%>用户名：</td>
			<td width=60%><%=vo.getMid()%></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>真实姓名：</td>
			<td><input type="text" id="name" name="name" class="init" placeholder="真实姓名" value="<%=vo.getName()%>"></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>出生日期：</td>
			<td><input type="text" id="birthday" name="birthday" class="init laydate-icon" readonly="readonly" placeholder="出生日期" value="<%=vo.getBirthday()%>"></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>工资收入：</td>
			<td><input type="text" id="salary" name="salary" class="init" placeholder="工资收入"value="<%=vo.getSalary()%>"></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>个人简介：</td>
			<td colspan="2"><textarea id="note" name="note" class="init"><%=vo.getNote() %></textarea></td>
		</tr>
	</table>
	<input type="hidden" name="mid" value="<%=vo.getMid() %>">
	<input type="submit" value="编辑"/>
	<input type="reset" value="重置"/>
</form>
<jsp:include page="/pages/plugins/include_foot.jsp"/>