/**
 * T09_CHOICE grid columns
 */

let T09ChoiceGridColumns = [];

$(function() {
    T09ChoiceGridColumns = [
        Column.text('CHOICE_ID', Messages['T09ChoiceGrid.choiceId'], 100, 'primaryKey numbering', null),
        Column.refer('KOHO1_ID', Messages['T09ChoiceGrid.koho1Id'], 100, '', ''),
        Column.text('KOHO1_INFO', Messages['T09ChoiceGrid.koho1Info'], 300, '', null),
        Column.refer('KOHO2_ID', Messages['T09ChoiceGrid.koho2Id'], 100, '', ''),
        Column.text('KOHO2_INFO', Messages['T09ChoiceGrid.koho2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T09ChoiceGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
