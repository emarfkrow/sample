/**
 * 候補３グリッド定義
 */

let T12Koho3GridColumns = [];

$(function() {
    T12Koho3GridColumns = [
        Column.text('KOHO3_ID', Messages['T12Koho3Grid.koho3Id'], 100, 'primaryKey numbering', null),
        Column.text('KOHO3_INFO', Messages['T12Koho3Grid.koho3Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T12Koho3Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
