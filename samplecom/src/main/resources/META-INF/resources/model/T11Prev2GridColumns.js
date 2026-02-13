/**
 * 前世２グリッド定義
 */

let T11Prev2GridColumns = [];

$(function() {
    T11Prev2GridColumns = [
        Column.text('PREV2_ID', Messages['T11Prev2Grid.prev2Id'], 100, 'primaryKey numbering', null),
        Column.text('PREV2_INFO', Messages['T11Prev2Grid.prev2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T11Prev2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
