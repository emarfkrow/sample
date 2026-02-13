/**
 * 再帰グリッド定義
 */

let M04SaikiGridColumns = [];

$(function() {
    M04SaikiGridColumns = [
        Column.text('SAIKI_ID', Messages['M04SaikiGrid.saikiId'], 100, 'primaryKey numbering', null),
        Column.text('SAIKI_MEI', Messages['M04SaikiGrid.saikiMei'], 300, 'notblank', null),
        Column.refer('IDREF_ID', Messages['M04SaikiGrid.idrefId'], 100, '', 'IDREF_MEI'),
        Column.refer('CDREF_CD', Messages['M04SaikiGrid.cdrefCd'], 100, '', 'CDREF_MEI'),
        Column.refer('NOREF_NO', Messages['M04SaikiGrid.norefNo'], 100, '', 'NOREF_MEI'),
        Column.refer('EX_IDREF_ID', Messages['M04SaikiGrid.exIdrefId'], 100, '', 'EX_IDREF_MEI'),
        Column.refer('EX_IDBN_BN', Messages['M04SaikiGrid.exIdbnBn'], 100, '', 'EX_IDBN_NO'),
        Column.refer('OYA_SAIKI_ID', Messages['M04SaikiGrid.oyaSaikiId'], 100, '', 'OYA_SAIKI_MEI'),
        Column.cell('UPDATE_TS', Messages['M04SaikiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
