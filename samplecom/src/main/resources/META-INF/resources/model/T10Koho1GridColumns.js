/**
 * 候補１グリッド定義
 */

let T10Koho1GridColumns = [];

$(function() {
    T10Koho1GridColumns = [
        Column.text('KOHO1_ID', Messages['T10Koho1Grid.koho1Id'], 100, 'primaryKey numbering', null),
        Column.text('KOHO1_INFO', Messages['T10Koho1Grid.koho1Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T10Koho1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
