$(document).ready(function () {

    var cols = [
        {title: 'Texto Corto', data: 'textocorto', required: pk, },
        {title: 'Texto Largo', data: 'textolargo'},
        {title: 'Número Entero', data: 'entero'},
        {title: 'Número Decimal', data: 'decimal'},
        {title: 'Si / No', data: 'booleano'},
        {title: 'Fecha', data: 'fecha'},
        {title: 'Fecha y hora', data: 'fechahora'},
        {title: 'Contabilidad', data: 'contabilidad'},
        {title: 'Color', data: 'color'},
        {title: 'Desplegable op. única', data: 'despunico'},
        {title: 'Desplegable op. múltiple', data: 'despmultiple'},
        {title: 'Opción única', data: 'opunica'},
        {title: 'Opción múltiple', data: 'opmultiple'},
        {title: 'Foto', data: 'foto'},
        {title: 'Archivo', data: 'archivo'},
        {title: "Actions", data: null}];

    var data = [{
            'textocorto': 'Item 1',
            'textolargo': 'Descripción larga del item 1',
            'entero': '15',
            'decimal': '52,465789',
            'booleano': true,
            'fecha': '2018-09-19',
            'fechahora': '2018-09-19 15:00:00',
            'contabilidad': '25,63',
            'color': '#15b67d',
            'despunico': '2',
            'despmultiple': '3',
            'opunica': '1',
            'opmultiple': '3',
            'foto': './assets/images/product_images/apple-watch.jpg',
            'archivo': './assets/files/testfile.pdf'

        },
        {

            'textocorto': 'Item 2',
            'textolargo': 'Descripción larga del item 2 es mucho pero muchísimo más larga que la anterior',
            'entero': '-531',
            'decimal': '17,465789',
            'booleano': false,
            'fecha': '2018-01-19',
            'fechahora': '2018-09-19 14:00:00',
            'contabilidad': '-50',
            'color': '#15b67d',
            'despunico': '1',
            'despmultiple': '2',
            'opunica': '0',
            'opmultiple': '2',
            'foto': 'https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjarNab1sfdAhUIiFQKHb5cDVoQjRx6BAgBEAU&url=https%3A%2F%2Fwww.youtube.com%2FGoogle&psig=AOvVaw3XXgnOwHDHZ8eU-D-UKvkb&ust=1537467315400289https://www.google.com/images/branding/googlelogo/2x/googlelogo_colorhttps://www.google.com/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png',
            'archivo': 'https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwja'

        },
        {
            'textocorto': 'Item 3',
            'textolargo': 'Descripción larga del item 3 es mucho pero muchísimo más larga que la anterior  muchísimo más larga que la anterior',
            'entero': '9816351',
            'decimal': '15,18978545',
            'booleano': true,
            'fecha': '2018-01-01',
            'fechahora': '2018-09-19 01:00:00',
            'contabilidad': '652,326',
            'color': '#15b67d',
            'despunico': '2',
            'despmultiple': '1',
            'opunica': '1',
            'opmultiple': '1',
            'foto': 'https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjarNab1sfdAhUIiFQKHb5cDVoQjRx6BAgBEAU&url=https%3A%2F%2Fwww.youtube.com%2FGoogle&psig=AOvVaw3XXgnOwHDHZ8eU-D-UKvkb&ust=1537467315400289https://www.google.com/images/branding/googlelogo/2x/googlelogo_colorhttps://www.google.com/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png',
            'archivo': 'https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwja'

        }];
    var buttonDetails = '<button type="button" class="btn btn-info btn-fw ml-2"><i class="mdi mdi-magnify"></i>Details</button>';
    var buttonDelete = '<button type="button" class="btn btn-danger btn-fw ml-2"><i class="mdi mdi-delete"></i>Delete</button>';

    var actions = buttonDetails + buttonDelete;
    table = $('#id_de_tabla').DataTable({
        /*
         ajax: {
         url: "Lend_itemsS",
         type: "GET",
         dataSrc: '',
         data: {
         'op': "report",
         'store_id': 1
         }
         },
         */
        data: data,
        columns: cols,
        autoWidth: true,
        scrollY: "300px",
        scrollX: true,
        scrollCollapse: true,
        lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "Todos"]],
        columnDefs: [
            {targets: -1, data: null, width: "100px", defaultContent: actions},
            {targets: 1, render: $.fn.dataTable.render.ellipsis(20)},
            {targets: 7, render: $.fn.dataTable.render.moneda('$')},
            {targets: 8, render: $.fn.dataTable.render.color()},
            {targets: 13, render: $.fn.dataTable.render.photo()},
            {targets: 14, render: $.fn.dataTable.render.file()},
            {targets: 5, render: $.fn.dataTable.render.moment('YYYY-MM-DD', 'DD/MM/YYYY')},
            {targets: 6, render: $.fn.dataTable.render.moment('YYYY-MM-DD HH:mm:ss', 'DD/MM/YYYY hh:mm:ss a', 'es')},
            {targets: 4, render: $.fn.dataTable.render.casilla('test')},
            {targets: 9, render: $.fn.dataTable.render.renderespecial()}

        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        fnDrawCallback: function (oSettings) {
            $(".ellipsis").tooltip();
            const datatableScroll = new PerfectScrollbar('.dataTables_scrollBody');
        }

    });

    $('.maxlenght').maxlength({
        alwaysShow: true,
        warningClass: "badge mt-1 badge-success",
        limitReachedClass: "badge mt-1 badge-danger"
    });

    addShow();
    $('[data-toggle="popover"]').popover();

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

    var modalScroll = new PerfectScrollbar('.modal');

});

$('body').on('click', function (e) {
    $('[data-toggle=popover]').each(function () {
        // hide any open popovers when the anywhere else in the body is clicked
        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
            $(this).popover('hide');
        }
    });
});

$.fn.dataTable.render.moneda = function (sign) {
    return function (data, type, row) {
        return (parseFloat(data) > 0) ? (sign + ' ' + data) : ('-(' + sign + ' ' + -1 * data + ')');
    };
};

$.fn.dataTable.render.casilla = function (sign) {
    return function (data, type, row) {
        return data ? '<input type="checkbox" disabled checked/>' : '<input type="checkbox" disabled/>'
    };
};

$.fn.dataTable.render.photo = function (sign) {
    return function (data, type, row) {
        return '<button onclick="openInNewTab(\'' + data + '\');" type="button" class="btn btn-warning btn-fw ml-2"><i class="mdi mdi-fullscreen"></i>Ver Imagen</button>'
    };
};

$.fn.dataTable.render.file = function (sign) {
    return function (data, type, row) {
        return '<button onclick="openInNewTab(\'' + data + '\');" type="button" class="btn btn-success btn-fw ml-2"><i class="mdi mdi-cloud-download"></i>Descargar</button>'
    };
};

$.fn.dataTable.render.color = function (sign) {
    return function (data, type, row) {
        return '<div style="background-color:' + data + ', border-color:#fff" class="badge badge-danger">' + data + '</div>'
    };
};

$.fn.dataTable.render.renderespecial = function () {
    return function (data, type, row) {
        return 'test ' + data + ' %'
    };
};

function openInNewTab(url) {
    var win = window.open(url, '_blank');
    win.focus();
}

function addShow() {
    enableForm('entityForm');
    cleanForm('entityForm');
    $('#viewEditModal').modal('show');
    $('#viewEditModal').modal('handleUpdate')
}

function editShow(id_edit) {
    enableForm('entityForm');
    cleanForm('entityForm');
    prefillForm(id_edit);
    $('#viewEditModal').modal('show');
    $('#viewEditModal').modal('handleUpdate')
}

function editShow(id_edit) {
    enableForm('entityForm');
    cleanForm('entityForm');
    prefillForm(id_edit);
    $('#viewEditModal').modal('show');
    $('#viewEditModal').modal('handleUpdate')
}

function preFill(id) {
    $.ajax({
        url: "ObjectS",
        type: 'GET',
        dataType: "text",
        data: {
            'action': "get",
            'pk': dateS
        },
        success: function (data) {

            eventos = $.parseJSON(data);
            console.log(eventos);
            // limpiar horario
            wipeEvents();

            var prevDate;
            var cardcontainer = $('#events-container-list');
            // ubicar eventos            
            for (var i = 0; i < eventos.length; ++i) {
                var currentDate = new Date(eventos[i].fecha_ini);

                if (prevDate == null || !(prevDate.getFullYear() == currentDate.getFullYear() &&
                        prevDate.getMonth() == currentDate.getMonth() &&
                        prevDate.getDay() == currentDate.getDay()))
                {
                    var text;
                    // Si es hoy
                    if ((today.getFullYear() == currentDate.getFullYear() &&
                            today.getMonth() == currentDate.getMonth() &&
                            today.getDay() == currentDate.getDay())) {
                        text = "Hoy";
                    } else if ((today.getFullYear() == currentDate.getFullYear() &&
                            today.getMonth() == currentDate.getMonth() &&
                            today.getDay() == currentDate.getDay() - 1)) {
                        text = "Mañana";
                    } else {
                        text = formatDateShort(currentDate);
                    }
                    prevDate = currentDate;
                    cardcontainer.append("<h3 style=\"color: #b7b7b7;\">" + text + "</h3>");
                }

                drawEvent(i);
            }



            $('#events-container').waitMe("hide");
            $('#date-loader').waitMe("hide");

        }
    });
}


function disableForm(formid) {
    $("#" + formid + " :input").prop("disabled", true);
    $("#" + formid + " .dropify-wrapper").addClass('hidden');
    $("#" + formid + " .dropify-display").removeClass('hidden');

}

function enableForm(formid) {
    $("#" + formid + " :input").prop("disabled", false);
    $("#" + formid + " .dropify-wrapper").removeClass('hidden');
    $("#" + formid + " .dropify-display").addClass('hidden');
}

function cleanForm(formid) {
    $("#" + formid + " :input").val("");
    $("#" + formid + " :checkbox").prop('checked', false);
    $("#" + formid + " :radio").prop('checked', false);
    $("#" + formid + " .selectpicker").selectpicker('val', '');
    $('.dropify-clear').click();
}


function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#logoprev').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#logo").change(function () {
    readURL(this);
});



function getDataModal(){
    var textocorto = $('#textocorto').val();
    var textolargo = $('#textolargo').val();
    var numeroentero = $('#numeroentero').val();
    var numerodecimal = $('#numerodecimal').val();
    var bool = $('input[type=checkbox][id=bool]:checked').val();
    var fecha = $('#fecha').val();
    var fechahora = $('#fechahora').val();
    var contabilidad = $('#contabilidad').val();
    var despunico = $('select#despunico').val();
    var despmultiple = $('select#despmultiple').val();    
    var boolean = false;
    if(bool=='on'){
        boolean = true;        
    }
    var radioValue = $('input[name=r1]:checked').val();
    
    var check1 = $('input[type=checkbox][id=check1]:checked').val();
    var check2 = $('input[type=checkbox][id=check2]:checked').val();
    var check3 = $('input[type=checkbox][id=check3]:checked').val();
    
    
    
    
    
    
    
    

}
