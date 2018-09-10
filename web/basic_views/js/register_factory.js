var globalImageBase64 = "";

$(document).ready(function () {
    getSectors();
    document.getElementById("inp").addEventListener("change", readFile);
});

function getSectors() {
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


function readFile() {

    if (this.files && this.files[0]) {
        var FR = new FileReader();
        FR.addEventListener("load", function (e) {
            document.getElementById("img").src = e.target.result;
            globalImageBase64 = e.target.result;
            //console.log(e.target.result);
        });

        FR.readAsDataURL(this.files[0]);
    }

}


function createFactory(){
    var option = "create";
    var name = document.getElementById('name').value;
    var primary_color = document.getElementById('color_primary').value;
    var secondary_color = document.getElementById('color_secondary').value;
    //Theme selected
    var theme = document.querySelector('input[name="theme"]:checked').value;
    var basicColor = false;
    if(theme==1){
        basicColor = true;
    }
    //Sector value
    var e = document.getElementById("mySelect");
    var sector = e.options[e.selectedIndex].value;
    var logo = globalImageBase64;
    var email = document.getElementById('email').value;
    var pass = document.getElementById('pass_2').value;



    var parametros = {
        "op": option,
        "name": name,
        "primary_color": primary_color,
        "accent_color": secondary_color,
        "sector_id": sector,
        "logo": logo,
        "email": email,
        "password": pass,
        "basic_color": basicColor
    };
    $.ajax({
        data: parametros,
        url: "../../CompanyS",
        type: "POST"

    }).done(function (response) {
        console.log(response);
    }).fail(function(){
        alert("error");
    });

}

