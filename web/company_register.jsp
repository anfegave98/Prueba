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
                            <form id="register-form" class="" action="TEST" autocomplete="off">
                                <div>
                                    <h3>Empresa</h3>
                                    <section>
                                        <div class="row">
                                            <div class="col-lg-6 col-md-12">
                                                <div class="col-12">
                                                    <h4>Configura tu empresa</h4>
                                                    <p>Comencemos por llenar los datos principales de tu empresa y configurar tu pantalla principal</p>
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">NIT de la empresa</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Nombre de la empresa</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label>Sector</label><br>
                                                    <select class="selectpicker" style="width:100%" multiple>
                                                        <option value="AL">Automóviles</option>
                                                        <option value="WY">Tecnología</option>
                                                        <option value="AM">Medicina</option>
                                                        <option value="CA">Educación</option>
                                                        <option value="RU">Almacenes</option>
                                                    </select>

                                                </div>

                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Color principal</label>
                                                    <input type='text' class="color-picker" value="#3373ff" id="colorpicker"/>
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Color secundario</label>
                                                    <input type='text' class="color-picker" value="#31a8ce" id="colorpicker2"/>
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Logo de la Empresa</label>
                                                    <input type="file" id="imgInp" class="dropify" data-height="80" data-max-file-size="3M" data-allowed-file-extensions="png jpg svg jpeg"/>
                                                    <p class="small-text">Sube una imagen PNG, JPG o SVG de tu logo completo de forma horizontal. Peso máximo: 3 MB. Tamaño recomendado: 2500px *  56px</p>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-12">
                                                <div class="card dark-transparent-card">
                                                    <div class="card-body">
                                                        <h3 >Color principal</h3>
                                                        <div style="height: 30px" id="cambiarColor" class="form-group"></div>
                                                        <h3 >Color secundario</h3>
                                                        <div style="height: 30px" id="cambiarColor2" class="form-group"></div>
                                                        <h3>Logo</h3>
                                                        <img style="max-width: 100%; min-width: 50%" id="imageprev" />

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
                                                    <label for="exampleInputEmail1">Nombre de la sede</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Dirección</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Teléfono</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Teléfono 2</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Email de Atención al Cliente</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Ingrese su correo principal">
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
                                                    <p>Datos del a cuenta.</p>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-12">
                                                
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Nombres</label>
                                                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Apellidos</label>
                                                    <input type="email" class="form-control" id="test" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="veremail">Email</label>
                                                    <input type="email" class="form-control" id="veremail" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Contraseña</label>
                                                    <input type="email" class="form-control" id="contra" placeholder="Ingrese su correo principal">
                                                </div>
                                                <div class="form-group col-12">
                                                    <label for="exampleInputEmail1">Confirmar Contraseña</label>
                                                    <input type="email" class="form-control" id="contraver" placeholder="Ingrese su correo principal">
                                                </div>
                                            </div>
                                            
                                        </div>
                                    </section>
                                </div>
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
        <script src="assets/js/companyRegister.js"></script>
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
