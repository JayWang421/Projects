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
	String memberInfo=request.getParameter("memberinfo").trim() ;
	Set<Member> allMembers=new HashSet<Member>() ;
	String result [] =memberInfo.split(",") ;
	for(int x=0 ; x<result.length ; x++){
		String temp[] =result[x].split(":") ;
		Member vo=new Member() ;
		vo.setMid(temp[0]) ;
		vo.setName(temp[1]); 
		vo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(temp[2])) ;
		vo.setSalary(Double.parseDouble(temp[3])) ;
		vo.setDel(Integer.parseInt(temp[4])) ;
		vo.setNote(temp[5]) ;
		allMembers.add(vo) ;
	} 
	boolean flag=false ;
	IMemberService memberService=Factory.getServiceInstance("member.service") ;
	flag=memberService.addBatch(allMembers) ;
	String msg="用户信息批量增加失败" ;
	if(flag){
		msg="用户信息批量增加成功" ;
	}
%>
<jsp:include page="/pages/plugins/forward.jsp" >
	<jsp:param name="msg" value="<%=msg%>" />
	<jsp:param name="url" value="<%=MEMBER_LIST_URL%>" />
</jsp:include>
<jsp:include page="/pages/plugins/include_foot.jsp"/>