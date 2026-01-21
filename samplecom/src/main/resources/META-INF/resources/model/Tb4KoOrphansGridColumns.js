/**
 * 孤児グリッド定義
 */

let Tb4KoOrphansGridColumns = [];

$(function() {
    Tb4KoOrphansGridColumns = [
        Column.text('OYA_ID', Messages['Tb4KoOrphansGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['Tb4KoOrphansGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('ORPHANS_INFO', Messages['Tb4KoOrphansGrid.orphansInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb4KoOrphansGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
