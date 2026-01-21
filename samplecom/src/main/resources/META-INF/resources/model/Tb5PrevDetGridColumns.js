/**
 * 前世明細グリッド定義
 */

let Tb5PrevDetGridColumns = [];

$(function() {
    Tb5PrevDetGridColumns = [
        Column.text('PREV_ID', Messages['Tb5PrevDetGrid.prevId'], 90, 'primaryKey numbering', null),
        Column.text('PREV_BN', Messages['Tb5PrevDetGrid.prevBn'], 90, 'primaryKey numbering', null),
        Column.text('PREV_DET_INFO', Messages['Tb5PrevDetGrid.prevDetInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb5PrevDetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
