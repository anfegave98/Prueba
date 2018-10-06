
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-lg-12 mx-auto grid-margin">
        <div class="card">
            <div class="card-header header-sm d-flex justify-content-between align-items-center">
                <h4 class="card-title" id="card-title">...</h4>
                <div>
                    <button onclick="addShow();" type="button" class="btn btn-success btn-fw ml-2"><i class="mdi mdi-plus"></i>Agregar</button>
                    <button onclick="searchShow();" type="button" class="btn btn-warning btn-fw ml-2"><i class="mdi mdi-magnify"></i>Consultar</button>
                    <button onclick="alert('Configuraciones en siguiente iteración')" style="min-width: 20px" type="button" class="btn btn-secondary btn-fw ml-2"><i class="mdi mdi-settings"></i></button>
                </div>
            </div>
            <div class="card-body">                
                <div class="table-responsive">
                    <table class="table table-bordered wrap" id="entity_table" width="100%">
                        <thead>
                            <tr>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>


</div>


<!-- Modal -->
<div class="modal fade" id="entityModal" style="padding-left:17px" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modal-title">...</h5>
                <div>
                    <button type="button" class="modal-action close" data-dismiss="modal" aria-label="Close" data-toggle="tooltip" data-placement="bottom" title="Cerrar">
                        <i class="mdi mdi-close table-button"></i>
                    </button>
                    <button type="button" class="modal-action close close-warning" id="modal-search" data-toggle="tooltip" data-placement="bottom" title="Consultar">
                        <i class="mdi mdi-magnify table-button"></i>
                    </button>
                    <button type="button" class="modal-action close close-success" id="modal-add" data-toggle="tooltip" data-placement="bottom" title="Agregar">
                        <i class="mdi mdi-plus table-button"></i>
                    </button>
                    <button type="button" class="modal-action close close-danger" id="modal-delete" data-toggle="tooltip" data-placement="bottom" title="Eliminar">
                        <i class="mdi mdi-delete table-button"></i>
                    </button>
                    <button type="button" class="modal-action close close" id="modal-undo" data-toggle="tooltip" data-placement="bottom" title="Revertir cambios">
                        <i class="mdi mdi-undo table-button"></i>
                    </button>
                    <button type="button" class="modal-action close close-info" id="modal-edit" data-toggle="tooltip" data-placement="bottom" title="Editar">
                        <i class="mdi mdi-pen table-button"></i>
                    </button>
                </div>
            </div>
            <form id="entity-form">
                <div class="modal-body">
                    <div class="container-fluid">
                        <div id="form-container">
                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Texto corto</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Texto corto" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>
                                <div class="col-lg-8">
                                    <input id="textocorto" maxlength="25" placeholder="Escribe algo..." class="form-control maxlenght" type="text"> 
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Texto largo</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Texto largo" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>
                                <div class="col-lg-8">
                                    <textarea id="textolargo" class="form-control maxlenght" maxlength="1000" rows="4" placeholder="Escribe algo de máximo 100 caracteres..."></textarea>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Número Entero</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Número Entero" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>
                                <div class="col-lg-8">
                                    <input id="entero" value="10" min="0" max="25" class="form-control" type="number"> 
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Número Decimal</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Número decimal" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <input id="decimal" step="any" value="10" min="0" max="25" class="form-control" type="number"> 
                                </div>
                            </div>



                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Sí / No</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Sí / No" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>
                                <div class="col-lg-8">
                                    <label class="form-check-label"><input type="checkbox" id="bool" class="form-check-input"> Default </label>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Fecha</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Fecha" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>
                                <div class="col-lg-8">
                                    <div class="input-group">
                                        <input type="text" id="fecha" class="form-control material-date">
                                        <span class="input-group-addon input-group-append border-left">
                                            <span class="mdi mdi-calendar input-group-text"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Fecha y hora</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Fecha y hora" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>
                                <div class="col-lg-8">
                                    <div class="input-group">
                                        <input type="text" id="fechahora" class="form-control material-timedate">
                                        <span class="input-group-addon input-group-append border-left">
                                            <span class="mdi mdi-calendar input-group-text"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Contabilidad</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Contabilidad" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">$</span>
                                        </div>
                                        <input id="contabilidad" type="number" step="any" value="10000" min="1" class="form-control" aria-label="Amount (to the nearest dollar)"> 
                                    </div>
                                </div>
                            </div>


                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Color</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Contabilidad" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <input type="text" class="color-picker" value="#11111" id="color"> 
                                </div>
                            </div>


                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Deplegable único</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Deplegable único" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <select id="despunico" class="selectpicker" data-dropup-auto="false" data-size="10" style="width:100%">
                                        <option disabled selected value=""> </option>
                                        <option value="1">Opcion 1</option>
                                        <option value="2">Opcion 2</option>
                                        <option value="3">Opcion 3</option>
                                        <option value="4">Opcion 4</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Deplegable múltiple</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Deplegable múltiple" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <select id="despmultiple" class="selectpicker" multiple data-dropup-auto="false" data-size="10" style="width:100%">
                                        <option value="1">Opcion 1</option>
                                        <option value="2">Opcion 2</option>
                                        <option value="3">Opcion 3</option>
                                        <option value="4">Opcion 4</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Opción única</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Opción única" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <label class="form-check-label"><input type="radio" class="form-check-input" name="e1" id="v1"> Opción 1 </label>
                                    <label class="form-check-label"><input type="radio" class="form-check-input" name="e1" id="v2"> Opción 2 </label>
                                    <label class="form-check-label"><input type="radio" class="form-check-input" name="e1" id="v3"> Opción 3 </label>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Opción múltiple</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Opción múltiple" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <label class="form-check-label"><input type="checkbox" id="check1" class="form-check-input"> Opción 1 </label>
                                    <label class="form-check-label"><input type="checkbox" id="check2" class="form-check-input"> Opción 2 </label>
                                    <label class="form-check-label"><input type="checkbox" id="check3" class="form-check-input"> Opción 3 </label>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Foto</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Foto" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <input type="file" data-default-file="./assets/images/product_images/apple-watch.jpg" di="photo" class="dropify" data-max-file-size="3M" data-allowed-file-extensions="png jpg svg jpeg"/>
                                    <img class="dropify-display hidden img-fluid rounded" src="./assets/images/product_images/apple-watch.jpg" alt="photo">
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Archivo</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Archivo" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>                        
                                <div class="col-lg-8">
                                    <input type="file" data-default-file="./assets/images/product_images/apple-watch.jpg" id="file" class="dropify" data-max-file-size="3M"/>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" id="modal-dismiss-button" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary" id="modal-confirm-button">Agregar entidad</button>
                </div>
            </form>
            <form id="search-form" class="hidden">
                <div class="modal-body">
                    <div class="container-fluid">
                        <div id="search-form-container">
                            <div class="form-group row">
                                <div class="col-lg-3 d-flex justify-content-between align-items-center">
                                    <label class="col-form-label">Texto corto</label>
                                    <button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" title="Texto corto" data-content="Aquí va el texto de ayuda para el elemento." data-custom-class="popover-primary">
                                        <i class="mdi mdi-help"></i></button>
                                </div>
                                <div class="col-lg-8">
                                    <input id="textocorto" maxlength="25" placeholder="Escribe algo..." class="form-control maxlenght" type="text"> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" id="modal-search-dismiss-button" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary" id="modal-search-confirm-button">Agregar entidad</button>
                </div>
            </form>
        </div>
    </div>
</div>

