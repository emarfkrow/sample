/**
 * T01_ELDEST grid columns
 */

let T01EldestGridColumns = [];

$(function() {
    T01EldestGridColumns = [
        Column.text('BRO_ID', Messages['T01EldestGrid.broId'], 100, 'primaryKey numbering', null),
        Column.text('ELDEST_INFO', Messages['T01EldestGrid.eldestInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01EldestGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
