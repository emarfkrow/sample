/**
 * 派生１明細グリッド定義
 */

let T06Derive1DetGridColumns = [];

$(function() {
    T06Derive1DetGridColumns = [
        Column.text('DERIVE1_ID', Messages['T06Derive1DetGrid.derive1Id'], 100, 'primaryKey numbering', null),
        Column.text('DERIVE1_BN', Messages['T06Derive1DetGrid.derive1Bn'], 100, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T06Derive1DetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T06Derive1DetGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
