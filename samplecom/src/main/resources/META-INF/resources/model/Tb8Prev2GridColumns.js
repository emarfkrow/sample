/**
 * 前世２グリッド定義
 */

let Tb8Prev2GridColumns = [];

$(function() {
    Tb8Prev2GridColumns = [
        Column.text('PREV2_ID', Messages['Tb8Prev2Grid.prev2Id'], 90, 'primaryKey numbering', null),
        Column.text('PREV2_INFO', Messages['Tb8Prev2Grid.prev2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb8Prev2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
