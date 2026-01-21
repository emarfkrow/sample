/**
 * 前世グリッド定義
 */

let Tb5PrevGridColumns = [];

$(function() {
    Tb5PrevGridColumns = [
        Column.text('PREV_ID', Messages['Tb5PrevGrid.prevId'], 90, 'primaryKey numbering', null),
        Column.text('PREV_INFO', Messages['Tb5PrevGrid.prevInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb5PrevGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
