function openURL(href) {

    $('#loader').waitMe({
        effect: 'win8_linear',
        text: 'Cargando datos...',
        bg: 'rgba(255, 255, 255, 0.7)',
        color: '#128bfc'
    });

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

                $('#loader').waitMe("hide");

            }, 1000);


        }
    });
    $(".nav-item").removeClass('active');
    $("#" + href).addClass('active');
    window.history.pushState({href: href}, '', href);
}
function openJS(href) {
    $.getScript(href + ".js", function () {
    });
}

$(document).ready(function () {

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