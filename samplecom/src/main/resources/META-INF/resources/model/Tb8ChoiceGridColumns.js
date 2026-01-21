/**
 * 選抜グリッド定義
 */

let Tb8ChoiceGridColumns = [];

$(function() {
    Tb8ChoiceGridColumns = [
        Column.text('CHOICE_ID', Messages['Tb8ChoiceGrid.choiceId'], 90, 'primaryKey numbering', null),
        Column.refer('SUM_ID', Messages['Tb8ChoiceGrid.sumId'], 90, '', ''),
        Column.text('SUM_INFO', Messages['Tb8ChoiceGrid.sumInfo'], 300, '', null),
        Column.refer('SUM2_ID', Messages['Tb8ChoiceGrid.sum2Id'], 90, '', ''),
        Column.text('SUM2_INFO', Messages['Tb8ChoiceGrid.sum2Info'], 300, '', null),
        Column.refer('SUM3_ID', Messages['Tb8ChoiceGrid.sum3Id'], 90, '', ''),
        Column.text('SUM3_INFO', Messages['Tb8ChoiceGrid.sum3Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb8ChoiceGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
