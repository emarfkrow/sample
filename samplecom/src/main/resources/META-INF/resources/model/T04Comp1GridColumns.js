/**
 * T04_COMP1 grid columns
 */

let T04Comp1GridColumns = [];

$(function() {
    T04Comp1GridColumns = [
        Column.refer('REF1_ID', Messages['T04Comp1Grid.ref1Id'], 100, 'primaryKey', 'REF1_MEI'),
        Column.refer('REF2_ID', Messages['T04Comp1Grid.ref2Id'], 100, 'primaryKey', 'REF2_MEI'),
        Column.text('COMP1_MEI', Messages['T04Comp1Grid.comp1Mei'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T04Comp1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
