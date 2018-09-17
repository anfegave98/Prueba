$(document).ready(function () {
    
});

$('#login-form').on('submit', function () {
    
    submitForm();
    return false;
});

function submitForm() {

    var user = $('#user').val();
    var pass = $('#pass').val();
    
     var parametros = {
        "op": "in",
        "company_id": 1,
        "email": user,
        "password": pass
    };
    
    $.ajax({
        data: parametros,
        url: "Login",
        type: "POST",
        async:false

    }).done(function (response) {
        console.log(response);
        switch (response) {
            case 'Company':
                console.log("ingresa company");
                window.location.href = "dashboard.jsp";
                break;
            case 'Admin':
                console.log("ingresa admin");
                window.location.href = "dashboard.jsp";
                break;
            case 'Client':
                console.log("ingresa client");
                window.location.href = "dashboard.jsp";
                break;
            default:
                alert("No se encuentra este usuario. Intente otra vez");
                break;
        }

    }).fail(function () {
        alert("error");
    });    
    
}
