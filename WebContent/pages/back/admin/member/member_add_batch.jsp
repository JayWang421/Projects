<%@ page language="java" pageEncoding="UTF-8"%>
<%!
	public static final String MEMBER_ADD_BATCH_URL="pages/back/admin/member/member_add_batch_do.jsp" ;
%>
<jsp:include page="/pages/plugins/include_head.jsp"/>
<script type="text/javascript" src="js/back/admin/member/member_add.js"></script>
<script type="text/javascript" src="js/common/laydate/laydate.js"></script>

<form action="<%=MEMBER_ADD_BATCH_URL %>" method="post" id="memberForm">
	<table border="0">
		<tr bgcolor="#ffffff">
			<td>批量增加</td>
			
			<td>&nbsp;</td>
			
		</tr>
		<tr bgcolor="#ffffff">
			<td colspan="2"><textarea id="memberinfo" name="memberinfo" class="init"></textarea></td>
		</tr>
	</table>
	<input type="submit" value="批量增加"/>
	<input type="reset" value="重置"/><br>
	(增加格式：用户名:真实姓名:出生日期:工资:删除标记:个人说明,用户名:真实姓名:出生日期:工资:删除标记:个人说明...)
</form>
<jsp:include page="/pages/plugins/include_foot.jsp"/>