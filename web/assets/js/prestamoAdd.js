$(document).ready(function () {

    var item = {
        asset_store_id: 1,
        lend_quantity: 1,
        name: "",
        codebar: "",
        description: "",
        available: 5
    }
    addItem(item);

    var item2 = {
        asset_store_id: 2,
        lend_quantity: 2,
        name: "",
        codebar: "",
        description: "",
        available: 5
    }
    addItem(item2);


});
var items = [];

function addById(asset_id) {
    
    var par = {
        "op": "getById",
        "asset_id": asset_id
    };
    
    $.ajax({
        data: par,
        url: "Asset_storeS",
        type: "GET",
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



function addItem(item) {
    items.push(item);
}

function addQuantity(asset_store_id) {
    for (i = 0; i < items.length; i++) {
        if (items[i].asset_store_id == asset_store_id) {
            if (items[i].lend_quantity == items[i].available)
                alert('no se puede mas')
            else
                items[i].lend_quantity++;
        }
    }
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
}



$('#prestamoAdd').on('submit', function () {
    submitForm();
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