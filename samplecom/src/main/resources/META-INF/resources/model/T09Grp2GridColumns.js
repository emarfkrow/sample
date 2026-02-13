/**
 * 集団２グリッド定義
 */

let T09Grp2GridColumns = [];

$(function() {
    T09Grp2GridColumns = [
        Column.text('GRP2_ID', Messages['T09Grp2Grid.grp2Id'], 100, 'primaryKey numbering', null),
        Column.refer('SUM_ID', Messages['T09Grp2Grid.sumId'], 100, '', ''),
        Column.cell('UPDATE_TS', Messages['T09Grp2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
