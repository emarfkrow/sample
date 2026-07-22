/**
 * T10_GRP2 grid columns
 */

let T10Grp2GridColumns = [];

$(function() {
    T10Grp2GridColumns = [
        Column.text('GRP2_ID', Messages['T10Grp2Grid.grp2Id'], 100, 'primaryKey numbering', null),
        Column.refer('SUM_ID', Messages['T10Grp2Grid.sumId'], 100, '', ''),
        Column.cell('UPDATE_TS', Messages['T10Grp2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
