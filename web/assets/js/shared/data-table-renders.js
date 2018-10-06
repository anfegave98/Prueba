$.fn.dataTable.render.moneda = function (sign) {
    return function (data, type, row) {
        return (parseFloat(data) > 0) ? (sign + ' ' + data) : ('-(' + sign + ' ' + -1 * data + ')');
    };
};

$.fn.dataTable.render.checkbox = function () {
    return function (data, type, row) {
        return data ? '<input type="checkbox" disabled checked/>' : '<input type="checkbox" disabled/>'
    };
};

$.fn.dataTable.render.photo = function () {
    return function (data, type, row) {
        return '<button onclick="openInNewTab(\'' + data + '\');" type="button" class="btn btn-warning btn-fw ml-2"><i class="mdi mdi-fullscreen"></i>Ver Imagen</button>'
    };
};

$.fn.dataTable.render.file = function () {
    return function (data, type, row) {
        return '<button onclick="openInNewTab(\'' + data + '\');" type="button" class="btn btn-success btn-fw ml-2"><i class="mdi mdi-cloud-download"></i>Descargar</button>'
    };
};

$.fn.dataTable.render.color = function () {
    return function (data, type, row) {
        return '<div style="background-color:' + data + ', border-color:#fff" class="badge badge-danger">' + data + '</div>'
    };
};

jQuery.fn.dataTable.render.ellipsis = function (cutoff, wordbreak, escapeHtml) {
    var esc = function (t) {
        return t
                .replace(/&/g, '&amp;')
                .replace(/</g, '&lt;')
                .replace(/>/g, '&gt;')
                .replace(/"/g, '&quot;');
    };

    return function (d, type, row) {
        // Order, search and type get the original data
        if (type !== 'display') {
            return d;
        }

        if (typeof d !== 'number' && typeof d !== 'string') {
            return d;
        }

        d = d.toString(); // cast numbers

        if (d.length <= cutoff) {
            return d;
        }

        var shortened = d.substr(0, cutoff - 1);

        // Find the last white space character in the string
        if (wordbreak) {
            shortened = shortened.replace(/\s([^\s]*)$/, '');
        }

        // Protect against uncontrolled HTML input
        if (escapeHtml) {
            shortened = esc(shortened);
        }

        return '<span class="ellipsis" data-toggle="tooltip" data-placement="bottom" title="' + esc(d) + '">' + shortened + '&#8230;</span>';

    };
};


jQuery.fn.dataTable.render.ellipsisLink = function (cutoff, wordbreak, escapeHtml) {
    var esc = function (t) {
        return t
                .replace(/&/g, '&amp;')
                .replace(/</g, '&lt;')
                .replace(/>/g, '&gt;')
                .replace(/"/g, '&quot;');
    };

    return function (d, type, row) {
        // Order, search and type get the original data
        if (type !== 'display') {
            return d;
        }

        if (typeof d !== 'number' && typeof d !== 'string') {
            return d;
        }

        d = d.toString(); // cast numbers

        if (d.length <= cutoff) {
            return d;
        }

        var shortened = d.substr(0, cutoff - 1);

        // Find the last white space character in the string
        if (wordbreak) {
            shortened = shortened.replace(/\s([^\s]*)$/, '');
        }

        // Protect against uncontrolled HTML input
        if (escapeHtml) {
            shortened = esc(shortened);
        }

        return '<a href="' + esc(d) + '">' + shortened + '&#8230;</a>';

    };
};

(function (factory) {
    "use strict";

    if (typeof define === 'function' && define.amd) {
        // AMD
        define(['jquery'], function ($) {
            return factory($, window, document);
        });
    } else if (typeof exports === 'object') {
        // CommonJS
        module.exports = function (root, $) {
            if (!root) {
                root = window;
            }

            if (!$) {
                $ = typeof window !== 'undefined' ?
                        require('jquery') :
                        require('jquery')(root);
            }

            return factory($, root, root.document);
        };
    } else {
        // Browser
        factory(jQuery, window, document);
    }
}
(function ($, window, document) {


    $.fn.dataTable.render.moment = function (from, to, locale) {
        // Argument shifting
        if (arguments.length === 1) {
            locale = 'en';
            to = from;
            from = 'YYYY-MM-DD';
        } else if (arguments.length === 2) {
            locale = 'en';
        }

        return function (d, type, row) {
            var m = window.moment(d, from, locale, true);

            // Order and type get a number value from Moment, everything else
            // sees the rendered value
            return m.format(type === 'sort' || type === 'type' ? 'x' : to);
        };
    };


}));