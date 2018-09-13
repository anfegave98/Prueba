$(document).ready(function () {
    
});

$('#administradorAdd').on('submit', function () {
    submitForm();
    return false;
});

function submitForm() {
    // PAGINA 3
    var adminName = document.getElementById('adminName').value;
    var last_name = document.getElementById('last_name').value;
    var adminEmail = document.getElementById('adminEmail').value;
    var password = document.getElementById('pass2').value;

    var parametrosAdminAdd = {
        "op": "create",
        "name": adminName,
        "last_name": last_name,
        "email": adminEmail,
        "password": password
    };

    $.ajax({
        data: parametrosAdminAdd,
        url: "AdminS",
        type: "POST",
        async: false

    }).done(function (response) {
        console.log(response);
        if (response == 'true') {
            exito = true;
            window.location.href = "administradores.jsp";
        } else {
            alert("Este email ya se ha registrado en nuestra base de datos");
        }

    }).fail(function () {
        alert("error");
    });

}