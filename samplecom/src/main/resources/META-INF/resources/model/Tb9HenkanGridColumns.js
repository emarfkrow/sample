/**
 * VIEWグリッド定義
 */

let Tb9HenkanGridColumns = [];

$(function() {
    Tb9HenkanGridColumns = [
        Column.text('SRC_ID', Messages['Tb9HenkanGrid.srcId'], 90, '', null),
        Column.text('DEST_INFO', Messages['Tb9HenkanGrid.destInfo'], 300, '', null),
    ];
});
