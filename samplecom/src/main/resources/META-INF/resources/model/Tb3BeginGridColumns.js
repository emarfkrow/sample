/**
 * 当初グリッド定義
 */

let Tb3BeginGridColumns = [];

$(function() {
    Tb3BeginGridColumns = [
        Column.text('BEGIN_ID', Messages['Tb3BeginGrid.beginId'], 90, 'primaryKey numbering', null),
        Column.text('BEGIN_INFO', Messages['Tb3BeginGrid.beginInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb3BeginGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
