<div class="row">
    <div class="col-md-12 grid-margin stretch-card" id="div_search_client">
        <div class="card">
            <div class="card-body">
                <h4 class="card-title">Buscar Activo</h4>
                <form id="findAsset" class="forms-sample">
                    <div class="input-group col-12">

                        <input type="text" class="form-control" id="codebar" placeholder="Codigo de barras">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-success mr-2">Buscar</button>
                        </div>
                    </div>

                </form>
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


</div>