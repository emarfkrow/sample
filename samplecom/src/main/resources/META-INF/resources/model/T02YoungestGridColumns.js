/**
 * 末弟グリッド定義
 */

let T02YoungestGridColumns = [];

$(function() {
    T02YoungestGridColumns = [
        Column.text('BRO_ID', Messages['T02YoungestGrid.broId'], 100, 'primaryKey numbering', null),
        Column.text('YOUNGEST_INFO', Messages['T02YoungestGrid.youngestInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02YoungestGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
