(function ($) {
    'use strict';
    var form = $("#register-form");
    form.children("div").steps({
        headerTag: "h3",
        bodyTag: "section",
        transitionEffect: "slideLeft",
        onFinished: function (event, currentIndex) {
            form.validate().settings.ignore = ':disabled';
            return form.valid();
        },
    });
    form.validate({
        errorPlacement: function errorPlacement(error, element) {
            element.before(error);
        },
        rules: {
            contra: {
                equalTo: "#contraver"
            },
            veremail: {
                required: true,
                email: true
            }
        }
    });
})(jQuery);


$('#cambiarColor').css('background-color', '#3373ff');
$('#cambiarColor2').css('background-color', '#31a8ce');

$('#colorpicker').on('asColorPicker::change', function (e) {
    var color = $('#colorpicker').asColorPicker('val');
    $('#cambiarColor').css('background-color', color);
});

$('#colorpicker2').on('asColorPicker::change', function (e) {
    var color = $('#colorpicker2').asColorPicker('val');
    $('#cambiarColor2').css('background-color', color);
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#imageprev').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#imgInp").change(function () {
    readURL(this);
});