var asset;

function sendState() {
    var parametrosAssetAdd = {
        "op": "create",
        "asset_store_id": asset.asset_store_id,
        "admin_id":1,
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
            window.location.href = "State.jsp";
            

        } else {
            alert("Cliente no existe");
            return null;
        }

    }).fail(function () {
        alert("error");
    });
}

$('#findAsset').on('submit', function () {

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




