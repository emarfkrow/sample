/**
 * 転生グリッド定義
 */

let T07RebornGridColumns = [];

$(function() {
    T07RebornGridColumns = [
        Column.text('REBORN_ID', Messages['T07RebornGrid.rebornId'], 100, 'primaryKey numbering', null),
        Column.text('PREV_INFO', Messages['T07RebornGrid.prevInfo'], 300, '', null),
        Column.refer('PREV_ID', Messages['T07RebornGrid.prevId'], 100, 'notblank', ''),
        Column.cell('UPDATE_TS', Messages['T07RebornGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
