var table;
var items = [];
var client;

$(document).ready(function () {

    table = $('#items_table').DataTable({
        data: items,
        columns: [
            {data: 'codebar'},
            {data: 'name'},
            {data: 'description'},
            {data: null, render: function (data, type, row) {
                    // Combine the first and last names into a single table field
                    var d=data.available-data.no_available;
                    return data.lend_quantity + '/' + d;
                }},
            {data: null}
        ],
        columnDefs: [
            {
                targets: -1,
                data: null,
                defaultContent: '<a class="plus" style="cursor: pointer; "><i class="menu-icon mdi mdi-plus-circle"></i></a><a class="less" style="cursor: pointer; "><i class="menu-icon mdi mdi-minus-circle"></i></a>'
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

    $('#items_table tbody').on('click', 'a.less', function () {
        var data = table.row($(this).parents('tr')).data();
        reduceQuantity(data.asset_store_id);
    });
    
     $('#items_table tbody').on('click', 'a.plus', function () {
        var data = table.row($(this).parents('tr')).data();
        addQuantity(data.asset_store_id);
    });
    
    $('#end_date').bootstrapMaterialDatePicker({format: 'DD/MM/YYYY', lang: 'es', time: false, cancelText: 'Cancelar', clearText: 'Borrar', nowText: 'Ahora', nowButton: true});

});


function sendLend() {
    
    debugger;
    
    var parametrosAssetAdd = {
        "op": "create",
        "admin_role_store_id": 1,
        "client_id": client.client_id,
        "lend_items": JSON.stringify(items),
        "end_date": $('#end_date').val()
    };

    $.ajax({
        data: parametrosAssetAdd,
        url: "LendS",
        type: "POST"

    }).done(function (response) {
        console.log(response);
        if (response == 'true') {
            console.log(true);
            openURL('lends');
            

        } else {
            alert("Error de envio");
            return null;
        }

    }).fail(function () {
        alert("error");
    });
}


function addById(asset_id) {

    var exists = false;


    for (i = 0; i < items.length; i++) {
        if (items[i].asset_store_id == asset_id) {
            exists = true;
        }
    }

    if (exists) {
        addQuantity(asset_id);
    } else {

        var par = {
            "op": "getByCodebar",
            "codebar": asset_id
        };

        $.ajax({
            data: par,
            url: "Asset_storeS",
            type: "GET",
            async: false

        }).done(function (response) {
            console.log(response);
            var res = JSON.parse(response);
            if (res.name != undefined) {
                console.log(true);
                res.lend_quantity = 1;
                items.push(res);
                updateTable();
            } else {
                alert("Asset no existe");
            }

        }).fail(function () {
            alert("error");
        });
    }
}

function updateTable() {
    table.clear();
    table.rows.add(items);
    table.draw();
}

function addQuantity(asset_store_id) {
    for (i = 0; i < items.length; i++) {
        if (items[i].asset_store_id == asset_store_id) {
            if (items[i].lend_quantity == items[i].available-items[i].no_available)
                alert('no se puede mas')
            else
                items[i].lend_quantity++;
        }
    }
    updateTable();
}

function reduceQuantity(asset_store_id) {
    for (i = 0; i < items.length; i++) {
        if (items[i].asset_store_id == asset_store_id) {
            if (items[i].lend_quantity == 1) {
                items.splice(i, 1);
            } else
                items[i].lend_quantity--;
        }
    }
    updateTable();
}



$('#findClient').on('submit', function () {

    var parametrosAssetAdd = {
        "op": "get",
        "pk": $('#client_email').val()
    };

    $.ajax({
        data: parametrosAssetAdd,
        url: "ClientS",
        type: "GET",
        async: false

    }).done(function (response) {
        console.log(response);
        client = JSON.parse(response);
        if (client.name != undefined) {
            console.log(true);

            $('#client_name_show').text(client.name);
            $('#client_last_name_show').text(client.last_name);
            $('#client_email_show').text(client.email);

        } else {
            alert("Cliente no existe");
            return null;
        }

    }).fail(function () {
        alert("error");
    });




    return false;
});

$('#assetAdd').on('submit', function () {
    addById($('#asset_id').val());


    return false;
});

function submitForm() {
    // PAGINA 3
    var assetName = document.getElementById('assetName').value;
    var bar_code = document.getElementById('bar_code').value;
    var asset_description = document.getElementById('asset_description').value;
    var units = document.getElementById('units').value;

    var parametrosAssetAdd = {
        "op": "create",
        "name": assetName,
        "codebar": bar_code,
        "principal_picture": "GGSGGSGSGS",
        "description": asset_description,
        "available": units,
        "store_id": 1,
        "asset_parent_id": ""
    };

    $.ajax({
        data: parametrosAssetAdd,
        url: "AssetS",
        type: "POST",
        async: false

    }).done(function (response) {
        console.log(response);
        if (response == 'true') {
            console.log(true);
            window.location.href = "inventario.jsp";
        } else {
            alert("Asset ya existe");
        }

    }).fail(function () {
        alert("error");
    });

}

