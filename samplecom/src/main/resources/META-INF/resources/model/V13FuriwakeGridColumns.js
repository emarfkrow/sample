/**
 * VIEWグリッド定義
 */

let V13FuriwakeGridColumns = [];

$(function() {
    V13FuriwakeGridColumns = [
        Column.text('SRC_ID$DEST_ID', Messages['V13FuriwakeGrid.srcIdDestId'], 100, '', null),
        Column.text('INFO', Messages['V13FuriwakeGrid.info'], 300, '', null),
    ];
});
