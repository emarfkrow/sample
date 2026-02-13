/**
 * 他生１グリッド定義
 */

let T11Tasho1GridColumns = [];

$(function() {
    T11Tasho1GridColumns = [
        Column.text('TASHO1_ID', Messages['T11Tasho1Grid.tasho1Id'], 100, 'primaryKey numbering', null),
        Column.refer('REBORN2_ID', Messages['T11Tasho1Grid.reborn2Id'], 100, '', ''),
        Column.cell('UPDATE_TS', Messages['T11Tasho1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
