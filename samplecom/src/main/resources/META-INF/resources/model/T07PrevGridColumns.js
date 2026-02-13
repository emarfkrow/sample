/**
 * 前世グリッド定義
 */

let T07PrevGridColumns = [];

$(function() {
    T07PrevGridColumns = [
        Column.text('PREV_ID', Messages['T07PrevGrid.prevId'], 100, 'primaryKey numbering', null),
        Column.text('PREV_INFO', Messages['T07PrevGrid.prevInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T07PrevGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
