/**
 * 複合１グリッド定義
 */

let T05Comp1GridColumns = [];

$(function() {
    T05Comp1GridColumns = [
        Column.refer('REF1_ID', Messages['T05Comp1Grid.ref1Id'], 100, 'primaryKey', 'REF1_MEI'),
        Column.refer('REF2_ID', Messages['T05Comp1Grid.ref2Id'], 100, 'primaryKey', 'REF2_MEI'),
        Column.text('COMP1_MEI', Messages['T05Comp1Grid.comp1Mei'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T05Comp1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
