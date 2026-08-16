/**
 * M05_NO grid columns
 */

let M05NoGridColumns = [];

$(function() {
    M05NoGridColumns = [
        Column.text('NOREF_NO', Messages['M05NoGrid.norefNo'], 100, 'primaryKey', null),
        Column.text('NOREF_MEI', Messages['M05NoGrid.norefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M05NoGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
