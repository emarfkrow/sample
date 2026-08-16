/**
 * M05_CD grid columns
 */

let M05CdGridColumns = [];

$(function() {
    M05CdGridColumns = [
        Column.text('CDREF_CD', Messages['M05CdGrid.cdrefCd'], 100, 'primaryKey', null),
        Column.text('CDREF_MEI', Messages['M05CdGrid.cdrefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M05CdGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
