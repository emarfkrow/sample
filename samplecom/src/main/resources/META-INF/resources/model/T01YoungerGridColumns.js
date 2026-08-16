/**
 * T01_YOUNGER grid columns
 */

let T01YoungerGridColumns = [];

$(function() {
    T01YoungerGridColumns = [
        Column.text('BRO_ID', Messages['T01YoungerGrid.broId'], 100, 'primaryKey numbering', null),
        Column.text('YOUNGER_INFO', Messages['T01YoungerGrid.youngerInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01YoungerGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
