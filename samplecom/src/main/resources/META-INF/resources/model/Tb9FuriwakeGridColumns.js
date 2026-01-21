/**
 * VIEWグリッド定義
 */

let Tb9FuriwakeGridColumns = [];

$(function() {
    Tb9FuriwakeGridColumns = [
        Column.text('SRC_ID$DEST_ID', Messages['Tb9FuriwakeGrid.srcIdDestId'], 90, '', null),
        Column.text('INFO', Messages['Tb9FuriwakeGrid.info'], 300, '', null),
    ];
});
