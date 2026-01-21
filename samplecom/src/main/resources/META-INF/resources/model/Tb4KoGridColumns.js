/**
 * 子グリッド定義
 */

let Tb4KoGridColumns = [];

$(function() {
    Tb4KoGridColumns = [
        Column.text('OYA_ID', Messages['Tb4KoGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['Tb4KoGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('KO_INFO', Messages['Tb4KoGrid.koInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb4KoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
