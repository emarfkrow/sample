/**
 * 集約グリッド定義
 */

let Tb7SumGridColumns = [];

$(function() {
    Tb7SumGridColumns = [
        Column.text('SUM_ID', Messages['Tb7SumGrid.sumId'], 90, 'primaryKey numbering', null),
        Column.text('SUM_INFO', Messages['Tb7SumGrid.sumInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb7SumGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
