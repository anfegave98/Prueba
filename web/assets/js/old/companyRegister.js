$(document).ready(function () {
    getSectors();
});

var form = $('#register-form').show();
form.steps({
    headerTag: "h3",
    bodyTag: "section",
    transitionEffect: "slideLeft",
    labels:
            {
                current: "Página actual:",
                pagination: "Paginación",
                finish: "Comenzar",
                next: "Siguiente",
                previous: "Anterior",
                loading: "Cargando ..."
            },
    onInit: function (event, currentIndex) {

        //Set tab width
        var $tab = $(event.currentTarget).find('ul[role="tablist"] li');
        var tabCount = $tab.length;
        $tab.css('width', (100 / tabCount) + '%');
    },
    onStepChanging: function (event, currentIndex, newIndex) {
        if (currentIndex > newIndex) {
            return true;
        }

        if (currentIndex < newIndex) {
            //form.find('.body:eq(' + newIndex + ') label.error').remove();
            //form.find('.body:eq(' + newIndex + ') .error').removeClass('error');
        }

        //form.validate().settings.ignore = ':disabled,:hidden';
        //return form.valid();
        return true;
    },
    onFinishing: function (event, currentIndex) {
        //form.validate().settings.ignore = ':disabled';
        //return form.valid();
        var exito = submitForm();
        if (exito) {
            window.location.href = "login.jsp";
            return true;
        } else {
            console.log('error detectado');
            return false;
        }
    }
});

$.validator.setDefaults({
    submitHandler: function (form, event) {

        // Ajax code for submission
        var form = $(form);
        event.preventDefault();
        $.ajax({
            type: form.attr('method'),
            data: form.serialize(),
            url: form.attr('action'),
            success: function (data) {
                //success message
            },
            error: function (data) {
                //error message
            }
        });
    }
});

$("#register-form").validate({
    rules: {
        address: "required"
    },
    messages: {
        address: "mensaje para nombre sede"
    },
    errorPlacement: function (label, element) {
        label.addClass('mt-2 text-danger');
        label.insertAfter(element);
    },
    highlight: function (element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
    }
});


$('#colorbar').css('background', '#128bfc');
$('#colorlink').css('color', '#128bfc');
$('#colorbutton').css('background-color', '#15b67d');


nombre_update

$('#primary_color').on('asColorPicker::change', function (e) {
    var color = $('#primary_color').asColorPicker('val');
    $('#colorbar').css('background', color);
    $('#colorlink').css('color', color);
});

$('#secondary_color').on('asColorPicker::change', function (e) {
    var color = $('#secondary_color').asColorPicker('val');
    $('#colorbutton').css('background-color', color);
    $('#colorbutton').css('border-color', color);
});

function getSectors() {
    var parametros = {
        "op": "getAll"
    };

    $.ajax({
        data: parametros,
        url: "SectorS",
        type: "GET",
        success: function (data) {

            sectors = $.parseJSON(data);

            $('select#sectors').children().remove();
            $('select#sectors').append("<option value=\"\"> </option>");
            $.each(sectors, function (i, item) {
                $('select#sectors')
                        .append($("<option></option>")
                                .attr("value", item.sector_id)
                                .text(item.name));
            });
            $('select#sectors').selectpicker('refresh');

            $('select#sectors').val(7);
            $('select#sectors').selectpicker('refresh')

        }

    })
}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#logoprev').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#logo").change(function () {
    readURL(this);
});

//background constants
var navbar_classes = "navbar-danger navbar-success navbar-warning navbar-dark navbar-light navbar-primary navbar-info navbar-pink";
var sidebar_classes = "sidebar-light sidebar-dark";
var $body = $("body");

$('input[type=radio][name=basic_color]').change(function () {
    if (this.value == 'light') {
        setLight();
    } else if (this.value == 'dark') {
        setDark();
    }
});

function setLight() {
    //$("#light-theme").on("click", function() {
    $body.removeClass(sidebar_classes);
    $body.addClass("sidebar-light");
    $(".sidebar-bg-options").removeClass("selected");
    $(this).addClass("selected");
    $('#background-prev').css('background-color', "#e6e6e6");
    //});
}
//sidebar backgrounds
function setDark() {
    //$("#sidebar-dark-theme").on("click", function() {
    $body.removeClass(sidebar_classes);
    $body.addClass("sidebar-dark");
    $(".sidebar-bg-options").removeClass("selected");
    $(this).addClass("selected");
    $('#background-prev').css('background-color', "#3a3f50");
    //});

}

function submitForm() {

    // PAGINA 1
    var name = document.getElementById('name').value;
    var primary_color = $('#primary_color').asColorPicker('val');
    var secondary_color = $('#secondary_color').asColorPicker('val');
    // Theme selected
    var theme = document.querySelector('input[name="basic_color"]:checked').value;
    var basicColor = false;
    if (theme == 'dark') {
        basicColor = true;
    }
    var sector = $('select#sectors').val();

    // presenta error
    //var logo = globalImageBase64;

    // PAGINA 2
    var nameSede = $('#sedeName').val();
    var address = $('#address').val();
    var phone_1 = $('#phone_1').val();
    var phone_2 = $('#phone_2').val();
    var emailAtention = $('#emailAtencion').val();

    // PAGINA 3
    var adminName = document.getElementById('adminName').value;
    var last_name = document.getElementById('last_name').value;
    var adminEmail = document.getElementById('adminEmail').value;
    var password = document.getElementById('pass2').value;


    // crear company
    var parametrosCompany = {
        "op": "create",
        "name": name,
        "primary_color": primary_color,
        "accent_color": secondary_color,
        "sector_id": sector,
        "logo": "gg",
        "email": adminEmail,
        "password": password,
        "basic_color": basicColor
    };
    
    var parametrosStoreAdd = {
        "op": "create",
        "company": 1,
        "name": nameSede,
        "address": address,
        "phone_1": phone_1,
        "phone_2": phone_2,
        "email": emailAtention
    };

    var parametrosAdminAdd = {
        "op": "create",
        "name": adminName,
        "last_name": last_name,
        "email": adminEmail,
        "password": password
    };

    var exito = false;

    $.ajax({
        data: parametrosCompany,
        url: "CompanyS",
        type: "POST",
        async: false

    }).done(function (response) {
        console.log(response);
        if (response == 'true') {


            $.ajax({
                data: parametrosStoreAdd,
                url: "StoreS",
                type: "POST",
                async: false

            }).done(function (response2) {
                console.log(response2);
                if (response2 == 'true') {

                    $.ajax({
                        data: parametrosAdminAdd,
                        url: "AdminS",
                        type: "POST",
                        async: false

                    }).done(function (response3) {
                        console.log(response3);
                        if (response3 == 'true') {

                            exito = true;

                        } else {
                            alert("Este email ya se ha registrado en nuestra base de datos");
                        }

                    }).fail(function () {
                        alert("error");
                    });

                } else {
                    alert("Este email ya se ha registrado en nuestra base de datos");
                }

            }).fail(function () {
                alert("error");
            });

        } else {
            alert("Este email ya se ha registrado en nuestra base de datos");
        }

    }).fail(function () {
        alert("error");
    });

    return exito;
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