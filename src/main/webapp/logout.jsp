<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%

HttpSession session1 = request.getSession(false);
if (session1 != null && session1.getAttribute("username") != null) {
    String username = (String) session1.getAttribute("username");

        } else {
            response.sendRedirect("login.jsp");
        }
    %>



</body>
</html>