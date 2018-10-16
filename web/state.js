var table;
$(document).ready(function () {
    table = $('#state_table').DataTable({
        ajax: {
            url: "State_assetS",
            type: "GET",
            dataSrc: '',
            data: {
                'op': "activeNormal",
                'store_id':1
            }
        },
        columns: [
            {data: 'state_asset_id'},
            {data: 'admin_id'},
            {data: 'description'},
            {data: 'creation_date'},
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
        order: [[ 1, "desc" ]],
        initComplete: function (oSettings) {
            $('#loader').waitMe("hide");
        }
    });

    $('#state_table tbody').on('click', 'a', function () {
        var data = table.row($(this).parents('tr')).data();
        devolver(data.state_asset_id);
    });

});

function openAddState() {
    openURL('stateAdd');
}


function devolver(id) {
    var parametrosClientAdd = {
        "op": "removeAll",
        "state_asset_id": id
    };

    $.ajax({
        data: parametrosClientAdd,
        url: "State_assetS",
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