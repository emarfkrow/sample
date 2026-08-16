/**
 * T02_MAGO grid columns
 */

let T02MagoGridColumns = [];

$(function() {
    T02MagoGridColumns = [
        Column.text('OYA_ID', Messages['T02MagoGrid.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T02MagoGrid.koBn'], 100, 'primaryKey numbering', null),
        Column.text('MAGO_BN', Messages['T02MagoGrid.magoBn'], 100, 'primaryKey numbering', null),
        Column.text('MAGO_INFO', Messages['T02MagoGrid.magoInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02MagoGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
