/**
 * 転生明細グリッド定義
 */

let T07RebornDetGridColumns = [];

$(function() {
    T07RebornDetGridColumns = [
        Column.text('REBORN_ID', Messages['T07RebornDetGrid.rebornId'], 100, 'primaryKey numbering', null),
        Column.text('REBORN_BN', Messages['T07RebornDetGrid.rebornBn'], 100, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T07RebornDetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T07RebornDetGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
