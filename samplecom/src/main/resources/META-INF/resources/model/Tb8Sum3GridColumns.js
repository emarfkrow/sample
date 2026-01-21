/**
 * 集約３グリッド定義
 */

let Tb8Sum3GridColumns = [];

$(function() {
    Tb8Sum3GridColumns = [
        Column.text('SUM3_ID', Messages['Tb8Sum3Grid.sum3Id'], 90, 'primaryKey numbering', null),
        Column.text('SUM3_INFO', Messages['Tb8Sum3Grid.sum3Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb8Sum3Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
