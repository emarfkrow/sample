/**
 * 孫グリッド定義
 */

let T01MagoGridColumns = [];

$(function() {
    T01MagoGridColumns = [
        Column.text('OYA_ID', Messages['T01MagoGrid.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T01MagoGrid.koBn'], 100, 'primaryKey numbering', null),
        Column.text('MAGO_BN', Messages['T01MagoGrid.magoBn'], 100, 'primaryKey numbering', null),
        Column.text('MAGO_INFO', Messages['T01MagoGrid.magoInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01MagoGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
