<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int ok = (int) request.getAttribute("mailok");

%>

<%if(ok == 200  ){ %>
	<script>
		alert("메일전송이 성공했습니다.");
		location.href = "luvMain.jsp"
	</script>
<%}%>