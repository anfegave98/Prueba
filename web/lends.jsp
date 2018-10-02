
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-12 grid-margin">
        <div class="card">
            <div class="card-header header-sm d-flex justify-content-between align-items-center">

                <h4 class="card-title">Inventario</h4>
                <div>
                    <button type="button" onclick="openURL('lendsAdd')" class="btn btn-success btn-fw">Agregar</button> 
                </div>
            </div>
            <div class="card-body">



                <div class="table-responsive">
                    <table id="lend_table" class="table table-bordered table-striped table-hover js-basic-example dataTable">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Cliente ID</th>
                                <th>Fecha Inicio</th>
                                <th>Fecha Devolución</th>
                                <th></th>
                            </tr>
                        </thead>
                    </table>
                </div>                                        
            </div>
        </div>
    </div>
</div>