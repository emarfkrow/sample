/**
 * 他生２グリッド定義
 */

let Tb8Tasho2GridColumns = [];

$(function() {
    Tb8Tasho2GridColumns = [
        Column.text('TASHO2_ID', Messages['Tb8Tasho2Grid.tasho2Id'], 90, 'primaryKey numbering', null),
        Column.refer('SUM3_ID', Messages['Tb8Tasho2Grid.sum3Id'], 90, '', ''),
        Column.cell('UPDATE_TS', Messages['Tb8Tasho2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
