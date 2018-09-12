$(document).ready(function () {

    // cuadrar altura de paneles laterales derechos
    //setSugeridosHeightAndScroll(true);
    //setAgendadosHeightAndScroll(true);


    //$('#demandas_tabla').DataTable();


    table = $('#admin_table').DataTable({
        ajax: {
            url: "AdminS",
            dataSrc: '',
            data: {
                'opcion': "getall"
            }
        },
        columns: [
            {data: 'admin_id'},
            {data: 'name'},
            {data: 'last_name'},
            {data: 'email'},
            {data: null}
        ],
        columnDefs: [
            {
                targets: -1,
                data: null,
                defaultContent: '<a style="cursor: pointer; "><i class="material-icons" style="font-size:21px">mode_edit</i></a>'
            }
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });

    $('#demandas tbody').on('click', 'button', function () {
        var data = table.row($(this).parents('tr')).data();
        abrir(data.id_demanda);
    });

});