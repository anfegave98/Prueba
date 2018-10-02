<div class="row">
    <div class="col-md-12 grid-margin stretch-card" id="div_search_client">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Buscar cliente</h4>
                <form id="findClient" class="forms-sample">
                    <div class="input-group col-12">

                        <input type="text" class="form-control" id="client_email" placeholder="Email del Cliente">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-success mr-2">Buscar</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
    <div class="col-md-8 grid-margin stretch-card" id="div_prestamo">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Agregar Prestamo</h4>
                <form id="assetAdd" class="forms-sample">
                    <div class="input-group col-12">

                        <input type="text" class="form-control" id="asset_id" placeholder="ID del Activo">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-success mr-2">Agregar</button>
                        </div>
                    </div>                                            
                </form>

                <div class="table-responsive">
                    <table id="items_table" class="table table-bordered table-striped table-hover js-basic-example dataTable">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Solicitados</th>
                                <th></th>
                            </tr>
                        </thead>
                    </table>
                </div>  
                <br>
                <h3 class="card-title" >Dia maximo de devolucion</h3>
                <div class="row">
                    <div class='col-sm-6'>
                        <div class="form-group">
                            <div class='input-group date'  id='datetimepicker' >
                                <input  id="end_date" name="fecha" type='text' class="form-control datetimepicker" placeholder="DD/MM/AAAA" />
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="button" onclick="sendLend()" class="btn btn-primary btn-fw">Hacer préstamo</button> 
            </div>
        </div>
    </div>
    <div class="col-md-4 grid-margin stretch-card" id="div_client">
        <div class="card">
            <div class="card-body">
                <h3 class="card-title" >Datos del cliente</h3>
                <p>Nombre: <span id="client_name_show"></span></p>
                <p>Apellidos: <span id="client_last_name_show"></span></p>
                <p>Email: <span id="client_email_show"></span></p>

            </div>
        </div>
    </div>
</div>