<%-- 
    Document   : login
    Created on : 12/09/2018, 06:50:18 AM
    Author     : juand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="Model.Company"%>
<%

    String name = "";
    String email = "";
    String primary_color = "";
    String secondary_color = "";
    String theme = "light";
    String logoScr = "";

    Company c = null;
    if (request.getSession().getAttribute("company") != null) {
        c = (Company) request.getSession().getAttribute("company");
        name = c.getName();
        email = c.getEmail();
        primary_color = c.getPrimary_color();
        secondary_color = c.getAccent_color();
        logoScr = c.getLogo();
    } else {
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>BI-Stock | Intelligence for your Business</title>
        <%@ include file="includes/stylesheet.jsp" %>
        <link rel="stylesheet" href="assets/css/demo_1/style.css">
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
    <body>
        <div class="container-scroller">
            <!-- partial:partials/_navbar.html -->
            <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
                    <a class="navbar-brand brand-logo" href="index.html">
                        <img src="assets/images/bistock_color.svg" alt="logo" /> </a>
                    <a class="navbar-brand brand-logo-mini" href="index.html">
                        <img src="assets/images/bistock_color_mini.svg" alt="logo" /> </a>
                </div>
                <div class="navbar-menu-wrapper d-flex align-items-center">
                    <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
                        <span class="mdi mdi-menu"></span>
                    </button>
                    <!--
                  <ul class="navbar-nav navbar-nav-left header-links d-none d-md-flex">
                    <li class="nav-item">
                      <a href="#" class="nav-link">Schedule
                        <span class="badge badge-primary ml-1">New</span>
                      </a>
                    </li>
                    <li class="nav-item active">
                      <a href="#" class="nav-link">
                        <i class="mdi mdi-elevation-rise"></i>Reports</a>
                    </li>
                    <li class="nav-item">
                      <a href="#" class="nav-link">
                        <i class="mdi mdi-bookmark-plus-outline"></i>Score</a>
                    </li>
                  </ul> -->
                    <ul class="navbar-nav navbar-nav-right">
                        <!--
                      <li class="nav-item dropdown">
                        <a class="nav-link count-indicator dropdown-toggle" id="messageDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
                          <i class="mdi mdi-file-outline"></i>
                          <span class="count">7</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list pb-0" aria-labelledby="messageDropdown">
                          <a class="dropdown-item py-3">
                            <p class="mb-0 font-weight-medium float-left">You have 7 unread mails </p>
                            <span class="badge badge-pill badge-primary float-right">View all</span>
                          </a>
                          <div class="dropdown-divider"></div>
                          <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                              <img src="assets/images/faces/face10.jpg" alt="image" class="img-sm profile-pic"> </div>
                            <div class="preview-item-content flex-grow py-2">
                              <p class="preview-subject ellipsis font-weight-medium text-dark">Marian Garner </p>
                              <p class="font-weight-light small-text"> The meeting is cancelled </p>
                            </div>
                          </a>
                          <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                              <img src="assets/images/faces/face12.jpg" alt="image" class="img-sm profile-pic"> </div>
                            <div class="preview-item-content flex-grow py-2">
                              <p class="preview-subject ellipsis font-weight-medium text-dark">David Grey </p>
                              <p class="font-weight-light small-text"> The meeting is cancelled </p>
                            </div>
                          </a>
                          <a class="dropdown-item preview-item">
                            <div class="preview-thumbnail">
                              <img src="assets/images/faces/face1.jpg" alt="image" class="img-sm profile-pic"> </div>
                            <div class="preview-item-content flex-grow py-2">
                              <p class="preview-subject ellipsis font-weight-medium text-dark">Travis Jenkins </p>
                              <p class="font-weight-light small-text"> The meeting is cancelled </p>
                            </div>
                          </a>
                        </div>
                      </li>
                      <li class="nav-item dropdown ml-4">
                        <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#" data-toggle="dropdown">
                          <i class="mdi mdi-bell-outline"></i>
                          <span class="count bg-success">4</span>
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
                        -->
                        <li class="nav-item d-none d-lg-block color-setting">
                            <a class="nav-link" href="#">
                                <i class="mdi mdi-tune"></i>
                            </a>
                        </li>
                        <li class="nav-item dropdown d-none d-xl-inline-block">
                            <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
                                <span class="profile-text">Hello, <span id="display_name" ><%=name%></span> !</span>
                                <img class="img-xs rounded-circle" src="assets/images/faces/face1.jpg" alt="Profile image"> </a>
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                                <!--<a class="dropdown-item p-0">
                                  <div class="d-flex border-bottom">
                                    <div class="py-3 px-4 d-flex align-items-center justify-content-center">
                                      <i class="mdi mdi-bookmark-plus-outline mr-0 text-gray"></i>
                                    </div>
                                    <div class="py-3 px-4 d-flex align-items-center justify-content-center border-left border-right">
                                      <i class="mdi mdi-account-outline mr-0 text-gray"></i>
                                    </div>
                                    <div class="py-3 px-4 d-flex align-items-center justify-content-center">
                                      <i class="mdi mdi-alarm-check mr-0 text-gray"></i>
                                    </div>
                                  </div>
                                </a>-->
                                <a href="perfil.jsp" class="dropdown-item mt-2"> Mi perfil</a>
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
                <!-- partial:partials/_settings-panel.html -->
                <div class="theme-setting-wrapper">
                    <div id="theme-settings" class="settings-panel">
                        <i class="settings-close mdi mdi-close"></i>
                        <div class="d-flex align-items-center justify-content-between border-bottom">
                            <p class="settings-heading font-weight-bold border-top-0 mb-3 pl-3 pt-0 border-bottom-0 pb-0">Template Skins</p>
                        </div>
                        <div class="sidebar-bg-options selected" id="sidebar-light-theme">
                            <div class="img-ss rounded-circle bg-light border mr-3"></div>Light</div>
                        <div class="sidebar-bg-options" id="sidebar-dark-theme">
                            <div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
                        <p class="settings-heading font-weight-bold mt-2">Header Skins</p>
                        <div class="color-tiles mx-0 px-4">
                            <div class="tiles primary"></div>
                            <div class="tiles success"></div>
                            <div class="tiles warning"></div>
                            <div class="tiles danger"></div>
                            <div class="tiles pink"></div>
                            <div class="tiles info"></div>
                            <div class="tiles dark"></div>
                            <div class="tiles default"></div>
                        </div>
                    </div>
                </div>
                <div id="right-sidebar" class="settings-panel">
                    <i class="settings-close mdi mdi-close"></i>
                    <div class="d-flex align-items-center justify-content-between border-bottom">
                        <p class="settings-heading font-weight-bold border-top-0 mb-3 pl-3 pt-0 border-bottom-0 pb-0">Friends</p>
                    </div>
                    <ul class="chat-list">
                        <li class="list active">
                            <div class="profile">
                                <img src="assets/images/faces/face1.jpg" alt="image">
                                <span class="online"></span>
                            </div>
                            <div class="info">
                                <p>Thomas Douglas</p>
                                <p>Available</p>
                            </div>
                            <small class="text-muted my-auto">19 min</small>
                        </li>
                        <li class="list">
                            <div class="profile">
                                <img src="assets/images/faces/face2.jpg" alt="image">
                                <span class="offline"></span>
                            </div>
                            <div class="info">
                                <div class="wrapper d-flex">
                                    <p>Catherine</p>
                                </div>
                                <p>Away</p>
                            </div>
                            <div class="badge badge-success badge-pill my-auto mx-2">4</div>
                            <small class="text-muted my-auto">23 min</small>
                        </li>
                        <li class="list">
                            <div class="profile">
                                <img src="assets/images/faces/face3.jpg" alt="image">
                                <span class="online"></span>
                            </div>
                            <div class="info">
                                <p>Daniel Russell</p>
                                <p>Available</p>
                            </div>
                            <small class="text-muted my-auto">14 min</small>
                        </li>
                        <li class="list">
                            <div class="profile">
                                <img src="assets/images/faces/face4.jpg" alt="image">
                                <span class="offline"></span>
                            </div>
                            <div class="info">
                                <p>James Richardson</p>
                                <p>Away</p>
                            </div>
                            <small class="text-muted my-auto">2 min</small>
                        </li>
                        <li class="list">
                            <div class="profile">
                                <img src="assets/images/faces/face5.jpg" alt="image">
                                <span class="online"></span>
                            </div>
                            <div class="info">
                                <p>Madeline Kennedy</p>
                                <p>Available</p>
                            </div>
                            <small class="text-muted my-auto">5 min</small>
                        </li>
                        <li class="list">
                            <div class="profile">
                                <img src="assets/images/faces/face6.jpg" alt="image">
                                <span class="online"></span>
                            </div>
                            <div class="info">
                                <p>Sarah Graves</p>
                                <p>Available</p>
                            </div>
                            <small class="text-muted my-auto">47 min</small>
                        </li>
                    </ul>
                </div>
                <!-- partial -->
                <!-- partial:partials/_sidebar.html -->
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
                                            <small class="designation text-muted">SuperAdmin</small>
                                            <span class="status-indicator online"></span>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn btn-success btn-accent btn-block">Nuevo préstamo
                                    <i class="mdi mdi-plus"></i>
                                </button>
                            </div>
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link" href="dashboard.jsp">
                                <i class="menu-icon mdi mdi-television"></i>
                                <span class="menu-title">Dashboard</span>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="bi.jsp">
                                <i class="menu-icon mdi mdi-lightbulb-outline"></i>
                                <span class="menu-title">Business Intelligence</span>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="prestamos.jsp">
                                <i class="menu-icon mdi mdi-notification-clear-all"></i>
                                <span class="menu-title">Préstamos</span>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="inventario.jsp">
                                <i class="menu-icon mdi mdi-table"></i>
                                <span class="menu-title">Inventario</span>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="clientes.jsp">
                                <i class="menu-icon mdi mdi-lightbulb-outline"></i>
                                <span class="menu-title">Clientes</span>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="administradores.jsp">
                                <i class="menu-icon mdi mdi-shield-outline"></i>
                                <span class="menu-title">Administradores</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- start -->
                <div class="main-panel">
                    <div class="content-wrapper">
                        <p></p>
                        <div class="row">
                            <div class="col-lg-12 grid-margin">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Top 5</h4>
                                        <div class="table-responsive">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th> # </th>
                                                        <th> First name </th>
                                                        <th> Progress </th>
                                                        <th> Amount </th>
                                                        <th> Sales </th>
                                                        <th> Deadline </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="font-weight-medium"> 1 </td>
                                                        <td> Herman Beck </td>
                                                        <td>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-success progress-bar-striped" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                                            </div>
                                                        </td>
                                                        <td> $ 77.99 </td>
                                                        <td class="text-danger"> 53.64%
                                                            <i class="mdi mdi-arrow-down"></i>
                                                        </td>
                                                        <td> May 15, 2015 </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="font-weight-medium"> 2 </td>
                                                        <td> Messsy Adam </td>
                                                        <td>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-danger progress-bar-striped" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                                            </div>
                                                        </td>
                                                        <td> $245.30 </td>
                                                        <td class="text-success"> 24.56%
                                                            <i class="mdi mdi-arrow-up"></i>
                                                        </td>
                                                        <td> July 1, 2015 </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="font-weight-medium"> 3 </td>
                                                        <td> John Richards </td>
                                                        <td>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-warning progress-bar-striped" role="progressbar" style="width: 90%" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
                                                            </div>
                                                        </td>
                                                        <td> $138.00 </td>
                                                        <td class="text-danger"> 28.76%
                                                            <i class="mdi mdi-arrow-down"></i>
                                                        </td>
                                                        <td> Apr 12, 2015 </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="font-weight-medium"> 4 </td>
                                                        <td> Peter Meggik </td>
                                                        <td>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-primary progress-bar-striped" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                            </div>
                                                        </td>
                                                        <td> $ 77.99 </td>
                                                        <td class="text-danger"> 53.45%
                                                            <i class="mdi mdi-arrow-down"></i>
                                                        </td>
                                                        <td> May 15, 2015 </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="font-weight-medium"> 5 </td>
                                                        <td> Edward </td>
                                                        <td>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-danger progress-bar-striped" role="progressbar" style="width: 35%" aria-valuenow="35" aria-valuemin="0" aria-valuemax="100"></div>
                                                            </div>
                                                        </td>
                                                        <td> $ 160.25 </td>
                                                        <td class="text-success"> 18.32%
                                                            <i class="mdi mdi-arrow-up"></i>
                                                        </td>
                                                        <td> May 03, 2015 </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="font-weight-medium"> 6 </td>
                                                        <td> Henry Tom </td>
                                                        <td>
                                                            <div class="progress">
                                                                <div class="progress-bar bg-warning progress-bar-striped" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                                                            </div>
                                                        </td>
                                                        <td> $ 150.00 </td>
                                                        <td class="text-danger"> 24.67%
                                                            <i class="mdi mdi-arrow-down"></i>
                                                        </td>
                                                        <td> June 16, 2015 </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

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
        <!-- endinject -->
        <!-- Custom js for this page-->
        <script src="assets/js/demo_1/dashboard.js"></script>
        <!-- End custom js for this page-->
    </body>
</html>