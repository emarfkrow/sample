/**
 * T02_OYA grid columns
 */

let T02OyaGridColumns = [];

$(function() {
    T02OyaGridColumns = [
        Column.text('OYA_ID', Messages['T02OyaGrid.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('OYA_INFO', Messages['T02OyaGrid.oyaInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02OyaGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
