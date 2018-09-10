

function validateStore() {
    var name_admin = document.getElementById("name_admin").value;
    var surname_addmin = document.getElementById("surname_addmin").value;
    var email_admin = document.getElementById("email_admin").value;
    var pass_admin = document.getElementById("pass_admin").value;
    var pass_2_admin = document.getElementById("pass_2_admin").value;

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