// Entidad en singular y en primera mayúscula
var entity = 'Store';
var entityPrettyPrintSingular = 'Tienda';
var entityPrettyPrintPlural = 'Tiendas';
var servlet = 'Attributes';
var tableDetails = true;
var tableDelete = true;
var tableModify = true;
var formContainer = 'form-container';
var formid = 'entity-form';
var searchFormContainer = 'search-form-container';
var searchFormid = 'search-form';
var modalid = 'entityModal';
var tableFinished = false;
var formFinished = false;

generatePage();

$('body').on('click', function (e) {
    $('[data-toggle=popover]').each(function () {
// hide any open popovers when the anywhere else in the body is clicked
        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
            $(this).popover('hide');
        }
    });
});

$('#' + formid).on('submit', function () {
    submitForm($('#modal-confirm-button').val());
    return false;
});

$('#' + searchFormid).on('submit', function () {
    submitForm('search');
    return false;
});