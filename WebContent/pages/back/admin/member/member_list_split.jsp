<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="wzj.vo.*"%>
<%@ page import="wzj.factory.*"%>
<%@ page import="wzj.service.*"%>
<%@ page import="java.util.*"%>
<%!
	public static final String MEMBER_EDIT_URL="pages/back/admin/member/member_edit.jsp" ;
	public static final String MEMBER_DELETE_URL="pages/back/admin/member/member_delete_do.jsp" ;
	public static final String MEMBER_LIST_URL="pages/back/admin/member/member_list_split.jsp" ;
%>
<jsp:include page="/pages/plugins/include_head.jsp"/>

<script type="text/javascript" src="js/back/admin/member/member_list.js"></script>
<script type="text/javascript">
	var deleteUrl="<%=request.getAttribute("basePath")%><%=MEMBER_DELETE_URL%>" ;
</script>
<%
	int currentPage = 1 ;	// 当前所在的页面，默认是在第1页
	int lineSize =1;	// 表示每页显示的数据行数
	int allRecorders = 0 ;	// 保存总记录的统计结果
	int pageSize = 1 ;	// 总页数
	String columnDate = "用户编号:mid|用户姓名:name" ;
	String column = request.getParameter("col") ;
	String keyWord = request.getParameter("kw") ;
%>
<%
	try {
		currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
	} catch (Exception e) {}
	try {
		lineSize = Integer.parseInt(request.getParameter("lineSize")) ;
	} catch (Exception e) {}
%>
<%
	request.setCharacterEncoding("UTF-8") ;
	IMemberService memberService=Factory.getServiceInstance("member.service") ;
	Map<String ,Object> map=memberService.list(currentPage, lineSize, column, keyWord) ;
	List<Member> all=(List<Member>)map.get("allMembers") ;
	allRecorders=(Integer)map.get("memberCount") ;
	Iterator<Member> iter=all.iterator() ;
%> 
<jsp:include page="/pages/plugins/split_plugin_search_bar.jsp">
	<jsp:param name="url" value="<%=MEMBER_LIST_URL%>"/>
	<jsp:param name="column" value="<%=column%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="columnData" value="<%=columnDate%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
</jsp:include> 

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
 <jsp:include page="/pages/plugins/split_plugin_page_bar.jsp">
	<jsp:param name="url" value="<%=MEMBER_LIST_URL%>"/>
	<jsp:param name="currentPage" value="<%=currentPage%>"/>
	<jsp:param name="lineSize" value="<%=lineSize%>"/>
	<jsp:param name="allRecorders" value="<%=allRecorders%>"/>
	<jsp:param name="column" value="<%=column%>"/>
	<jsp:param name="keyWord" value="<%=keyWord%>"/>
</jsp:include> 
<jsp:include page="/pages/plugins/include_foot.jsp"/>