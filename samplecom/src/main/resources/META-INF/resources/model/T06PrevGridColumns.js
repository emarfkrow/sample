/**
 * T06_PREV grid columns
 */

let T06PrevGridColumns = [];

$(function() {
    T06PrevGridColumns = [
        Column.text('PREV_ID', Messages['T06PrevGrid.prevId'], 100, 'primaryKey numbering', null),
        Column.text('PREV_INFO', Messages['T06PrevGrid.prevInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T06PrevGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
