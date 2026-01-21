/**
 * 孫グリッド定義
 */

let Tb4MagoGridColumns = [];

$(function() {
    Tb4MagoGridColumns = [
        Column.text('OYA_ID', Messages['Tb4MagoGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['Tb4MagoGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('MAGO_BN', Messages['Tb4MagoGrid.magoBn'], 90, 'primaryKey numbering', null),
        Column.text('MAGO_INFO', Messages['Tb4MagoGrid.magoInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb4MagoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
