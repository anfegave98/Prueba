var table;

$(document).ready(function () {
    table = $('#lend_table').DataTable({
        ajax: {
            url: "LendS",
            type: "GET",
            dataSrc: '',
            data: {
                'op': "activeNormal"
            }
        },
        columns: [
            {data: 'lend_id'},
            {data: 'client_id'},
            {data: 'start_date'},
            {data: 'end_date',
            defaultContent: "waiting"},
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

    $('#lend_table tbody').on('click', 'a', function () {
        var data = table.row($(this).parents('tr')).data();
        devolver(data.lend_id);
    });

});


function devolver(id) {
    var parametrosClientAdd = {
        "op": "devolution",
        "lend_id": id
    };

    $.ajax({
        data: parametrosClientAdd,
        url: "LendS",
        type: "POST"

    }).done(function (response) {
        console.log(response);
        if (response == 'true') {
            console.log(true);
            table.ajax.reload();
        } else {
            alert("No se devolvio");
        }

    }).fail(function () {
        alert("error");
    });
}