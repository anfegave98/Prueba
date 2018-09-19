<%-- 
    Document   : sidebar
    Created on : 18/09/2018, 10:15:19 PM
    Author     : juand
--%>

<%@page import="Views.MenuItem"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String name = request.getParameter("name");
    String role = "";

    String buttonText = request.getParameter("buttonText");
    String buttonFunction = request.getParameter("buttonFunction");

    String activeRef = request.getParameter("activeRef");

    ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
    
    String type = request.getParameter("type");
    
    switch (request.getParameter("type")) {
        case "empresa":
            role = "Empresa";
            menu.add(new MenuItem("dash", "mdi-television", "Dashboard", "/app"));
            menu.add(new MenuItem("movs", "mdi-notification-clear-all", "Préstamos", "/app/movs"));
            menu.add(new MenuItem("assets", "mdi-television", "Activos", "/app/assets"));
            menu.add(new MenuItem("clients", "mdi-television", "Clientes", "/app/clients"));
            menu.add(new MenuItem("admins", "mdi-television", "Administradores", "/app/admins"));
            break;
        case "admin":
            role = "Administrador";
            menu.add(new MenuItem("dash", "mdi-television", "Dashboard", "/app"));
            menu.add(new MenuItem("movs", "mdi-notification-clear-all", "Préstamos", "/app/movs"));
            menu.add(new MenuItem("assets", "mdi-television", "Activos", "/app/assets"));
            menu.add(new MenuItem("clients", "mdi-television", "Clientes", "/app/clients"));
            menu.add(new MenuItem("admins", "mdi-television", "Administradores", "/app/admins"));
            break;
        case "client":
            role = "Cliente";
            menu.add(new MenuItem("dash", "mdi-television", "Dashboard", "/app"));
            menu.add(new MenuItem("movs", "mdi-notification-clear-all", "Préstamos", "/app/movs"));
            menu.add(new MenuItem("assets", "mdi-television", "Activos", "/app/assets"));
            break;
        default:
            break;
    }
%>

<!DOCTYPE html>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
    <ul class="nav">
        <li class="nav-item nav-profile">
            <div class="nav-link">
                <div class="user-wrapper">
                    <div class="profile-image">
                        <img src="assets/images/faces/face1.jpg" alt="profile image"> </div>
                    <div class="text-wrapper">
                        <p class="profile-name"><%=name%></p>
                        <div>
                            <small class="designation text-muted"><%=role%></small>
                            <span class="status-indicator online"></span>
                        </div>
                    </div>
                </div>
                <button onclick="<%=buttonFunction%>()" class="btn btn-success btn-accent btn-block">
                    <%=buttonText%><i class="mdi mdi-plus"></i>
                </button>
            </div>
        </li>
        <% for (MenuItem item : menu) {%>}
        <li class="nav-item<%=(activeRef.equals(item.getRef())) ? " active" : ""%>">
            <a class="nav-link" onclick="changeurl(<%=item.getRef()%>)">
                <i class="menu-icon mdi <%=item.getMdi_icon()%>"></i>
                <span class="menu-title"><%=item.getTitle()%></span>
            </a>
        </li>
        <% }%>}   
