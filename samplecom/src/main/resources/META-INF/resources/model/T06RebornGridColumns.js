/**
 * T06_REBORN grid columns
 */

let T06RebornGridColumns = [];

$(function() {
    T06RebornGridColumns = [
        Column.text('REBORN_ID', Messages['T06RebornGrid.rebornId'], 100, 'primaryKey numbering', null),
        Column.text('PREV_INFO', Messages['T06RebornGrid.prevInfo'], 300, '', null),
        Column.cell('PREV_ID', Messages['T06RebornGrid.prevId'], 100, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['T06RebornGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
