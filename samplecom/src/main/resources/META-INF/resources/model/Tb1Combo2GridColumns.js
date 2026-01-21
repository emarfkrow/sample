/**
 * 複合２グリッド定義
 */

let Tb1Combo2GridColumns = [];

$(function() {
    Tb1Combo2GridColumns = [
        Column.refer('REFER1_ID', Messages['Tb1Combo2Grid.refer1Id'], 90, 'primaryKey numbering', 'REFER1_MEI'),
        Column.refer('REFER2_ID', Messages['Tb1Combo2Grid.refer2Id'], 90, 'primaryKey numbering', 'REFER2_MEI'),
        Column.refer('REFER3_ID', Messages['Tb1Combo2Grid.refer3Id'], 90, 'primaryKey', 'REFER3_MEI'),
        Column.date('TEKIYO_BI', Messages['Tb1Combo2Grid.tekiyoBi'], 90, 'primaryKey', Slick.Formatters.Extends.Date),
        Column.text('COMBO2_INFO', Messages['Tb1Combo2Grid.combo2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb1Combo2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
