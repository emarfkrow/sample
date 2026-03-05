/**
 * ユニークキーグリッド定義
 */

let T00UniqueGridColumns = [];

$(function() {
    T00UniqueGridColumns = [
        Column.text('D_MEI', Messages['T00UniqueGrid.dMei'], 300, 'primaryKey', null),
        Column.text('E_MEI', Messages['T00UniqueGrid.eMei'], 300, 'primaryKey', null),
        Column.text('A_MEI', Messages['T00UniqueGrid.aMei'], 300, 'uniqueKey', null),
        Column.text('B_MEI', Messages['T00UniqueGrid.bMei'], 300, 'uniqueKey', null),
        Column.text('C_MEI', Messages['T00UniqueGrid.cMei'], 300, 'uniqueKey', null),
        Column.cell('UPDATE_TS', Messages['T00UniqueGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
