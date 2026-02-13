/**
 * 選抜グリッド定義
 */

let T10ChoiceGridColumns = [];

$(function() {
    T10ChoiceGridColumns = [
        Column.text('CHOICE_ID', Messages['T10ChoiceGrid.choiceId'], 100, 'primaryKey numbering', null),
        Column.refer('KOHO1_ID', Messages['T10ChoiceGrid.koho1Id'], 100, '', ''),
        Column.text('KOHO1_INFO', Messages['T10ChoiceGrid.koho1Info'], 300, '', null),
        Column.refer('KOHO2_ID', Messages['T10ChoiceGrid.koho2Id'], 100, '', ''),
        Column.text('KOHO2_INFO', Messages['T10ChoiceGrid.koho2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T10ChoiceGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
