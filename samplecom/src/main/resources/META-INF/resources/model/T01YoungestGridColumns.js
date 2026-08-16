/**
 * T01_YOUNGEST grid columns
 */

let T01YoungestGridColumns = [];

$(function() {
    T01YoungestGridColumns = [
        Column.text('BRO_ID', Messages['T01YoungestGrid.broId'], 100, 'primaryKey numbering', null),
        Column.text('YOUNGEST_INFO', Messages['T01YoungestGrid.youngestInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01YoungestGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
