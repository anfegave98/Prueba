$(document).ready(function () {
    table = $('#admin_table').DataTable({
        ajax: {
            url: "AdminS",
            type: "GET",
            dataSrc: '',
            data: {
                'op': "getall"
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
                defaultContent: '<a style="cursor: pointer; "><i class="menu-icon mdi mdi-lightbulb-outline"></i>></a>'
            }
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });

    $('#admin_table tbody').on('click', 'button', function () {
        var data = table.row($(this).parents('tr')).data();
        abrir(data.id_demanda);
    });

});

function abrir(id_demanda) {
    localStorage.setItem("id_demanda",id_demanda);
    document.location.href='redaccion_editar';
}