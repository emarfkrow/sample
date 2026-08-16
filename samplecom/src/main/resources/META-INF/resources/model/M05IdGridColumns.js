/**
 * M05_ID grid columns
 */

let M05IdGridColumns = [];

$(function() {
    M05IdGridColumns = [
        Column.text('IDREF_ID', Messages['M05IdGrid.idrefId'], 100, 'primaryKey numbering', null),
        Column.text('IDREF_MEI', Messages['M05IdGrid.idrefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M05IdGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
