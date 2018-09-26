<%--
    Document   : index
    Created on : 11/09/2018, 07:33:39 PM
    Author     : BiStock
    Details    : Menu markup document
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Views.MenuItem"%>
<%@page import="Model.Company"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    String name = "Admin";
    String email = "Admin";
    String primary_color = "#128bfc";
    String secondary_color = "#15b67d";
    String theme = "light";
    String logoScr = "";

    String type = "empresa";
    String role = "";
    String activeRef = "dash";

    String buttonText = "Nuevo Préstamo";
    String buttonFunction = "prestamo";


    Company c = null;
    if (request.getSession().getAttribute("company") != null) {
        c = (Company) request.getSession().getAttribute("company");
        name = c.getName();
        email = c.getEmail();
        primary_color = c.getPrimary_color();
        secondary_color = c.getAccent_color();
        logoScr = c.getLogo();
    } else {
        response.sendRedirect("login");
    }

%>

<%    // Definir elementos del menu para distintos usuarios
    ArrayList<MenuItem> menu = new ArrayList<MenuItem>();

    if (type.equalsIgnoreCase("empresa")) {
        role = "Empresa";
        menu.add(new MenuItem("dash", "mdi-television", "Dashboard"));
        menu.add(new MenuItem("movs", "mdi-notification-clear-all", "Préstamos"));
        menu.add(new MenuItem("assets", "mdi-table", "Activos"));
        menu.add(new MenuItem("clients", "mdi-lightbulb-outline", "Clientes"));
        menu.add(new MenuItem("admins", "mdi-shield-outline", "Administradores"));
    } else if (type.equalsIgnoreCase("admin")) {
        role = "Administrador";
        menu.add(new MenuItem("dash", "mdi-television", "Dashboard"));
        menu.add(new MenuItem("movs", "mdi-notification-clear-all", "Préstamos"));
        menu.add(new MenuItem("assets", "mdi-table", "Activos"));
        menu.add(new MenuItem("clients", "mdi-lightbulb-outline", "Clientes"));
        menu.add(new MenuItem("admins", "mdi-shield-outline", "Administradores"));
    } else if (type.equalsIgnoreCase("client")) {
        role = "Cliente";
        menu.add(new MenuItem("dash", "mdi-television", "Dashboard"));
        menu.add(new MenuItem("movs", "mdi-notification-clear-all", "Préstamos"));
        menu.add(new MenuItem("assets", "mdi-table", "Activos"));
    }
%>

<!DOCTYPE html>


<html lang="en">
    <head>
        <title>BI-Stock | Intelligence for your Business</title>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- plugins:css -->
        <link rel="stylesheet" href="assets/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="assets/vendors/iconfonts/puse-icons-feather/feather.css">
        <link rel="stylesheet" href="assets/vendors/iconfonts/ti-icons/css/themify-icons.css">
        <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.addons.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-select/bootstrap-select.min.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-checkbox/awesome-bootstrap-checkbox.css">
        <link rel="stylesheet" href="assets/vendors/wait-me/waitMe.min.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-material-datepicker/bootstrap-material-datetimepicker.css">

        <!-- inject:css -->
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/demo.css">
        <link rel="stylesheet" href="assets/css/bistock.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="assets/images/favicon.png" />

        <style>
            .navbar.default-layout {
                background: <%=primary_color%>;
            }
            .btn-accent {
                background: <%=secondary_color%>;
                border-color:  <%=secondary_color%>;
            }
            .sidebar .nav .nav-item.active > .nav-link {
                color: <%=primary_color%>;
            }
        </style>

    </head>

    <body class="sidebar-fixed">
        <div class="container-scroller">

            <!-- partial:partials/_navbar.html -->
            <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
                    <a class="navbar-brand brand-logo" href="app">
                        <img src="assets/images/bistock_color.svg" alt="logo" /> </a>
                    <a class="navbar-brand brand-logo-mini" href="app">
                        <img src="assets/images/bistock_color_mini.svg" alt="logo" /> </a>
                </div>
                <div class="navbar-menu-wrapper d-flex align-items-center">
                    <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
                        <span class="mdi mdi-menu"></span>
                    </button>

                    <ul class="navbar-nav navbar-nav-right">
                        <li class="nav-item dropdown ml-4">
                            <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
                                <i class="mdi mdi-bell-outline"></i>
                                <span class="count bg-danger">4</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list pb-0" aria-labelledby="notificationDropdown">
                                <a class="dropdown-item py-3 border-bottom">
                                    <p class="mb-0 font-weight-medium float-left">You have 4 new notifications </p>
                                    <span class="badge badge-pill badge-primary float-right">View all</span>
                                </a>
                                <a class="dropdown-item preview-item py-3">
                                    <div class="preview-thumbnail">
                                        <i class="mdi mdi-alert m-auto text-primary"></i>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-normal text-dark mb-1">Application Error</h6>
                                        <p class="font-weight-light small-text mb-0"> Just now </p>
                                    </div>
                                </a>
                                <a class="dropdown-item preview-item py-3">
                                    <div class="preview-thumbnail">
                                        <i class="mdi mdi-settings m-auto text-primary"></i>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-normal text-dark mb-1">Settings</h6>
                                        <p class="font-weight-light small-text mb-0"> Private message </p>
                                    </div>
                                </a>
                                <a class="dropdown-item preview-item py-3">
                                    <div class="preview-thumbnail">
                                        <i class="mdi mdi-airballoon m-auto text-primary"></i>
                                    </div>
                                    <div class="preview-item-content">
                                        <h6 class="preview-subject font-weight-normal text-dark mb-1">New user registration</h6>
                                        <p class="font-weight-light small-text mb-0"> 2 days ago </p>
                                    </div>
                                </a>
                            </div>
                        </li>
                        <li class="nav-item dropdown d-none d-xl-inline-block">
                            <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
                                <span class="profile-text">Hola, <span id="display_name" ><%=name%></span> !</span>
                                <img class="img-xs rounded-circle" src="assets/images/faces/face1.jpg" alt="Profile image"> </a>
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                                <a href="profile" class="dropdown-item mt-2"> Mi perfil</a>
                                <a onclick="logout();" style="cursor:pointer"class="dropdown-item"> Cerrar sesión </a>
                            </div>
                        </li>
                    </ul>
                    <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                        <span class="icon-menu"></span>
                    </button>
                </div>
            </nav>
            <!-- partial -->
            <div class="container-fluid page-body-wrapper"> 

                <!-- partial:partials/_sidebar.html -->
                <nav class="sidebar sidebar-offcanvas" id="sidebar">
                    <ul class="nav" accesskey="">

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

                        <% for (MenuItem item : menu) {%>
                        <li id="<%=item.getRef()%>" class="nav-item<%=(activeRef.equals(item.getRef())) ? " active" : ""%>">
                            <a style="cursor: pointer;" class="nav-link" onclick="openURL('<%=item.getRef()%>')">
                                <i class="menu-icon mdi <%=item.getMdi_icon()%>"></i>
                                <span class="menu-title"><%=item.getTitle()%></span>
                            </a>
                        </li>
                        <% }%>   
                    </ul>
                </nav>
                <!-- start -->

                <div class="main-panel" id="loader">
                    <div class="content-wrapper" id="load_content">


                    </div>
                    <!-- content-wrapper ends -->
                    <!-- partial:partials/_footer.html -->
                    <footer class="footer">
                        <div class="container-fluid clearfix">
                            <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © 2018
                                <a href="http://www.bootstrapdash.com/" target="_blank">Bootstrapdash</a>. All rights reserved.</span>
                            <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with
                                <i class="mdi mdi-heart text-danger"></i>
                            </span>
                        </div>
                    </footer>
                    <!-- partial -->
                </div>

                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="assets/vendors/js/vendor.bundle.base.js"></script>
        <script src="assets/vendors/js/vendor.bundle.addons.js"></script>
        <script src="assets/js/shared/data-table-ellipsis.js"></script>
        <script src="assets/js/shared/data-table-datetime.js"></script>
        <script src="assets/vendors/wait-me/waitMe.min.js"></script>
        <script src="assets/js/shared/moment-with-locales.js"></script>
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-select-es_ES.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page-->
        <!-- End plugin js for this page-->
        <!-- inject:js -->
        <script src="assets/js/shared/off-canvas.js"></script>
        <script src="assets/js/shared/hoverable-collapse.js"></script>
        <script src="assets/js/shared/misc.js"></script>
        <script src="assets/js/shared/settings.js"></script>
        <script src="assets/js/shared/todolist.js"></script>
        <script src="assets/js/shared/logout.js"></script>
        <script src="assets/js/shared/tooltips.js"></script>
        <script src="assets/js/shared/popover.js"></script>
        <script src="assets/js/shared/dropify.js"></script> 
        <script src="assets/vendors/bootstrap-material-datepicker/bootstrap-material-datetimepicker.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <script src="app.js"></script>
        <!-- End custom js for this page-->


    </body>

</html>



