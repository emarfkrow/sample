/**
 * V13_HENKAN grid columns
 */

let V13HenkanGridColumns = [];

$(function() {
    V13HenkanGridColumns = [
        Column.text('src_id', Messages['V13HenkanGrid.srcId'], 100, '', null),
        Column.text('dest_info', Messages['V13HenkanGrid.destInfo'], 300, '', null),
    ];
});
