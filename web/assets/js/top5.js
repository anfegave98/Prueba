$(document).ready(function () {
    table = $('#tabletop5').DataTable({
        ajax: {
            url: "Lend_itemsS",
            type: "POST",
            dataSrc: '',
            data: {
                'op': "report"
            }
        },
        columns: [
            {data: 'codebar'},
            {data: 'name'},
            {data: 'borrowed_times'},
            {data: null}
        ],
        columnDefs: [
            {
                targets: -1,
                data: null,
                defaultContent: '<a style="cursor: pointer; "><i class="menu-icon mdi mdi-lightbulb-outline"></i>></a>'
            }
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        order: [[ 1, "desc" ]]
    });
});

