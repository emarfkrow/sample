/**
 * 長兄グリッド定義
 */

let T02EldestGridColumns = [];

$(function() {
    T02EldestGridColumns = [
        Column.text('BRO_ID', Messages['T02EldestGrid.broId'], 100, 'primaryKey numbering', null),
        Column.text('ELDEST_INFO', Messages['T02EldestGrid.eldestInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02EldestGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
        Column.text('T02_YOUNGER.YOUNGER_INFO', Messages['T02YoungerGrid.youngerInfo'], 300, '', null),
        Column.text('T02_YOUNGEST.YOUNGEST_INFO', Messages['T02YoungestGrid.youngestInfo'], 300, '', null),
    ];
});
