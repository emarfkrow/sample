/**
 * 再帰グリッド定義
 */

let M04SaikiGridColumns = [];

$(function() {
    M04SaikiGridColumns = [
        Column.text('SAIKI_ID', Messages['M04SaikiGrid.saikiId'], 90, 'primaryKey numbering', null),
        Column.text('SAIKI_MEI', Messages['M04SaikiGrid.saikiMei'], 300, 'notblank', null),
        Column.refer('IDREF_ID', Messages['M04SaikiGrid.idrefId'], 90, '', 'IDREF_MEI'),
        Column.refer('CDREF_CD', Messages['M04SaikiGrid.cdrefCd'], 90, '', 'CDREF_MEI'),
        Column.refer('NOREF_NO', Messages['M04SaikiGrid.norefNo'], 90, '', 'NOREF_MEI'),
        Column.refer('IDBN_IDREF_ID', Messages['M04SaikiGrid.idbnIdrefId'], 90, '', 'IDBN_IDREF_MEI'),
        Column.refer('IDBN_BN', Messages['M04SaikiGrid.idbnBn'], 90, '', 'IDBN_NO'),
        Column.refer('OYA_SAIKI_ID', Messages['M04SaikiGrid.oyaSaikiId'], 90, '', 'OYA_SAIKI_MEI'),
        Column.cell('UPDATE_TS', Messages['M04SaikiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
