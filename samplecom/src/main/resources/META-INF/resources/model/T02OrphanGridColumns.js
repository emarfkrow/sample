/**
 * T02_ORPHAN grid columns
 */

let T02OrphanGridColumns = [];

$(function() {
    T02OrphanGridColumns = [
        Column.text('OYA_ID', Messages['T02OrphanGrid.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T02OrphanGrid.koBn'], 100, 'primaryKey numbering', null),
        Column.text('ORPHAN_INFO', Messages['T02OrphanGrid.orphanInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02OrphanGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
