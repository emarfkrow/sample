/**
 * 単位３グリッド定義
 */

let Tb8Unit3GridColumns = [];

$(function() {
    Tb8Unit3GridColumns = [
        Column.text('UNIT3_ID', Messages['Tb8Unit3Grid.unit3Id'], 90, 'primaryKey numbering', null),
        Column.refer('SUM2_ID', Messages['Tb8Unit3Grid.sum2Id'], 90, '', ''),
        Column.cell('UPDATE_TS', Messages['Tb8Unit3Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
