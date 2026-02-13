/**
 * 里子グリッド定義
 */

let T02FosterGridColumns = [];

$(function() {
    T02FosterGridColumns = [
        Column.text('BRO_ID', Messages['T02FosterGrid.broId'], 100, 'primaryKey numbering', null),
        Column.text('FOSTER_INFO', Messages['T02FosterGrid.fosterInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02FosterGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
