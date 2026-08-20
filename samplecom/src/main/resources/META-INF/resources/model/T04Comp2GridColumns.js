/**
 * T04_COMP2 grid columns
 */

let T04Comp2GridColumns = [];

$(function() {
    T04Comp2GridColumns = [
        Column.refer('REF1_ID', Messages['T04Comp2Grid.ref1Id'], 100, 'primaryKey', 'REF1_MEI'),
        Column.refer('REF2_ID', Messages['T04Comp2Grid.ref2Id'], 100, 'primaryKey', 'REF2_MEI'),
        Column.refer('REF3_ID', Messages['T04Comp2Grid.ref3Id'], 100, 'primaryKey', 'REF3_MEI'),
        Column.date('TEKIYO_BI', Messages['T04Comp2Grid.tekiyoBi'], 100, 'primaryKey', Slick.Formatters.Extends.Date),
        Column.text('COMP2_INFO', Messages['T04Comp2Grid.comp2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T04Comp2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
