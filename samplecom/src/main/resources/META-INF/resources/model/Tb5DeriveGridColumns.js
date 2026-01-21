/**
 * 派生グリッド定義
 */

let Tb5DeriveGridColumns = [];

$(function() {
    Tb5DeriveGridColumns = [
        Column.text('DERIVE_ID', Messages['Tb5DeriveGrid.deriveId'], 90, 'primaryKey numbering', null),
        Column.refer('PREV_ID', Messages['Tb5DeriveGrid.prevId'], 90, '', ''),
        Column.text('PREV_INFO', Messages['Tb5DeriveGrid.prevInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb5DeriveGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
