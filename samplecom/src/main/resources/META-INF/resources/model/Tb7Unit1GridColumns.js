/**
 * 単位１グリッド定義
 */

let Tb7Unit1GridColumns = [];

$(function() {
    Tb7Unit1GridColumns = [
        Column.text('UNIT1_ID', Messages['Tb7Unit1Grid.unit1Id'], 90, 'primaryKey numbering', null),
        Column.refer('SUM_ID', Messages['Tb7Unit1Grid.sumId'], 90, '', ''),
        Column.cell('UPDATE_TS', Messages['Tb7Unit1Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
