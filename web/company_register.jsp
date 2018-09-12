<%-- 
    Document   : company_register
    Created on : 11/09/2018, 07:38:14 PM
    Author     : juand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>BI-Stock | Register your Business</title>
        <%@ include file="includes/stylesheet.jsp" %>
        <link rel="stylesheet" href="assets/css/demo_1/style.css">
        <link rel="stylesheet" href="assets/css/shared/awesome-bootstrap-checkbox.css">
    </head>

    <body>
        <div class="container-scroller landing-page">
            <div class="container-fluid top-banner">
                <div class="top-banner-overlay">
                    <nav class="navbar navbar-expand-lg bg-transparent">
                        <div class="row flex-grow">
                            <div class="col-md-8 d-lg-flex flex-row mx-auto">
                                <a class="navbar-brand" href="index.html">
                                    <img src="assets/images/bistock_white.svg" alt="logo"/>
                                </a>
                                <button class="navbar-toggler collapsed float-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon ti ti-menu text-white"></span>
                                </button>
                                <div class="collapse navbar-collapse text-white" style="flex-direction: row-reverse;" id="navbarSupportedContent">
                                    <h2 style="align-self: flex-start; font-weight: 100">Registrar Empresa</h2>
                                </div>
                            </div>
                        </div>
                    </nav>
                    <div class="row">
                        <div class="col-md-8 mx-auto">
                            <form id="register-form" class="" action="TEST" autocomplete="off">
                                <h3>Empresa</h3>
                                <section>
                                    <div class="row">
                                        <div class="col-lg-6 col-md-12">
                                            <div class="col-12">
                                                <h4>Configura tu empresa</h4>
                                                <p>Comencemos por llenar los datos principales de tu empresa y configurar tu pantalla principal</p>
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="name">Nombre de la empresa</label>
                                                <input value="empresa" id="name" type="text" placeholder="Ingrese el nombre de su empresa" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label>Sector</label><br>
                                                <select id="sectors" class="selectpicker" data-dropup-auto="false" data-size="10" style="width:100%">
                                                    <option value=""> </option>
                                                    <option value="1">Automóviles</option>
                                                    <option value="2">Tecnología</option>
                                                    <option value="3">Medicina</option>
                                                    <option value="4">Educación</option>
                                                    <option value="5">Almacenes</option>
                                                </select>

                                            </div>
                                            <div class="form-group col-12">
                                                <label for="primary_color">Color principal</label>
                                                <input type='text' class="color-picker" value="#128bfc" id="primary_color"/>
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="accent_color">Color secundario</label>
                                                <input type='text' class="color-picker" value="#15b67d" id="secondary_color"/>
                                            </div>

                                            <div class="form-group col-12">
                                                <div class="form-check-inline">
                                                    <label class="form-check-label">
                                                        <input type="radio" value="light" name="basic_color" checked> Tema claro
                                                    </label>
                                                </div>

                                                <div class="form-check-inline">
                                                    <label class="form-check-label">
                                                        <input type="radio" value="dark" name="basic_color">Tema oscuro
                                                    </label>
                                                </div>
                                            </div>

                                            <div class="form-group col-12">
                                                <label for="logo">Logo de la Empresa</label>
                                                <input type="file" id="logo" class="dropify" data-height="80" data-max-file-size="3M" data-allowed-file-extensions="png jpg svg jpeg"/>
                                                <p class="small-text">Sube una imagen PNG, JPG o SVG de tu logo completo de forma horizontal. Peso máximo: 3 MB. Tamaño recomendado: 2500px *  56px</p>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-12">
                                            <div class="card dark-transparent-card">
                                                <div class="card-body">
                                                    <div style="background-color: #e6e6e6" id="background-prev">
                                                        <nav id="colorbar" class="navbar default-layout col-lg-12 col-12 p-0 d-flex flex-row">
                                                            <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
                                                                <a class="navbar-brand brand-logo" href="index.html">
                                                                    <img id="logoprev" src="assets/images/bistock_color.svg" alt="logo"> </a>
                                                                <a class="navbar-brand brand-logo-mini" href="index.html">
                                                                    <img src="assets/images/bistock_color_mini.svg" alt="logo"> </a>
                                                            </div>
                                                            <div class="navbar-menu-wrapper d-flex align-items-center">
                                                                <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-toggle="minimize">
                                                                    <span class="mdi mdi-menu"></span>
                                                                </button>

                                                            </div>
                                                        </nav>
                                                        <nav class="sidebar sidebar-offcanvas" style="min-height: 450px;" id="sidebar">
                                                            <ul class="nav">
                                                                <li class="nav-item nav-profile">
                                                                    <div class="nav-link">
                                                                        <div class="user-wrapper">
                                                                            <div class="profile-image">
                                                                                <img src="assets/images/faces/face1.jpg" alt="profile image"> </div>
                                                                            <div class="text-wrapper">
                                                                                <p class="profile-name">[Admin]</p>
                                                                                <div>
                                                                                    <small class="designation text-muted">SuperAdmin</small>
                                                                                    <span class="status-indicator online"></span>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <button id="colorbutton" class="btn btn-success btn-block">Nuevo préstamo
                                                                            <i class="mdi mdi-plus"></i>
                                                                        </button>
                                                                    </div>
                                                                </li>

                                                                <li class="nav-item active">
                                                                    <a id="colorlink" class="nav-link" href="dashboard.jsp" aria-expanded="true">
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
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </section>
                                <h3>Sede Principal</h3>
                                <section>
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12">
                                            <div class="col-12">
                                                <h4>Configura tu sede principal</h4>
                                                <p>Agrega los datos de tu sede principal, los cuales se mostrarán a tus clientes. <br>Puedes agregar otras sedes más adelante.</p>
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="sedeName">Nombre de la sede *</label>
                                                <input value="sede" id="sedeName" type="text" placeholder="Ingrese el nombre de la sede" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="address">Dirección *</label>
                                                <input value="dir" id="address" type="text" placeholder="Ingrese la dirección" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="phone_1">Teléfono 1 *</label>
                                                <input value="p1" id="phone_1" type="text" placeholder="Ingrese el teléfono principal" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="phone_2">Teléfono 2</label>
                                                <input value="p2" id="phone_2" type="text" placeholder="Ingrese el teléfono secundario" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="emailAtencion">Email de Atención al Cliente</label>
                                                <input value="eAten" type="email" class="form-control" id="emailAtencion" placeholder="Ingrese el correo de atención">
                                            </div>
                                            
                                        </div>

                                    </div>
                                </section>
                                <h3>Cuenta</h3>
                                <section>
                                    <div class="row">
                                        <div class="col-lg-6 col-md-12">
                                            <div class="col-12">
                                                <h4>Configura tu cuenta</h4>
                                                <p>Datos de la cuenta.</p>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-12">

                                            <div class="form-group col-12">
                                                <label for="adminName">Nombres</label>
                                                <input value="nombres" type="text" class="form-control" id="adminName" placeholder="Ingrese sus nombres">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="last_name">Apellidos</label>
                                                <input value="apellidos" type="text" class="form-control" id="last_name" placeholder="Ingrese sus apellidos">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="adminEmail">Email</label>
                                                <input value="email de" type="email" class="form-control" id="adminEmail" placeholder="Ingrese su correo principal">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="pass">Contraseña</label>
                                                <input type="password" class="form-control" id="pass" placeholder="Ingrese su contraseña">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="pass2">Confirmar Contraseña</label>
                                                <input type="password" class="form-control" id="pass2" placeholder="Confirme su contraseña">
                                            </div>
                                        </div>

                                    </div>
                                </section>
                            </form>
                        </div>
                    </div>
                </div>
            </div> 
            <footer class="container-fluid footer">
                <div class="row pb-5 text-white footer-top">
                    <div class="col-md-8 mx-auto">
                        <div class="row">
                            <div class="col-md-3">
                                <img src="assets/images/bistock_white.svg" class="brand-logo" alt="logo"/>
                                <div class="d-flex flex-row footer-social-icons">
                                    <i class="ti-facebook bg-facebook"></i>
                                    <i class="ti-google bg-google"></i>
                                    <i class="ti-twitter-alt bg-twitter"></i>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="row contact-details">
                                    <div class="col-12 d-flex mb-3">
                                        <i class="ti-mobile mr-4"></i>
                                        <h6 class="font-weight-normal">(0000) 1234 5678</h6>
                                    </div>
                                    <div class="col-12 d-flex mb-3">
                                        <i class="ti-settings mr-4"></i>
                                        <h6 class="font-weight-normal">support@bistock.com</h6>
                                    </div>
                                </div>
                                <ul class="nav mt-3">
                                    <li class="nav-item">
                                        <a class="nav-link btn btn-link" href="#">CARACTERÍSTCAS</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link btn btn-link" href="#">PLANES</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link btn btn-link" href="#">REGISTRO</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link btn btn-link" href="#">INGRESAR</a>
                                    </li>
                                </ul>
                            </div>
                            <div class="col-md-3">
                                <h6>Suscríbete</h6>
                                <p>Conoce nuestros beneficios.</p>
                                <div class="mt-3">
                                    <input type="email" class="form-control" placeholder="Enter your email"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row py-4 footer-bottom">
                    <div class="col-md-8 mx-auto">
                        <div class="container-fluid clearfix">
                            <span class="d-block text-center text-sm-left d-sm-inline-block">Copyright © 2018 <a href="#">BiStock Colombia</a>. Todos los derechos reservados.</span>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="assets/vendors/js/vendor.bundle.base.js"></script>
        <script src="assets/vendors/js/vendor.bundle.addons.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-select-es_ES.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page-->
        <script src="assets/js/companyRegister.js"></script>
        <!-- End plugin js for this page-->
        <!-- inject:js -->
        <script src="assets/js/shared/off-canvas.js"></script>
        <script src="assets/js/shared/hoverable-collapse.js"></script>
        <script src="assets/js/shared/misc.js"></script>
        <script src="assets/js/shared/settings.js"></script>
        <script src="assets/js/shared/todolist.js"></script>
        <script src="assets/js/shared/select2.js"></script>
        <script src="assets/js/shared/formpickers.js"></script>
        <script src="assets/js/shared/dropify.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <!-- End custom js for this page-->
    </body>

</html>
