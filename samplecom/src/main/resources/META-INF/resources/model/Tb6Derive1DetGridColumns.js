/**
 * 派生１明細グリッド定義
 */

let Tb6Derive1DetGridColumns = [];

$(function() {
    Tb6Derive1DetGridColumns = [
        Column.text('DERIVE1_ID', Messages['Tb6Derive1DetGrid.derive1Id'], 90, 'primaryKey numbering', null),
        Column.text('DERIVE1_BN', Messages['Tb6Derive1DetGrid.derive1Bn'], 90, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['Tb6Derive1DetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6Derive1DetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
