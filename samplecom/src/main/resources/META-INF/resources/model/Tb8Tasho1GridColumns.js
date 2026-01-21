/**
 * 他生１グリッド定義
 */

let Tb8Tasho1GridColumns = [];

$(function() {
    Tb8Tasho1GridColumns = [
        Column.text('TASHO1_ID', Messages['Tb8Tasho1Grid.tasho1Id'], 90, 'primaryKey numbering', null),
        Column.refer('SUM2_ID', Messages['Tb8Tasho1Grid.sum2Id'], 90, '', ''),
        Column.cell('UPDATE_TS', Messages['Tb8Tasho1Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
