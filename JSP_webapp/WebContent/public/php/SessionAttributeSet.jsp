<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.model.MemberDTO" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <jsp:useBean id="member" class="member.model.MemberDTO" />
    <%
        member = (MemberDTO)request.getAttribute("memInfo");
        String user_id = member.getMem_id();
        String user_name = member.getMem_name();
        int user_no = member.getMem_no();
        String mem_img = member.getMem_img() + user_no + ".jpg";
   
        session.setAttribute("user_id", user_id);
        session.setAttribute("user_name", user_name);
        session.setAttribute("user_no", user_no);
        session.setAttribute("mem_img", mem_img);
        
        response.sendRedirect("http://localhost:8282/JSP_webapp/index.jsp");
    %>
	
	<%-- [<%= session.getAttribute("user_id") %>] --%>
</body>
</html>