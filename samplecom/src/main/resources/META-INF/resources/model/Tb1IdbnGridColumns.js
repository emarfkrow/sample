/**
 * ID連番マスタグリッド定義
 */

let Tb1IdbnGridColumns = [];

$(function() {
    Tb1IdbnGridColumns = [
        Column.refer('IDREF_ID', Messages['Tb1IdbnGrid.idrefId'], 90, 'primaryKey', 'IDREF_MEI'),
        Column.text('IDBN_BN', Messages['Tb1IdbnGrid.idbnBn'], 90, 'primaryKey numbering', null),
        Column.text('IDBN_NO', Messages['Tb1IdbnGrid.idbnNo'], 90, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Tb1IdbnGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
