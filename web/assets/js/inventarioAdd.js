$(document).ready(function () {
    
});

$('#assetAdd').on('submit', function () {
    submitForm();
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
        if (response) {
            console.log(true);
        } else {
            alert("Asset ya existe");
        }

    }).fail(function () {
        alert("error");
    });

}