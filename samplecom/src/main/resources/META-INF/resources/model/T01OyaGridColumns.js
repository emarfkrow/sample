/**
 * 親グリッド定義
 */

let T01OyaGridColumns = [];

$(function() {
    T01OyaGridColumns = [
        Column.text('OYA_ID', Messages['T01OyaGrid.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('OYA_INFO', Messages['T01OyaGrid.oyaInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01OyaGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
