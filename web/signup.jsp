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
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- plugins:css -->
        <link rel="stylesheet" href="assets/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="assets/vendors/iconfonts/puse-icons-feather/feather.css">
        <link rel="stylesheet" href="assets/vendors/iconfonts/ti-icons/css/themify-icons.css">
        <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.addons.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-select/bootstrap-select.min.css">
        <link rel="stylesheet" href="assets/vendors/bootstrap-checkbox/awesome-bootstrap-checkbox.css">
        <!-- endinject -->
        <!-- plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/demo.css">
        <link rel="stylesheet" href="assets/css/bistock.css">
        <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet"> 
        <link rel="stylesheet" href="assets/vendors/wait-me/waitMe.min.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="assets/images/favicon.png" />

        <style>
            body {
                background-color: #2a445a;
            }
        </style>
    </head>

    <div class="se-pre-con"></div>

    <body>
        <div class="container-scroller landing-page">
            <div class="container-fluid top-banner">
                <div class="top-banner-overlay">
                    <nav class="navbar navbar-expand-lg bg-transparent">
                        <div class="row flex-grow">
                            <div class="col-md-8 d-lg-flex flex-row mx-auto">
                                <a class="navbar-brand" href=".">
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
                        <div class="col-md-10 col-xl-8 col-lg-10 mx-auto mx-auto" style="margin-bottom: 40px;">
                            <form id="register-form" class="" action="TEST" autocomplete="off">
                                <h3>Empresa</h3>
                                <section>
                                    <div class="row">
                                        <div class="col-lg-6 col-md-12">
                                            <div class="row">
                                                <div class="col-12">
                                                    <h4>Configura tu empresa</h4>
                                                    <p>Comencemos por llenar los datos principales de tu empresa y configurar tu pantalla principal</p>
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="name">Nombre de la empresa</label>
                                                    <input required value="Jenno's Pizza" id="name" maxlength="18" type="text" placeholder="Ingrese el nombre de su empresa" class="form-control">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label>Sector</label><br>
                                                    <select required id="sectors" class="selectpicker" data-dropup-auto="false" data-size="10" style="width:100%">
                                                        <option value=""> </option>
                                                    </select>

                                                </div>
                                                <div class="form-group col-6">
                                                    <label for="primary_color">Color principal</label> <!--#128bfc-->
                                                    <input required type='text' class="color-picker" value="#128bfc" id="primary_color"/>
                                                </div>
                                                
                                                <div class="form-group col-6">
                                                    <label for="secondary_color">Color secundario</label> <!--#15b67d-->
                                                    <input required type='text' class="color-picker" value="#15b67d" id="secondary_color"/>
                                                </div>

                                                <div class="form-group col-12">
                                                    <div class="form-check-inline switchspecial">
                                                        <label class="form-check-label">
                                                            <input id="theme" data-width="437" type="checkbox" checked data-on="Tema Claro" data-off="Tema Oscuro" data-toggle="toggle" data-onstyle="secondary" data-offstyle="dark">
                                                        </label>
                                                    </div>
                                                </div>

                                                <div class="form-group col-12">
                                                    <label for="logo">Logo de la Empresa</label>
                                                    <input required type="file" id="logo" class="dropify" data-height="50" data-max-file-size="3M" data-allowed-file-extensions="png jpg svg jpeg"/>
                                                    <p class="small-text">Sube una imagen PNG, JPG o SVG de tu logo completo de forma horizontal. Peso máximo: 3 MB. Tamaño recomendado: 2500px *  56px</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-12">
                                            <div class="card dark-transparent-card">
                                                <div class="card-body">
                                                    <div style="background-color: #e6e6e6" id="background-prev">
                                                        <nav id="colorbar" class="navbar default-layout col-lg-12 col-12 p-0 d-flex flex-row">
                                                            <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
                                                                <a class="navbar-brand brand-logo" href="#">
                                                                    <img id="logoprev" src="assets/images/bistock_color.svg" alt="logo"> </a>
                                                                <a class="navbar-brand brand-logo-mini" href="#">
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
                                                                                <p class="profile-name"><span id="nombre_update">[Admin]</span></p>
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
                                                                    <a id="colorlink" class="nav-link" href="#" aria-expanded="true">
                                                                        <i class="menu-icon mdi mdi-television"></i>
                                                                        <span class="menu-title">Dashboard</span>
                                                                    </a>
                                                                </li>

                                                                <li class="nav-item">
                                                                    <a class="nav-link" href="#">
                                                                        <i class="menu-icon mdi mdi-lightbulb-outline"></i>
                                                                        <span class="menu-title">Business Intelligence</span>
                                                                    </a>
                                                                </li>

                                                                <li class="nav-item">
                                                                    <a class="nav-link" href="#">
                                                                        <i class="menu-icon mdi mdi-notification-clear-all"></i>
                                                                        <span class="menu-title">Préstamos</span>
                                                                    </a>
                                                                </li>

                                                                <li class="nav-item">
                                                                    <a class="nav-link" href="#">
                                                                        <i class="menu-icon mdi mdi-table"></i>
                                                                        <span class="menu-title">Inventario</span>
                                                                    </a>
                                                                </li>

                                                                <li class="nav-item">
                                                                    <a class="nav-link" href="#">
                                                                        <i class="menu-icon mdi mdi-lightbulb-outline"></i>
                                                                        <span class="menu-title">Clientes</span>
                                                                    </a>
                                                                </li>

                                                                <li class="nav-item">
                                                                    <a class="nav-link" href="#">
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
                                                <input required value="Jenno's Sergio" id="sedeName" name="sedeName" type="text" placeholder="Ingrese el nombre de la sede" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="address">Dirección *</label>
                                                <input required value="Calle 27A # 30" id="address" name="address" type="text" placeholder="Ingrese la dirección" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="phone_1">Teléfono 1 *</label>
                                                <input required value="3212596548" id="phone_1" name="phone_1" type="text" placeholder="Ingrese el teléfono principal" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="phone_2">Teléfono 2</label>
                                                <input required value="4896541" id="phone_2" name="phone_2" type="text" placeholder="Ingrese el teléfono secundario" class="form-control">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="emailAtencion">Email de Atención al Cliente</label>
                                                <input required value="sergio@jennos.com" type="email" class="form-control" id="emailAtencion" name="emailAtencion" placeholder="Ingrese el correo de atención">
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
                                                <input required value="Juan Sebastián" type="text" class="form-control" id="adminName" placeholder="Ingrese sus nombres">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="last_name">Apellidos</label>
                                                <input required value="Leyva" type="text" class="form-control" id="last_name" placeholder="Ingrese sus apellidos">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="adminEmail">Email</label>
                                                <input required value="gerente@jennos.com" type="email" class="form-control" id="adminEmail" placeholder="Ingrese su correo principal">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="pass">Contraseña</label>
                                                <input required type="password" class="form-control" id="pass" name="pass" placeholder="Ingrese su contraseña">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="pass2">Confirmar Contraseña</label>
                                                <input required type="password" class="form-control" id="confirm" name="confirm" placeholder="Confirme su contraseña">
                                            </div>
                                        </div>

                                    </div>
                                </section>
                            </form>
                        </div>
                    </div>
                </div>
            </div>              
            <footer class="row py-4 footer text-white" style=" background: #2a445a;border: none;">
                <div class="col-md-8 mx-auto">
                    <div class="container-fluid clearfix">
                        <span class="d-block text-center text-sm-left d-sm-inline-block">Copyright © 2018 <a href="#">BiStock Colombia</a>. Todos los derechos reservados.</span>
                    </div>
                </div>
            </footer>
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="assets/vendors/js/vendor.bundle.base.js"></script>
        <script src="assets/vendors/js/vendor.bundle.addons.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="assets/vendors/bootstrap-select/bootstrap-select-es_ES.js"></script>
        <script src="assets/vendors/wait-me/waitMe.min.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page-->
        <script src="signup.js"></script>
        <!-- End plugin js for this page-->
        <!-- inject:js -->
        <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
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
