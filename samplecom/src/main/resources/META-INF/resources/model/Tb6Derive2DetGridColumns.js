/**
 * 派生２明細グリッド定義
 */

let Tb6Derive2DetGridColumns = [];

$(function() {
    Tb6Derive2DetGridColumns = [
        Column.text('DERIVE2_ID', Messages['Tb6Derive2DetGrid.derive2Id'], 90, 'primaryKey numbering', null),
        Column.text('DERIVE2_BN', Messages['Tb6Derive2DetGrid.derive2Bn'], 90, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['Tb6Derive2DetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6Derive2DetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
