/**
 * 末弟グリッド定義
 */

let Tb2YoungestGridColumns = [];

$(function() {
    Tb2YoungestGridColumns = [
        Column.text('BRO_ID', Messages['Tb2YoungestGrid.broId'], 90, 'primaryKey numbering', null),
        Column.text('YOUNGEST_INFO', Messages['Tb2YoungestGrid.youngestInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb2YoungestGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
