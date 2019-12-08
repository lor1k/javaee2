<%@ page import="javax.mail.Session" %><%--
  Created by IntelliJ IDEA.
  User: shlap
  Date: 08.12.2019
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTTP</title>
</head>
<body>
<form action="httpGetBaseServlet" style="border: black dot-dash 2px; margin: 10px">
    <label>Click to get base!</label>
    <input type="submit" value="BASE!">
</form>
<form action="httpGetFactServlet" style="border: black dot-dash 2px; margin: 10px">
    <label for="num">Input number to get factorial"</label>
    <input type="number" id="num" name="num">
    <input type="submit" value="FACT!">
</form>
<%
    HttpSession s =  request.getSession();



%>
</body>
</html>
