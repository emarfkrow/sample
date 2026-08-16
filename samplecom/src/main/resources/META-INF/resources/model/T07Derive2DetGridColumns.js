/**
 * T07_DERIVE2_DET grid columns
 */

let T07Derive2DetGridColumns = [];

$(function() {
    T07Derive2DetGridColumns = [
        Column.text('DERIVE2_ID', Messages['T07Derive2DetGrid.derive2Id'], 100, 'primaryKey numbering', null),
        Column.text('DERIVE2_BN', Messages['T07Derive2DetGrid.derive2Bn'], 100, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T07Derive2DetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T07Derive2DetGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
