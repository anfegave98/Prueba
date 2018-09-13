<%-- 
    Document   : index
    Created on : 11/09/2018, 07:33:39 PM
    Author     : BiStock
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        
        <title>BI-Stock | Intelligence for your Business</title>
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
                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                    <ul class="navbar-nav ml-auto">
                                        <li class="nav-item">
                                            <a class="nav-link btn btn-link" href="index.html">INICIO</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link btn btn-link" href="#">CARACTERÍSTCAS</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link btn btn-link" href="#">PLANES</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link btn btn-link" href="company_register.jsp">REGISTRO</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link btn btn-link" href="login.jsp">INGRESAR</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </nav>
                    <div class="row top-banner-content">
                        <div class="col-md-8 mx-auto">
                            <div class="row">
                                <div class="col-lg-7">
                                    <h1 class="mr-2 text-white">Toma desiciones que hagan crecer tu negocio
                                    </h1>
                                    <h3 style="font-size: 20px" class="font-weight-light text-white">
                                        Inteligencia de Negocios adaptable para préstamos, venta y alquiler de productos
                                    </h3>
                                    <div class="mt-5">
                                        <button class="btn btn-primary btn-lg mr-2">CONOCE MÁS</button>
                                        <button onclick="window.location.href='company_register.jsp'" class="btn btn-warning btn-lg ml-2">REGISTRATE AHORA</button>
                                    </div>
                                </div>
                                <div class="col-lg-5">
                                    <img class="top-banner-img" src="assets/images/analysis1.svg" alt="logo"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
            <div class="container-fluid bottom-section">
                <div class="row">
                    <div class="col-md-8 mx-auto">
                        <h3>Lo que te encantará de BiStock</h3>
                        <div class="feature-list">
                            <div class="row feature-list-row">
                                <div class="col-lg-3 feature-list-item">
                                    <i class="ti-briefcase"></i>
                                    <h4>Business Intelligence</h4>
                                    <p class="feature-description">Herramientas de análisis inteligente para el préstamo, renta y/o venta de productos</p>
                                </div>
                                <div class="col-lg-3 feature-list-item">
                                    <i class="ti-stats-up"></i>
                                    <h4>Reportes y Estadísticas</h4>
                                    <p class="feature-description">Estadísticas inteligentes que te permitirán reconocer la situación actual de tu empresa</p>
                                </div>
                                <div class="col-lg-3 feature-list-item">
                                    <i class="ti-bell"></i>
                                    <h4>Alertas y notificaciones</h4>
                                    <p class="feature-description">Nuestro motor de servicios te avisará con tiempo de acciones necesarias a través de BI</p>
                                </div>
                                <div class="col-lg-3 feature-list-item">
                                    <i class="ti-bar-chart"></i>
                                    <h4>Gestión de Productos</h4>
                                    <p class="feature-description">Todo lo que esperarías de un gestor de inventario flexible y fácil de usar</p>
                                </div>
                            </div>
                            <div class="row feature-list-row">
                                <div class="col-lg-3 feature-list-item">
                                    <i class="ti-help-alt"></i>
                                    <h4>Mesa de Ayuda</h4>
                                    <p class="feature-description">Contarás con la ayuda de nuestros asesores certificados para resolver tus inquietudes técnicas</p>
                                </div>
                                <div class="col-lg-3 feature-list-item">
                                    <i class="ti-layout-slider"></i>
                                    <h4>Flexible y ajustable</h4>
                                    <p class="feature-description">Personaliza tu interfaz con colores, logo y navegación flexibles</p>
                                </div>
                                <div class="col-lg-3 feature-list-item">
                                    <i class="ti-list"></i>
                                    <h4>Características dinámicas</h4>
                                    <p class="feature-description">Agrega campos personalizados e ilimitados tanto a tus clientes como a tu inventario.</p>
                                </div>
                                <div class="col-lg-3 feature-list-item">
                                    <i class="ti-lock"></i>
                                    <h4>Seguridad y Eficiencia</h4>
                                    <p class="feature-description">Maneja los datos de tu empresa con gran eficiencia y seguridad.</p>
                                </div>
                            </div>
                        <h3 style="margin-bottom: 35px">y mucho más...</h3>
                        <button onclick="window.location.href='company_register.jsp'" class="btn btn-primary btn-lg ml-2">REGISTRATE AHORA</button>
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
        <!-- endinject -->
        <!-- Plugin js for this page-->
        <!-- End plugin js for this page-->
        <!-- inject:js -->
        <script src="assets/js/off-canvas.js"></script>
        <script src="assets/js/hoverable-collapse.js"></script>
        <script src="assets/js/misc.js"></script>
        <script src="assets/js/settings.js"></script>
        <script src="assets/js/todolist.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <!-- End custom js for this page-->
    </body>

</html>
