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
                            <form id="register-form" method="POST" autocomplete="off">

                                <h3>Empresa</h3>
                                <section>
                                    <div class="row">
                                        <div class="col-lg-6 col-md-12">
                                            <div class="col-12">
                                                <h4>Configura tu empresa</h4>
                                                <p>Comencemos por llenar los datos principales de tu empresa y configurar tu pantalla principal</p>
                                            </div>
                                            <div class="form-group">
                                                <label for="cname">Name (required, at least 2 characters)</label>
                                                <input id="cname" class="form-control" name="name" minlength="2" type="text" required> </div>
                                            <div class="form-group">
                                                <label for="cemail">E-Mail (required)</label>
                                                <input id="cemail" class="form-control" type="email" name="email" required> </div>
                                            <div class="form-group">
                                                <label for="curl">URL (optional)</label>
                                                <input id="curl" class="form-control" type="url" name="url"> </div>

                                        </div>
                                        <div class="col-lg-6 col-md-12">

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
                                            <div class="form-group">
                                                <label for="firstname">Firstname</label>
                                                <input id="firstname" class="form-control" name="firstname" type="text"> </div>
                                            <div class="form-group">
                                                <label for="lastname">Lastname</label>
                                                <input id="lastname" class="form-control" name="lastname" type="text"> </div>
                                            <div class="form-group">
                                                <label for="username">Username</label>
                                                <input id="username" class="form-control" name="username" type="text"> </div>
                                            <div class="form-group">
                                                <label for="password">Password</label>
                                                <input id="password" class="form-control" name="password" type="password"> </div>
                                            <div class="form-group">
                                                <label for="confirm_password">Confirm password</label>
                                                <input id="confirm_password" class="form-control" name="confirm_password" type="password"> </div>
                                            <div class="form-group">
                                                <label for="email">Email</label>
                                                <input id="email" class="form-control" name="email" type="email"> </div>
                                        </div>

                                    </div>
                                </section>
                                <h3>Cuenta</h3>
                                <section>
                                    <div class="row">
                                        <div class="col-lg-6 col-md-12">
                                            <div class="col-12">
                                                <h4>Configura tu cuenta</h4>
                                                <p>Datos del a cuenta.</p>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-md-12">                                               
                                            <div class="form-group col-12">
                                                <label for="pass">Contraseña pass</label>
                                                <input type="email" class="form-control" id="pass" placeholder="Ingrese su correo principal">
                                            </div>
                                            <div class="form-group col-12">
                                                <label for="passconfirm">Confirmar Contraseña</label>
                                                <input type="email" class="form-control" id="passconfirm" placeholder="Ingrese su correo principal">
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
        <script src="assets/js/companyRegisterVal.js"></script>
        <!-- End custom js for this page-->
    </body>

</html>
