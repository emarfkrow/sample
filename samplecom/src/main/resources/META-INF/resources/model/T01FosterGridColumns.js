/**
 * T01_FOSTER grid columns
 */

let T01FosterGridColumns = [];

$(function() {
    T01FosterGridColumns = [
        Column.text('BRO_ID', Messages['T01FosterGrid.broId'], 100, 'primaryKey numbering', null),
        Column.text('FOSTER_INFO', Messages['T01FosterGrid.fosterInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01FosterGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
