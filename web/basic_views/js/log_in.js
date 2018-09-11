/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateLogIn() {
    var data = "getAll";
    var parametros = {
        "op": data
    };
    $.ajax({
        data: parametros,
        url: "../../SectorS",
        type: "GET"

    }).done(function (response) {
        //console.log(response);
        var a = JSON.parse(response);
        $.each(a, function (i, item) {
            $('#mySelect').append($('<option>', {
                value: item.sector_id,
                text: item.name
            }));
            i++;
        });

    });
}