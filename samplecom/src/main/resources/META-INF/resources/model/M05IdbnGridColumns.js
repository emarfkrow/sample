/**
 * M05_IDBN grid columns
 */

let M05IdbnGridColumns = [];

$(function() {
    M05IdbnGridColumns = [
        Column.refer('IDREF_ID', Messages['M05IdbnGrid.idrefId'], 100, 'primaryKey', 'IDREF_MEI'),
        Column.text('IDBN_BN', Messages['M05IdbnGrid.idbnBn'], 100, 'primaryKey numbering', null),
        Column.text('IDBN_NO', Messages['M05IdbnGrid.idbnNo'], 100, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M05IdbnGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
