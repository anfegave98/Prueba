<%-- 
    Document   : javascriptinject
    Created on : 18/09/2018, 09:26:36 PM
    Author     : juand
--%>

<%@page contentType="text/javascript" pageEncoding="UTF-8"%>
<%
    String test = request.getParameter("name");
%>

function del() {
$("#<%=test%>").remove();
}