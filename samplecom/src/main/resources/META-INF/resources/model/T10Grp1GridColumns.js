/**
 * T10_GRP1 grid columns
 */

let T10Grp1GridColumns = [];

$(function() {
    T10Grp1GridColumns = [
        Column.text('GRP1_ID', Messages['T10Grp1Grid.grp1Id'], 100, 'primaryKey numbering', null),
        Column.refer('SUM_ID', Messages['T10Grp1Grid.sumId'], 100, '', ''),
        Column.cell('UPDATE_TS', Messages['T10Grp1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
