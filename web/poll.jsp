<%@ page import="au.edu.newcastle.c3155112.billing.TestClient" %>
<!--
/**
* Created by Julius Myszkowski on 14/05/2015.
* Subject: ${subjectCode} - ${subjectTitle}
* University of Newcastle
* Student Number: c3155112
* email: c3155112@uon.edu.au, julius.skye@gmail.com
*/
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Backend Billing App</title>
</head>
<body>
Polling for a payment.<br>

<%
    TestClient tq = new TestClient();
    tq.run();

%>


<a href = "poll.jsp">Poll for a payment</a>
</body>
</html>