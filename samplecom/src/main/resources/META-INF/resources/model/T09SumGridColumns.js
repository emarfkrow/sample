/**
 * 集約グリッド定義
 */

let T09SumGridColumns = [];

$(function() {
    T09SumGridColumns = [
        Column.text('SUM_ID', Messages['T09SumGrid.sumId'], 100, 'primaryKey numbering', null),
        Column.text('SUM_INFO', Messages['T09SumGrid.sumInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T09SumGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
