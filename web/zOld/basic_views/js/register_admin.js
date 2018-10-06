function validateAdmin() {
    var name_admin = document.getElementById("name_admin").value;
    var surname_addmin = document.getElementById("surname_addmin").value;
    var email_admin = document.getElementById("email_admin").value;
    var pass_admin = document.getElementById("pass_admin").value;
    var pass_2_admin = document.getElementById("pass_2_admin").value;
    var lowerCaseLetters = /[a-z]/g;
    var upperCaseLetters = /[A-Z]/g;
    var numbers = /[0-9]/g;
    var emailValues = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if ((name_admin != "") && (surname_addmin != "") && (email_admin != "") && (pass_admin != "") && (pass_2_admin != "")) {
        if (pass_admin.match(lowerCaseLetters)) {
            if (pass_admin.match(upperCaseLetters)) {
                if (pass_admin.match(numbers)) {
                    if (pass_admin.length >= 8) {
                        if (email_admin.match(emailValues)) {
                            if (pass_admin == pass_2_admin) {
                                var parametros = {
                                    "op": "create",
                                    "name": name_admin,
                                    "password": pass_admin,
                                    "last_name": surname_addmin,
                                    "email": email_admin
                                }
                                $.ajax({
                                    data: parametros,
                                    url: "../../ClientS",
                                    type: "POST"

                                }).done(function (response) {
                                    console.log(response);
                                    if (response) {
                                        window.location.href = "../html/success_register.html"
                                    } else {
                                        alert("Está email ya se ha registrado");
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
        alert("Debe llenar los campos obligatorios para poder continuar");
    }

}


