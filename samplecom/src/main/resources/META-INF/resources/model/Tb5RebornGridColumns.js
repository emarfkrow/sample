/**
 * 転生グリッド定義
 */

let Tb5RebornGridColumns = [];

$(function() {
    Tb5RebornGridColumns = [
        Column.text('REBORN_ID', Messages['Tb5RebornGrid.rebornId'], 90, 'primaryKey numbering', null),
        Column.refer('PREV_ID', Messages['Tb5RebornGrid.prevId'], 90, 'notblank', ''),
        Column.text('PREV_INFO', Messages['Tb5RebornGrid.prevInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb5RebornGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
