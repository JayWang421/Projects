<%@ page language="java" pageEncoding="UTF-8"%>
<%!
	public static final String MEMBER_ADD_URL="pages/back/admin/member/member_add_do.jsp" ;
%>
<jsp:include page="/pages/plugins/include_head.jsp"/>
<script type="text/javascript" src="js/back/admin/member/member_add.js"></script>
<script type="text/javascript" src="js/common/laydate/laydate.js"></script>
<form action="<%=MEMBER_ADD_URL %>" method="get" id="memberForm">
	<table border="1">
		<tr bgcolor="#ffffff">
			<td width=10%>用户名：</td>
			<td width=60%><input type="text" id="mid" name="mid" class="init" placeholder="用户名"></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>真实姓名：</td>
			<td><input type="text" id="name" name="name" class="init" placeholder="真实姓名"></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>出生日期：</td>
			<td><input type="text" id="birthday" name="birthday" class="init laydate-icon" readonly="readonly" placeholder="出生日期"></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>工资收入：</td>
			<td><input type="text" id="salary" name="salary" class="init" placeholder="工资收入"></td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>个人简介：</td>
			<td colspan="2"><textarea id="note" name="note" class="init"></textarea></td>
		</tr>
	</table>
	<input type="submit" value="提交"/>
	<input type="reset" value="重置"/>
</form>
<jsp:include page="/pages/plugins/include_foot.jsp"/>