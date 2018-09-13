$(document).ready(function () {
    
});

$('#clientAdd').on('submit', function () {
    submitForm();
});

function submitForm() {
    // PAGINA 3
    var clientName = document.getElementById('clientName').value;
    var last_name = document.getElementById('last_name').value;
    var clientEmail = document.getElementById('clientEmail').value;
    var password = document.getElementById('pass2').value;

    var parametrosClientAdd = {
        "op": "create",
        "name": clientName,
        "last_name": last_name,
        "email": clientEmail,
        "password": password
    };

    $.ajax({
        data: parametrosClientAdd,
        url: "ClientS",
        type: "POST",
        async: false

    }).done(function (response) {
        console.log(response);
        if (response) {
            console.log(true);
        } else {
            alert("Este email ya se ha registrado en nuestra base de datos");
        }

    }).fail(function () {
        alert("error");
    });

}