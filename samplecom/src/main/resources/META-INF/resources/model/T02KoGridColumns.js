/**
 * T02_KO grid columns
 */

let T02KoGridColumns = [];

$(function() {
    T02KoGridColumns = [
        Column.text('OYA_ID', Messages['T02KoGrid.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T02KoGrid.koBn'], 100, 'primaryKey numbering', null),
        Column.text('KO_INFO', Messages['T02KoGrid.koInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02KoGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
