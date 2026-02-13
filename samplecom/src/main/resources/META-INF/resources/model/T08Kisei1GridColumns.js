/**
 * 寄生１グリッド定義
 */

let T08Kisei1GridColumns = [];

$(function() {
    T08Kisei1GridColumns = [
        Column.text('KISEI1_ID', Messages['T08Kisei1Grid.kisei1Id'], 100, 'primaryKey numbering', null),
        Column.text('KISEI1_INFO', Messages['T08Kisei1Grid.kisei1Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T08Kisei1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
