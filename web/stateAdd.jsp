<!--<div class="row">
    <div class="col-md-12 grid-margin stretch-card" id="div_search_client">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Buscar Activo</h4>
                <form id="assetAdd" class="forms-sample">
                                        <div class="input-group col-12">
                    
                                            <input type="text" class="form-control" id="codebar" placeholder="Codigo de barras">
                                            <div class="input-group-append">
                                                <button type="submit" class="btn btn-success mr-2">Buscar</button>
                                            </div>
                                        </div>


                                    <div class="col-md-8 grid-margin stretch-card" id="div_asset">
                                        <div class="card">
                                            <div class="card-body">
                                                <h3 class="card-title" >Datos del Activo</h3>
                                                <p>Nombre: <span id="asset_name_show"></span></p>
                                                <p>Codebar: <span id="asset_codebar_show"></span></p>
                                                <p>Descripcion: <span id="asset_description_show"></span></p>
                                                <p>Disponibles: <span id="asset_available_show"></span></p>
                                                <p>Cantidad: <input type="text" class="form-control" id="cantidad" placeholder="Cantidad"> </p>
                                                <p>Descripcion: <input type="text" class="form-control" id="descripcion" placeholder="Razon del mantenimiento"></p>
                    
                                                <button type="button" onclick="sendState()" class="btn btn-primary btn-fw">Hacer Cambio</button> 
                                                <button type="button" onclick="showDetails()" class="btn btn-primary btn-fw">Ver mas</button>
                    
                                            </div>
                                        </div>
                                    </div>
                    <div class="col-md-8 grid-margin stretch-card" id="div_prestamo">
                        <div class="card">
                            <div class="card-body">


                                <div class="input-group col-12">

                                    <input type="text" class="form-control" id="codebar" placeholder="ID del Activo">
                                    <div class="input-group-append">
                                        <button type="submit" class="btn btn-success mr-2">Agregar</button>
                                    </div>
                                </div>                                            

                                <div class="table-responsive">
                                    <table id="items_table" class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                        <thead>
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Codebar</th>
                                                <th>Descripcion</th>
                                                <th>Disponibles</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>  
                                <br>
                                <button type="button" onclick="sendLend()" class="btn btn-primary btn-fw">Hacer préstamo</button> 
                            </div>
                        </div>
                    </div>
                </form>

                <div class="col-md-8 grid-margin stretch-card" id="sub_div_asset" style="display: none;">
                    <div class="card">
                        <div class="card-body">
                            <h3 class="card-title" >Datos del Activo</h3>
                            <p>En mantenimiento: <span id="asset_in_state_show"></span></p>
                            <p>En prestamo: <span id="asset_in_lend_show"></span></p>




                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>


</div>-->
<div class="row">

    <div class="col-md-8 grid-margin stretch-card" id="div_prestamo">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Agregar Activo</h4>
                <form id="assetAdd" class="forms-sample">
                    <div class="input-group col-12">

                        <input type="text" class="form-control" id="asset_id" placeholder="ID del Activo">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-success mr-2">Agregar</button>
                        </div>
                    </div>                                            
                </form>
                <br>
                <div class="table-responsive">
                    <table id="items_table" class="table table-bordered table-striped table-hover js-basic-example dataTable">
                        <thead>
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Disponibilidad</th>
                                <th></th>
                            </tr>
                        </thead>
                    </table>
                    <div class="input-group">
                        <input id="description" class="form-control" placeholder="Descripcion">
                        <div class="input-group-append">
                            <span class="input-group-text">
                                <i class="mdi mdi-dots-horizontal"></i>
                            </span>
                        </div>
                    </div>
                </div>  
                <br>
                <button type="button" onclick="sendState()" class="btn btn-primary btn-fw">Enviar</button> 
            </div>
        </div>
    </div>

</div>