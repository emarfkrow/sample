/**
 * VIEWグリッド定義
 */

let V13HenkanGridColumns = [];

$(function() {
    V13HenkanGridColumns = [
        Column.text('SRC_ID', Messages['V13HenkanGrid.srcId'], 100, '', null),
        Column.text('DEST_INFO', Messages['V13HenkanGrid.destInfo'], 300, '', null),
    ];
});
