/**
 * 変換元グリッド定義
 */

let Tb9SrcGridColumns = [];

$(function() {
    Tb9SrcGridColumns = [
        Column.text('SRC_ID', Messages['Tb9SrcGrid.srcId'], 90, 'primaryKey numbering', null),
        Column.text('SRC_INFO', Messages['Tb9SrcGrid.srcInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb9SrcGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
