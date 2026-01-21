/**
 * 複合１グリッド定義
 */

let Tb1Combo1GridColumns = [];

$(function() {
    Tb1Combo1GridColumns = [
        Column.refer('REFER1_ID', Messages['Tb1Combo1Grid.refer1Id'], 90, 'primaryKey', 'REFER1_MEI'),
        Column.refer('REFER2_ID', Messages['Tb1Combo1Grid.refer2Id'], 90, 'primaryKey', 'REFER2_MEI'),
        Column.text('COMBO1_INFO', Messages['Tb1Combo1Grid.combo1Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb1Combo1Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
