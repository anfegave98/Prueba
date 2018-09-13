<%@page import="Model.Company"%>
<%
                            if (request.getSession().getAttribute("company") != null) {
                                Company u = (Company) request.getSession().getAttribute("usuario");
                            }
                            else{
                                response.sendRedirect("signin.jsp");
                            }
                        %>