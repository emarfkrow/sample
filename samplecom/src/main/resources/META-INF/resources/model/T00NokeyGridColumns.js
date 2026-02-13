/**
 * 主キーなしグリッド定義
 */

let T00NokeyGridColumns = [];

$(function() {
    T00NokeyGridColumns = [
        Column.text('COL_D', Messages['T00NokeyGrid.colD'], 300, 'primaryKey', null),
        Column.text('COL_E', Messages['T00NokeyGrid.colE'], 300, 'primaryKey', null),
        Column.text('COL_A', Messages['T00NokeyGrid.colA'], 300, 'uniqueKey', null),
        Column.text('COL_B', Messages['T00NokeyGrid.colB'], 300, 'uniqueKey', null),
        Column.text('COL_C', Messages['T00NokeyGrid.colC'], 300, 'uniqueKey', null),
        Column.cell('UPDATE_TS', Messages['T00NokeyGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
