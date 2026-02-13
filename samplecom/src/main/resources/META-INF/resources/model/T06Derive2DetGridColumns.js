/**
 * 派生２明細グリッド定義
 */

let T06Derive2DetGridColumns = [];

$(function() {
    T06Derive2DetGridColumns = [
        Column.text('DERIVE2_ID', Messages['T06Derive2DetGrid.derive2Id'], 100, 'primaryKey numbering', null),
        Column.text('DERIVE2_BN', Messages['T06Derive2DetGrid.derive2Bn'], 100, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T06Derive2DetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T06Derive2DetGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
