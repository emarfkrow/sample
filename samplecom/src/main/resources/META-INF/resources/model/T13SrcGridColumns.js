/**
 * 変換元グリッド定義
 */

let T13SrcGridColumns = [];

$(function() {
    T13SrcGridColumns = [
        Column.text('SRC_ID', Messages['T13SrcGrid.srcId'], 100, 'primaryKey numbering', null),
        Column.text('SRC_INFO', Messages['T13SrcGrid.srcInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T13SrcGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
