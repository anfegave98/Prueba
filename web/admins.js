$(document).ready(function () {

    var cols = [
        {title: 'Texto Corto', data: 'textocorto'},
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
        scrollY:        "300px",
        scrollX:        true,
        scrollCollapse: true,
        lengthMenu: [ [10, 25, 50, -1], [10, 25, 50, "Todos"] ],
        columnDefs: [
            {targets: -1, data: null, width: "100px", defaultContent: actions},
            {targets: 1, render: $.fn.dataTable.render.ellipsis(20)},
            {targets: 7, render: $.fn.dataTable.render.moneda('$')},
            {targets: 8, render: $.fn.dataTable.render.color()},
            {targets: 13, render: $.fn.dataTable.render.photo()},
            {targets: 14, render: $.fn.dataTable.render.file()},
            {targets: 5, render: $.fn.dataTable.render.moment('YYYY-MM-DD', 'DD/MM/YYYY')},
            {targets: 6, render: $.fn.dataTable.render.moment('YYYY-MM-DD HH:mm:ss', 'DD/MM/YYYY hh:mm:ss a', 'es')},
            {targets: 4, render: $.fn.dataTable.render.casilla('test')}
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        fnDrawCallback: function (oSettings) {
            $(".ellipsis").tooltip();
        }

    });
    
    var table = $('#example').DataTable( {
        scrollY:        "300px",
        scrollX:        true,
        scrollCollapse: true,
        paging:         false,
        fixedColumns:   {
            leftColumns: 1,
            rightColumns: 1
        }
    } );

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
        return '<button onclick="openInNewTab(\''+data+'\');" type="button" class="btn btn-warning btn-fw ml-2"><i class="mdi mdi-fullscreen"></i>Ver Imagen</button>'
    };
};

$.fn.dataTable.render.file = function (sign) {
    return function (data, type, row) {
        return '<button onclick="openInNewTab(\''+data+'\');" type="button" class="btn btn-success btn-fw ml-2"><i class="mdi mdi-cloud-download"></i>Descargar</button>'
    };
};

$.fn.dataTable.render.color = function (sign) {
    return function (data, type, row) {
        return '<div style="background-color:'+data+', border-color:#fff" class="badge badge-danger">'+data+'</div>'
    };
};

function openInNewTab(url) {
  var win = window.open(url, '_blank');
  win.focus();
}
