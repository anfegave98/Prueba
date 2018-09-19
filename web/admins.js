$(document).ready(function () {

    var cols = [{
            "title": "Titulo",
            "data": "nombre"
        },
        {

            "title": "Two",
            "data": "Two"
        },
        {
            "title": "Three",
            "data": "Three",
            "format": 'M/D/YYYY'
        },
        {
            "title": "Four",
            "data": "Four"
        },
        {
            "title": "Five",
            "data": "Five"
        },
        {
            "title": "Six",
            "data": "Six"
        },
        {
            "title": "Actions",
            "data": null
        }];

    var data = [{
            "nombre": "test1",
            "Two": "test2 test2 test2 test2test2test2test2 test2test2 test2test2",
            "Three": new Date("12/09/2018"),
            "Four": "test54",
            "Five": "test5",
            "Six": "test1231 1231 23"
        },
        {

            "nombre": "test4",
            "Two": "test5",
            "Three": new Date("12/19/2018"),
            "Four": "test54 asd asdasd ad",
            "Five": "test5a asd asd a",
            "Six": "test1231 1231 23 dsad"
        },
        {
            "nombre": "test7",
            "Two": "test8",
            "Three": new Date("12/15/2018"),
            "Four": "test2 test2 test2 test2test2test2test2 test2test2 test2test2",
            "Five": "test5 dfasfsdf",
            "Six": "test1231 1231 23"
        }];
        var buttonDetails = '<button type="button" class="btn btn-success btn-fw ml-2"><i class="mdi mdi-magnify"></i>Details</button>';
        var buttonDelete = '<button type="button" class="btn btn-danger btn-fw ml-2"><i class="mdi mdi-delete"></i>Delete</button>';
        
        table = $('#id_de_tabla').DataTable({
        /*
         ajax: {
         url: "Lend_itemsS",
         type: "GET",
         dataSrc: '',
         data: {
         'op': "report",
         'store_id': 1
         }
         },
         */
        data: data,
        columns: cols,
        autoWidth: true,
        columnDefs: [
            {
                targets: -1,
                data: null,
                width: "100px", 
                defaultContent: buttonDetails + buttonDelete
            },
            {
                targets: 1,
                render: $.fn.dataTable.render.ellipsis(17)
            },
            {
                targets: 2,
                render: $.fn.dataTable.render.moment('DD/MM/YYYY')
            }            
        ],
        language: {
            url: 'https://cdn.datatables.net/plug-ins/1.10.16/i18n/Spanish.json'
        },
        responsive: true,
        fnDrawCallback: function( oSettings ) {
            $(".ellipsis").tooltip();
        }

    });

});