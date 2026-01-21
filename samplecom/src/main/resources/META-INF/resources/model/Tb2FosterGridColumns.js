/**
 * 里子グリッド定義
 */

let Tb2FosterGridColumns = [];

$(function() {
    Tb2FosterGridColumns = [
        Column.text('BRO_ID', Messages['Tb2FosterGrid.broId'], 90, 'primaryKey numbering', null),
        Column.text('FOSTER_INFO', Messages['Tb2FosterGrid.fosterInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb2FosterGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
