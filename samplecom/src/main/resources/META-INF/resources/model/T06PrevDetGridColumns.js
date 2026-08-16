/**
 * T06_PREV_DET grid columns
 */

let T06PrevDetGridColumns = [];

$(function() {
    T06PrevDetGridColumns = [
        Column.text('PREV_ID', Messages['T06PrevDetGrid.prevId'], 100, 'primaryKey numbering', null),
        Column.text('PREV_BN', Messages['T06PrevDetGrid.prevBn'], 100, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T06PrevDetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T06PrevDetGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
