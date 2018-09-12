$(document).ready(function () {
    getSectors();
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
        if (response) {
            
            return true;

        } else {
            alert("Este email ya se ha registrado en nuestra base de datos");
        }

    }).fail(function () {
        alert("error");
    });
    
    $.ajax({
        data: parametrosAdminAdd,
        url: "AdminS",
        type: "POST",
        async:false

    }).done(function (response) {
        console.log(response);
        if (response) {
            return true;

        } else {
            alert("Este email ya se ha registrado en nuestra base de datos");
        }

    }).fail(function () {
        alert("error");
    });
    
    
}

function validateRegister() {
    var option = "create";
    var name = document.getElementById('name').value;
    var primary_color = document.getElementById('color_primary').value;
    var secondary_color = document.getElementById('color_secondary').value;
    //Theme selected
    var theme = document.querySelector('input[name="theme"]:checked').value;
    var basicColor = false;
    if (theme == 1) {
        basicColor = true;
    }
    //Sector value
    var e = document.getElementById("mySelect");
    var sector = e.options[e.selectedIndex].value;
    var logo = globalImageBase64;
    var email = document.getElementById('email').value;
    var pass1 = document.getElementById('pass_1').value;
    var pass2 = document.getElementById('pass_2').value;
    var lowerCaseLetters = /[a-z]/g;
    var upperCaseLetters = /[A-Z]/g;
    var numbers = /[0-9]/g;
    var emailValues = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if ((name != "") && (sector != 0) && (pass1 != "") && (pass2.value != "") && (email != "")) {
        if (pass1.match(lowerCaseLetters)) {
            if (pass1.match(upperCaseLetters)) {
                if (pass1.match(numbers)) {
                    if (pass1.length >= 8) {
                        if (email.match(emailValues)) {
                            if (pass1 == pass2) {
                                var parametros = {
                                    "op": option,
                                    "name": name,
                                    "primary_color": primary_color,
                                    "accent_color": secondary_color,
                                    "sector_id": sector,
                                    "logo": "gg",
                                    "email": email,
                                    "password": pass2,
                                    "basic_color": basicColor
                                };
                                $.ajax({
                                    data: parametros,
                                    url: "../../CompanyS",
                                    type: "POST"

                                }).done(function (response) {
                                    console.log(response);
                                    if (response) {
                                        return true;

                                    } else {
                                        alert("Este email ya se ha registrado en nuestra base de datos");
                                    }

                                }).fail(function () {
                                    alert("error");
                                });

                            } else {
                                alert("Las claves no coinciden");
                            }
                        } else {
                            alert("Ingrese un correo electrónico válido");
                        }
                    } else {
                        alert("La clave debe tener mínimo 8 carácteres");
                    }
                } else {
                    alert("La clave debe contener al menos un número");
                }
            } else {
                alert("La clave debe contener al menos una letra mayúscula");
            }
        } else {
            alert("La clave debe contener al menos una letra minúscula");
        }
    } else {
        alert("Debe llenar los campos solicitados para poder continuar");
    }
    return false;
}