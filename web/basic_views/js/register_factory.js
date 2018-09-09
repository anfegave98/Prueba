$(document).ready(function () {
    getSectors();

});

function getSectors() {
    var area = document.getElementById("area").value;
    var indic = 1;
    /*var parametros = {
        "valor1": area
    };*/
    $.ajax({
        //data: parametros,
        url: "../ListarPorArea",
        type: "GET"

    }).done(function (response) {
        console.log(response);
       
    });
}