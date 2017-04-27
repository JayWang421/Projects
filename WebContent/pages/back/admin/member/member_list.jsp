<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="wzj.vo.*"%>
<%@ page import="wzj.factory.*"%>
<%@ page import="wzj.service.*"%>
<%@ page import="java.util.*"%>
<%!
	public static final String MEMBER_EDIT_URL="pages/back/admin/member/member_edit.jsp" ;
	public static final String MEMBER_DELETE_URL="pages/back/admin/member/member_delete_do.jsp" ;
%>
<jsp:include page="/pages/plugins/include_head.jsp"/>
<script type="text/javascript" src="js/back/admin/member/member_list.js"></script>
<script type="text/javascript">
	var deleteUrl="<%=request.getAttribute("basePath")%><%=MEMBER_DELETE_URL%>" ;
</script>

<%
	request.setCharacterEncoding("UTF-8") ;
	IMemberService memberService=Factory.getServiceInstance("member.service") ;
	List<Member> all=memberService.listByDelete(0);
	Iterator<Member> iter=all.iterator() ;
%> 
<table border="1">
		<tr bgcolor="#ffffff">
		 	<td width=5%><input type="checkbox" id="selectall"></td>
			<td width=10%>用户名：</td>
			<td width=10%>真实姓名</td>
			<td width=10%>生日</td>
			<td width=10%>工资</td>
			<td width=10%>个人信息</td>
		</tr>
<%
	while(iter.hasNext()){
		Member vo=iter.next() ;
%>
		<tr bgcolor="#ffffff">
			<td><input type="checkbox" id="mid" value="<%=vo.getMid()%>"></td>
			<td><a href="<%=MEMBER_EDIT_URL%>?mid=<%=vo.getMid()%>"><%=vo.getMid()%></a></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getBirthday() %></td>
			<td><%=vo.getSalary() %></td>
			<td><%=vo.getNote() %></td>
		</tr>

<% 
	}
%>
</table>
<button id="deleteBtn">删除选中的用户信息</button>
<jsp:include page="/pages/plugins/include_foot.jsp"/>