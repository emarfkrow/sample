/**
 * T07_DERIVE1_DET grid columns
 */

let T07Derive1DetGridColumns = [];

$(function() {
    T07Derive1DetGridColumns = [
        Column.text('DERIVE1_ID', Messages['T07Derive1DetGrid.derive1Id'], 100, 'primaryKey numbering', null),
        Column.text('DERIVE1_BN', Messages['T07Derive1DetGrid.derive1Bn'], 100, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T07Derive1DetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T07Derive1DetGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
