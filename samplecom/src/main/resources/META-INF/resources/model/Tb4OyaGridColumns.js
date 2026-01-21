/**
 * 親グリッド定義
 */

let Tb4OyaGridColumns = [];

$(function() {
    Tb4OyaGridColumns = [
        Column.text('OYA_ID', Messages['Tb4OyaGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('OYA_INFO', Messages['Tb4OyaGrid.oyaInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb4OyaGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
