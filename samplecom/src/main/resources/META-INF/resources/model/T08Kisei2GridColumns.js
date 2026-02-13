/**
 * 寄生２グリッド定義
 */

let T08Kisei2GridColumns = [];

$(function() {
    T08Kisei2GridColumns = [
        Column.text('KISEI2_ID', Messages['T08Kisei2Grid.kisei2Id'], 100, 'primaryKey numbering', null),
        Column.text('KISEI2_INFO', Messages['T08Kisei2Grid.kisei2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T08Kisei2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
