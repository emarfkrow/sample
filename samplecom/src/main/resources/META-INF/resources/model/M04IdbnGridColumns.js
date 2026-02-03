/**
 * ID連番マスタグリッド定義
 */

let M04IdbnGridColumns = [];

$(function() {
    M04IdbnGridColumns = [
        Column.refer('IDREF_ID', Messages['M04IdbnGrid.idrefId'], 90, 'primaryKey numbering', 'IDREF_MEI'),
        Column.text('IDBN_BN', Messages['M04IdbnGrid.idbnBn'], 90, 'primaryKey numbering', null),
        Column.text('IDBN_NO', Messages['M04IdbnGrid.idbnNo'], 90, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M04IdbnGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
