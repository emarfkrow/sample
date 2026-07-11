/**
 * T07_REBORN grid columns
 */

let T07RebornGridColumns = [];

$(function() {
    T07RebornGridColumns = [
        Column.text('REBORN_ID', Messages['T07RebornGrid.rebornId'], 100, 'primaryKey numbering', null),
        Column.text('PREV_INFO', Messages['T07RebornGrid.prevInfo'], 300, '', null),
        Column.cell('PREV_ID', Messages['T07RebornGrid.prevId'], 100, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['T07RebornGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
