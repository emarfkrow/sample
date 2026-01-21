/**
 * 転生明細グリッド定義
 */

let Tb5RebornDetGridColumns = [];

$(function() {
    Tb5RebornDetGridColumns = [
        Column.text('REBORN_ID', Messages['Tb5RebornDetGrid.rebornId'], 90, 'primaryKey numbering', null),
        Column.text('REBORN_BN', Messages['Tb5RebornDetGrid.rebornBn'], 90, 'primaryKey numbering', null),
        Column.text('PREV_DET_INFO', Messages['Tb5RebornDetGrid.prevDetInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb5RebornDetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
