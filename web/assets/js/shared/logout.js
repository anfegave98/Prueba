function logout() {
    var parametros = {
        "op": "out"
    };
    $.ajax({
        data: parametros,
        url: "Login",
        type: "POST",
        async: false

    }).done(function (response) {
        console.log(response);
        location.reload();

    }).fail(function () {
        alert("error");
    });
}