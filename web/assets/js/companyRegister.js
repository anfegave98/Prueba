var form = $('#register-form').show();
form.steps({
    headerTag: "h3",
    bodyTag: "section",
    transitionEffect: "slideLeft",
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

        form.validate().settings.ignore = ':disabled,:hidden';
        return form.valid();
    },
    onFinishing: function (event, currentIndex) {
        form.validate().settings.ignore = ':disabled';
        return form.valid();
    },
    onFinished: function (event, currentIndex) {
        swal("Good job!", "Submitted!", "success");
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
        nombresede: "required"
      },
      messages: {
        nombresede: "mensaje para nombre sede"
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