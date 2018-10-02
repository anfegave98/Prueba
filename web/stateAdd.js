var asset;

function sendState() {
    var parametrosAssetAdd = {
        "op": "create",
        "asset_store_id": asset.asset_store_id,
        "admin_id": 1,
        "quantity": $('#cantidad').val(),
        "description": $('#descripcion').val()
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


