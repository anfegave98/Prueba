$(document).ready(function () {
    table = $('#tabletop5').DataTable({
        ajax: {
            url: "Lend_itemsS",
            type: "GET",
            dataSrc: '',
            data: {
                'op': "report",
                'store_id': 1
            }
        },
        columns: [
            {data: 'codebar'},
            {data: 'name'},
            {data: 'borrowed_times'}
        ],
        columnDefs: [
            {
                targets: -1,
                data: null,
                defaultContent: '<a style="cursor: pointer; "><i class="menu-icon mdi mdi-lightbulb-outline"></i>></a>'
            }
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true

    });


    table = $('#tablaactivos').DataTable({
        ajax: {
            url: "LendS",
            type: "GET",
            dataSrc: '',
            data: {
                'op': "active"
            }
        },
        columns: [
            {data: 'name'},
            {data: 'last_name'},
            {data: 'start_date'},
            {data: 'cuenta'}
        ],
        columnDefs: [
            {
                targets: -1,
                data: null,
                defaultContent: '<a style="cursor: pointer; "><i class="menu-icon mdi mdi-lightbulb-outline"></i>></a>'
            }
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });
     $.ajax({
        type: 'GET',
        url: "LendS",        
        data: {
            'op': "count_report"
        },
        dataType: "text",
        success: function (data) {
            $('#cantidad').append(data);
        },
        async: false
    });

});