<%@page import=""%>
<%
                            if (request.getSession().getAttribute("usuario") != null) {
                                Usuario u = (Usuario) request.getSession().getAttribute("usuario");
                                if(u.getTipo().equals("1")){
                                    
                                }if(u.getTipo().equals("2")){
                                    response.sendRedirect("organizador.jsp");
                                }
                            }
                            else{
                                response.sendRedirect("signin.jsp");
                            }
                        %>