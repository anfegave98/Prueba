var asset;
var items = [];
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
                    return data.quantity + '/' + d;
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
    
});
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
                res.quantity = 1;
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
            if (items[i].quantity == items[i].available-items[i].no_available)
                alert('no se puede mas')
            else
                items[i].quantity++;
        }
    }
    updateTable();
}

function reduceQuantity(asset_store_id) {
    for (i = 0; i < items.length; i++) {
        if (items[i].asset_store_id == asset_store_id) {
            if (items[i].quantity == 1) {
                items.splice(i, 1);
            } else
                items[i].quantity--;
        }
    }
    updateTable();
}

$('#assetAdd').on('submit', function () {
    addById($('#asset_id').val());


    return false;
});

function sendState() {
    var parametrosAssetAdd = {
        "op": "create",
        "admin_id": 1,
        "state_items": JSON.stringify(items),
        "description": $('#description').val()
    };

    $.ajax({
        data: parametrosAssetAdd,
        url: "State_assetS",
        type: "POST"

    }).done(function (response) {
        console.log(response);
        if (response == 'true') {
            console.log(true);
            openURL('state');

        } else {
            alert("Cliente no existe");
            return null;
        }

    }).fail(function () {
        alert("error");
    });
}

$('#findAsset').on('submit', function () {
    $('#sub_div_asset').attr('style', 'display:none;');
    var parametrosAssetAdd = {
        "op": "getByCodebar",
        "codebar": $('#codebar').val()
    };

    $.ajax({
        data: parametrosAssetAdd,
        url: "Asset_storeS",
        type: "GET",
        async: false

    }).done(function (response) {
        console.log(response);
        asset = JSON.parse(response);
        if (asset.name != undefined) {
            console.log(true);

            $('#asset_name_show').text(asset.name);
            $('#asset_codebar_show').text(asset.codebar);
            $('#asset_description_show').text(asset.description);
            $('#asset_available_show').text(asset.available - asset.no_available);

        } else {
            alert("Asset no existe");
            return null;
        }

    }).fail(function () {
        alert("error");
    });




    return false;
});

function showDetails() {
    var parametrosAssetAdd = {
        "op": "showDetails",
        "asset_store_id": asset.asset_store_id
    };

    $.ajax({
        data: parametrosAssetAdd,
        url: "AssetS",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        var jason = $.parseJSON(response);
        $('#sub_div_asset').removeAttr('style');
        $('#asset_in_state_show').append(jason.store_id);
        $('#asset_in_lend_show').append(jason.asset_id);

    }).fail(function () {
        alert("error");
    });
}

$(document).ready(function () {
    dismissLoader();
});


