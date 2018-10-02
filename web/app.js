function openURL(href) {

    initializeLoader();

    var link = href;  //$(this).attr('href');                                    
    $.ajax({
        url: link + '.jsp',
        type: 'POST',
        cache: false,
        success: function (result) {

            setTimeout(function () {

                $('#load_content').children().remove();
                $('#load_content').append(result);
                //$.validator.unobtrusive.parse($("form#ValidateForm"));

                openJS(href);

            }, 1000);


        }
    });
    $(".nav-item").removeClass('active');
    $("#" + href).addClass('active');
    //window.history.pushState({href: href}, '', '/' + localStorage.getItem('url') + '/app/' + href);
    window.history.pushState({href: href}, '', './' + href);
}
function openJS(href) {
    $.getScript(href + ".js", function () {
        //$.getScript("parametrizable.js", function () {
        //});
    });
}

$(document).ready(function () {

    //localStorage.setItem('url', window.location.pathname.split('/')[(window.location.pathname.split('/').indexOf('app'))-1]);

    if (localStorage.getItem("redirect") != null) {
        openURL(localStorage.getItem("redirect"));
        localStorage.removeItem("redirect");
    } else {
        openURL('dash');
    }

    window.addEventListener('popstate', function (e) {
        if (e.state)
            openURL(e.state.href);
    });
    var demoDiv = $('sidebar');

}
);

function initializeLoader() {
    $('#loader').waitMe({
        effect: 'win8_linear',
        text: 'Cargando datos...',
        bg: 'rgba(243, 244, 250, 0.8)',
        color: '#128bfc'
    });
}

function dismissLoader() {
    setTimeout(function () {
        $('#loader').waitMe("hide");
    }, 300);
}

function initializePlugins() {
    $('.maxlenght').maxlength({
        alwaysShow: true,
        warningClass: "badge mt-1 badge-success",
        limitReachedClass: "badge mt-1 badge-danger"
    });
    $('[data-toggle="popover"]').popover();
    $('[data-toggle="tooltip"]').tooltip();
    $('.btn').on('click', function (e) {
        $('.btn').not(this).popover('hide');
    });
    if ($("#datepicker-popup").length) {
        $('#datepicker-popup').datepicker({
            enableOnReadonly: true,
            todayHighlight: true,
        });
    }

    $('.material-timedate').bootstrapMaterialDatePicker({format: 'dddd[,] DD [de] MMMM [de] YYYY - hh:mm a', shortTime: true, lang: 'es', cancelText: 'Cancelar', clearText: 'Borrar', nowText: 'Ahora', nowButton: true});
    $('.material-date').bootstrapMaterialDatePicker({format: 'dddd[,] DD [de] MMMM [de] YYYY', lang: 'es', time: false, cancelText: 'Cancelar', clearText: 'Borrar', nowText: 'Ahora', nowButton: true});
    $('.selectpicker').selectpicker();
    $('.dropify').dropify({
        messages: {
            'default': 'Arrastra un archivo o haz clic aquí',
            'replace': 'Arrastra un archivo o haz clic aquí para reemplazar',
            'remove': 'Eliminar',
            'error': 'Ooops, algo salió mal.'
        }
    });
    if ($(".color-picker").length) {
        $('.color-picker').asColorPicker();
    }
}