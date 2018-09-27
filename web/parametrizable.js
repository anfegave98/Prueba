// Entidad en singular y en primera mayúscula
var entity = 'boot';
var entityPrettyPrintSingular = 'boot';
var entityPrettyPrintPlural = 'boot';
var servlet = 'Attributes';
var tableDetails = true;
var tableDelete = true;
var tableModify = true;
var formContainer = 'boot';
var formid = 'boot';
var searchFormContainer = 'boot';
var searchFormid = 'boot';
var modalid = 'boot';
var tableFinished = false;
var formFinished = false;

var cols;
var table;
    
function generatePage() {
    
    $("#card-title").text(entityPrettyPrintPlural)
    
    $.ajax({
        url: "AttributesS",
        type: 'GET',
        async: false,
        dataType: "text",
        data: {
            'op': "get" + entity
        }
    }).done(function (data) {
        cols = $.parseJSON(data);
        // Generar tabla de lista con datos obtenidos
        generateTable();
        // Generar formulario con columnas obtenidas    
        generateForm();
        //initializePlugins();
    }).fail(function () {
        alert('error')
    });
}

function generateTable() {

    var btnPart1 = '<button type="button" class="btn btn-';
    var btnPart2 = ' btn-fw ml-2 tooltip-delay" data-toggle="tooltip" data-placement="left" title="';
    var btnPart3 = '"><i class="mdi ';
    var btnPart4 = ' table-button"></i></button>';
    var buttonDetails = (tableDetails) ? (btnPart1 + 'success details' + btnPart2 + 'Ver detalles' + btnPart3 + 'mdi-menu' + btnPart4) : '';
    var buttonModify = (tableModify) ? (btnPart1 + 'info modify' + btnPart2 + 'Editar' + btnPart3 + 'mdi-pen' + btnPart4) : '';
    var buttonDelete = (tableDelete) ? (btnPart1 + 'danger delete' + btnPart2 + 'Eliminar' + btnPart3 + 'mdi-delete' + btnPart4) : '';
    // Dejar parametros de mostrar en la tabla
    var colsTable = cols.filter(col => col.table == true);
    var areActions = (tableDetails || tableModify || tableDelete);
    // Si hay acciones, agregar la columna
    if (areActions)
        colsTable.push({title: "Acciones", data: null});
    var actions = buttonDetails + buttonModify + buttonDelete;
    // Establecer definiciones de columna
    var defs = [];
    if (areActions)
        defs.push({targets: -1, data: null, width: "100px", defaultContent: actions});
    // Definiciones de columna basada en formato de tipo de dato
    for (var i = 0; i < cols.length; i++) {
        switch (cols[i].type) {
            case 'textolargo':
                defs.push({targets: i, render: $.fn.dataTable.render.ellipsis(20)});
                break;
            case 'email':
                defs.push({targets: i, render: $.fn.dataTable.render.ellipsis(30)});
                break;
            case 'contabilidad':
                defs.push({targets: i, render: $.fn.dataTable.render.moneda('$')});
                break;
            case 'color':
                defs.push({targets: i, render: $.fn.dataTable.render.color()});
                break;
            case 'foto':
                defs.push({targets: i, render: $.fn.dataTable.render.photo()});
                break;
            case 'archivo':
                defs.push({targets: i, render: $.fn.dataTable.render.file()});
                break;
            case 'fecha':
                defs.push({targets: i, render: $.fn.dataTable.render.moment('YYYY-MM-DD', 'DD/MM/YYYY')});
                break;
            case 'fechahora':
                defs.push({targets: i, render: $.fn.dataTable.render.moment('YYYY-MM-DD HH:mm:ss', 'DD/MM/YYYY hh:mm:ss a', 'es')});
                break;
            case 'checkbox':
                defs.push({targets: i, render: $.fn.dataTable.render.checkbox('test')});
                break;
            case 'url':
                defs.push({targets: i, render: $.fn.dataTable.render.ellipsisLink(20)});
                break;
            default:
                break;
        }
    }

    table = $('#entity_table').DataTable({

        ajax: {
            url: entity + "S",
            type: "GET",
            dataSrc: '',
            data: {
                'op': "getall"
            }
        },
        columns: colsTable,
        columnDefs: defs,
        scrollX: true,
        order: [],
        lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "Todos"]],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        initComplete: function (oSettings) {
            $(".ellipsis").tooltip();
            $('.tooltip-delay').tooltip({
                animation: true,
                delay: {show: 700, hide: 100}
            });
            $('button').on('mousedown', function () {
                $('[data-toggle="tooltip"]').tooltip('hide');
            });
            $('[data-toggle="tooltip"]').on('mouseleave', function () {
                $('[data-toggle="tooltip"]').tooltip('hide');
            });

            tableFinished = true;
            triggerLoaderOut();

            //const datatableScroll = new PerfectScrollbar('.dataTables_scrollBody');
        }

    });
    $('#entity_table tbody').on('click', 'button.details', function () {
        var data = table.row($(this).parents('tr')).data();
        detailsShow(data.email);
    });
    $('#entity_table tbody').on('click', 'button.modify', function () {
        var data = table.row($(this).parents('tr')).data();
        modifyShow(data.email);
    });
    $('#entity_table tbody').on('click', 'button.delete', function () {
        var data = table.row($(this).parents('tr')).data();
        deleteRow(data.email);
    });



}

function triggerLoaderOut() {
    if (tableFinished && formFinished) { 
        $('#loader').waitMe("hide");
        initializePlugins();
    }
}

function refreshTable() {
    table.ajax.reload();
}
function detailsShow(id) {

    prefillForm(id);
    customizeForm('details', entityPrettyPrintSingular, 'Descripción del formulario', id);
    showModal();
}

function searchShow() {
    customizeForm('search', entityPrettyPrintSingular, 'Descripción del formulario');
    showModal();
}

function modifyShow(id) {
    prefillForm(id);
    customizeForm('modify', entityPrettyPrintSingular, 'Descripción del formulario', id);
    showModal();
}

function addShow() {
    cleanForm();
    customizeForm('add', entityPrettyPrintSingular, 'Descripción del formulario');
    showModal();
}

function deleteRow(id) {
    $.ajax({
        url: entity + "S",
        type: 'POST',
        dataType: "text",
        data: {
            'op': "deleted",
            'pk': id
        }
    }).done(function (data) {
        hideForm();
        refreshTable();
    }).fail(function () {
        alert('error')
    });
}

function generateForm() {

    cleanForm();
    $('#' + formContainer).children().remove();
    $('#' + searchFormContainer).children().remove();

    for (var i = 0; i < cols.length; i++) {
        $('#' + formContainer).append(genInput(cols[i]));
        if (cols[i].identifier)
        {
            var colSearch = Object.assign({}, cols[i]);
            colSearch['data'] = (colSearch['data']) + '-search';
            colSearch['identifier'] = false;
            $('#' + searchFormContainer).append(genInput(colSearch));
        }
    }

    formFinished = true;
    triggerLoaderOut();

}

function genInput(col) {
    var title = col.title;
    var data = col.data;
    var type = col.type;
    var description = col.description;
    var required = col.required;
    var identifier = col.identifier;
    var theHTML = [];
    var theInput = [];
    switch (type) {
        case 'textocorto':
            theInput.push('',
                    '<input id="' + data + '"' + ((required) ? ' required' : '') + ((identifier) ? ' data-id="true"' : '') + ' maxlength="25" placeholder="Escribe algo..." class="form-control maxlenght" type="text"> ');
            break;
        case 'textolargo':
            theInput.push('',
                    '<textarea id="' + data + '"' + ((required) ? ' required' : '') + ((identifier) ? ' data-id="true"' : '') + ' class="form-control maxlenght" maxlength="1000" rows="4" placeholder="Escribe algo de máximo 100 caracteres..."></textarea>');
            break;
        case 'email':
            theInput.push('',
                    '<input id="' + data + '"' + ((required) ? ' required' : '') + ((identifier) ? ' data-id="true"' : '') + ' type="email" maxlength="60" placeholder="Escribe el email..." class="form-control maxlenght">');
            break;
        case 'password':
            theInput.push('',
                    '<input id="' + data + '"' + ((required) ? ' required' : '') + ' data-pass="true" type="password" maxlength="25" placeholder="Escribe la clave..." class="form-control maxlenght">');
            break;
        case 'contabilidad':
            theInput.push('',
                    '<input id="' + data + '"' + ((required) ? ' required' : '') + ' type="number" placeholder="Indica un número..." class="form-control">');
            break;
        default:
            break;
    }


    theHTML.push('',
            '<div class="form-group row">',
            '<div class="col-lg-3 d-flex justify-content-between align-items-center">',
            '<label class="col-form-label">' + title + ((required) ? ' *' : '') + '</label>',
            '<button type="button" class="btn btn-icons btn-rounded btn-light" data-toggle="popover" ',
            'title="' + title + '" data-content="' + description + '" data-custom-class="popover-primary">',
            '<i class="mdi mdi-help"></i></button>',
            '</div>',
            '<div class="col-lg-8">',
            theInput.join(''),
            '</div>',
            '</div>');
    return theHTML.join('');
}

function prefillForm(id) {
    $.ajax({
        url: entity + "S",
        type: 'GET',
        dataType: "text",
        data: {
            'op': "get",
            'pk': id
        },
        success: function (data) {
            result = $.parseJSON(data);
            // Limpiar form
            cleanForm();
            for (var i = 0; i < cols.length; i++) {
                var type = cols[i].type;
                var id = cols[i].data;
                switch (type) {
                    case 'textocorto':
                    case 'textolargo':
                    case 'email':
                    case 'contabilidad':
                    case 'color':
                    case 'entero':
                    case 'decimal':
                        $('#' + id).val(result[id]);
                        break;
                    case 'foto':
                        break;
                    case 'archivo':
                        break;
                    case 'fecha':
                        break;
                    case 'fechahora':
                        break;
                    case 'checkbox':
                        break;
                    case 'url':
                        break;
                    default:
                        break;
                }
            }

        }
    });
}

function customizeForm(type, title, description) {
    customizeForm(type, title, description, '');
}

function customizeForm(type, title, description, id) {


    $('#modal-dismiss-button').removeClass('hidden');
    $('#modal-confirm-button').removeClass('hidden');
    $('#modal-edit').removeClass('hidden');
    $('#modal-delete').removeClass('hidden');
    $('#modal-search').removeClass('hidden');
    $('#modal-add').removeClass('hidden');
    $('#modal-undo').removeClass('hidden');

    $('.modal-action').unbind();
    $('.modal-action').tooltip();

    $('#modal-edit').click(function () {
        modifyShow(id);
    });
    $('#modal-delete').click(function () {
        deleteRow(id);
    });
    $('#modal-undo').click(function () {
        detailsShow(id);
    });
    $('#modal-search').click(function () {
        searchShow();
    });

    $('#modal-confirm-button').val(type);

    if ($("#" + formid).hasClass('hidden'))
        switchFormToForm();

    switch (type) {
        case 'details':
            $('#modal-title').text('Detalles de ' + title);
            $('#modal-dismiss-button').text('Salir');
            $('#modal-confirm-button').addClass('hidden');
            $('#modal-add').addClass('hidden');
            $('#modal-undo').addClass('hidden');
            disableForm();
            break;
        case 'add':
            $('#modal-title').text('Agregar ' + title);
            $('#modal-confirm-button').text('Agregar ' + title);
            $('#modal-dismiss-button').text('Cancelar');
            $('#modal-edit').addClass('hidden');
            $('#modal-add').addClass('hidden');
            $('#modal-delete').addClass('hidden');
            $('#modal-search').addClass('hidden');
            $('#modal-undo').addClass('hidden');
            enableForm();
//            $('#modal-confirm-button').click(function () {
//                submitForm('add');
//            });
            break;
        case 'modify':
            $('#modal-title').text('Modificar ' + title);
            $('#modal-confirm-button').text('Modificar ' + title);
            $('#modal-dismiss-button').text('Cancelar');
            $('#modal-edit').addClass('hidden');
            $('#modal-add').addClass('hidden');

            enableForm();

            $('[data-id="true"]').prop("disabled", true);
            $('[data-pass="true"]').prop("disabled", true);

//            $('#modal-confirm-button').click(function () {
//                submitForm('modify');
//            });
            break;
        case 'search':
            $('#modal-title').text('Consultar ' + title);
            $('#modal-search-confirm-button').text('Consultar ' + title);
            $('#modal-search-dismiss-button').text('Cancelar');
            $('#modal-edit').addClass('hidden');
            $('#modal-search').addClass('hidden');
            $('#modal-add').addClass('hidden');
            $('#modal-delete').addClass('hidden');
            $('#modal-undo').addClass('hidden');
//            $('#modal-confirm-button').click(function () {
//                submitForm('search');
//            });
            enableForm();
            switchFormToSearch();

            break;
    }
}

function showModal() {
    $('#' + modalid).modal('show');
    $('#' + modalid).modal('handleUpdate');
}

function hideForm() {
    $('#' + modalid).modal('hide');
}

function switchFormToSearch() {
    $("#" + formid).addClass('hidden');
    $("#" + searchFormid).removeClass('hidden');
}

function switchFormToForm() {
    $("#" + formid).removeClass('hidden');
    $("#" + searchFormid).addClass('hidden');
}

function disableForm() {
    $("#" + formContainer + " :input").prop("disabled", true);
    $("#" + formContainer + " .dropify-wrapper").addClass('hidden');
    $("#" + formContainer + " .dropify-display").removeClass('hidden');
}

function enableForm() {
    $("#" + formContainer + " :input").prop("disabled", false);
    $("#" + formContainer + " .dropify-wrapper").removeClass('hidden');
    $("#" + formContainer + " .dropify-display").addClass('hidden');
}

function cleanForm() {
    $("#" + formContainer + " :input").val("");
    $("#" + formContainer + " :checkbox").prop('checked', false);
    $("#" + formContainer + " :radio").prop('checked', false);
    $("#" + formContainer + " .selectpicker").selectpicker('val', '');
    $('.dropify-clear').click();
}

function submitForm(type) {

    var parameters = {};
    var method = "POST";
    var id = "";

    for (var i = 0; i < cols.length; i++) {

        if (cols[i].identifier == true)
            id = cols[i].data;

        switch (cols[i].type) {
            case 'textocorto':
            case 'textolargo':
            case 'password':
            case 'email':
            case 'contabilidad':
            case 'fecha':
            case 'fechahora':
            case 'color':
            case 'url':
                parameters[cols[i].data] = $('#' + cols[i].data).val();
                break;
            case 'foto':
                break;
            case 'archivo':
                break;
            case 'despunico':
            case 'despmultiple':
                parameters[cols[i].data] = $('select#' + cols[i].data).val();
                break;
            case 'checkbox':
                parameters[cols[i].data] = $('#' + cols[i].data).is(':checked');
                break;
            case 'radio':
                parameters[cols[i].data] = $('input[name=' + cols[i].data + ']:checked').attr('id');
                break;
            default:
                break;
        }
    }

    switch (type) {
        case 'add':
            parameters['op'] = 'create';
            break;
        case 'modify':
            parameters['op'] = 'update';
            break;
        case 'search':
            detailsShow($('#' + id + '-search').val());
            return;
            break;
    }

//    var check1 = $("#check1").is(':checked');
//    var check2 = $("#check2").is(':checked');
//    var check3 = $("#check3").is(':checked');
//    var checkArray = [].push(check1).push(check2).push(check3);



    $.ajax({
        data: parameters,
        url: entity + "S",
        type: "POST",
        async: false

    }).done(function (response) {
        console.log(response);
        switch (type) {
            case 'add':
                hideForm();
                refreshTable();
                break;
            case 'modify':
                hideForm();
                refreshTable();
                //detailsShow(id);
                break;
            default:
                alert('error');
                break;
        }


    }).fail(function () {
        alert("error");
    });
}

function openInNewTab(url) {
    var win = window.open(url, '_blank');
    win.focus();
}

function initializePlugins() {
    $('.maxlenght').maxlength({
        alwaysShow: true,
        warningClass: "badge mt-1 badge-success",
        limitReachedClass: "badge mt-1 badge-danger"
    });
    $('[data-toggle="popover"]').popover();
    $('[data-toggle="tooltip"]').tooltip();
    $('.btn').on('click', function (e) {
        $('.btn').not(this).popover('hide');
    });
    if ($("#datepicker-popup").length) {
        $('#datepicker-popup').datepicker({
            enableOnReadonly: true,
            todayHighlight: true,
        });
    }

    $('.material-timedate').bootstrapMaterialDatePicker({format: 'dddd[,] DD [de] MMMM [de] YYYY - hh:mm a', shortTime: true, lang: 'es', cancelText: 'Cancelar', clearText: 'Borrar', nowText: 'Ahora', nowButton: true});
    $('.material-date').bootstrapMaterialDatePicker({format: 'dddd[,] DD [de] MMMM [de] YYYY', lang: 'es', time: false, cancelText: 'Cancelar', clearText: 'Borrar', nowText: 'Ahora', nowButton: true});
    $('.selectpicker').selectpicker();
    $('.dropify').dropify({
        messages: {
            'default': 'Arrastra un archivo o haz clic aquí',
            'replace': 'Arrastra un archivo o haz clic aquí para reemplazar',
            'remove': 'Eliminar',
            'error': 'Ooops, algo salió mal.'
        }
    });
    if ($(".color-picker").length) {
        $('.color-picker').asColorPicker();
    }
}

