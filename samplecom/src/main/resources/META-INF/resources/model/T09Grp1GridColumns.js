/**
 * 集団１グリッド定義
 */

let T09Grp1GridColumns = [];

$(function() {
    T09Grp1GridColumns = [
        Column.text('GRP1_ID', Messages['T09Grp1Grid.grp1Id'], 100, 'primaryKey numbering', null),
        Column.refer('SUM_ID', Messages['T09Grp1Grid.sumId'], 100, '', ''),
        Column.cell('UPDATE_TS', Messages['T09Grp1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
