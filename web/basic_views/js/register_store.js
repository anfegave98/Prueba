
$(document).ready(function () {

});

function validateStore() {
    var name_store = document.getElementById("name_store").value;
    var address_store = document.getElementById("address_store").value;
    var phone_1_store = document.getElementById("phone_1_store").value;
    var phone_2_store = document.getElementById("phone_2_store").value;
    var email__store = document.getElementById("email__store").value;

    if ((name_store != "") && (address_store != "") && (phone_1_store != "")) {
            var parametros = {
                "op": "create",
                "name": name_store,
                "address": address_store,
                "phone_1": phone_1_store,
                "phone_2": phone_2_store,
                "email": email__store
            }
            $.ajax({
                data: parametros,
                url: "../../StoreS",
                type: "POST"

            }).done(function (response) {
                console.log(response); 
                if(response){
                    window.location.href = "../html/register_admin.html"
                }else{
                    alert("Está tienda ya se ha registrado");
                }              

            }).fail(function () {
                alert("error");
            });
    }else{
        alert("Debe llenar los campos obligatorios para poder continuar");
    }

}