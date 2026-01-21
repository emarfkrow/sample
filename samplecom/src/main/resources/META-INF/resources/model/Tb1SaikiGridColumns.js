/**
 * 再帰グリッド定義
 */

let Tb1SaikiGridColumns = [];

$(function() {
    Tb1SaikiGridColumns = [
        Column.text('SAIKI_ID', Messages['Tb1SaikiGrid.saikiId'], 90, 'primaryKey numbering', null),
        Column.text('SAIKI_MEI', Messages['Tb1SaikiGrid.saikiMei'], 300, 'notblank', null),
        Column.refer('IDREF_ID', Messages['Tb1SaikiGrid.idrefId'], 90, '', 'IDREF_MEI'),
        Column.refer('CDREF_CD', Messages['Tb1SaikiGrid.cdrefCd'], 90, '', 'CDREF_MEI'),
        Column.refer('NOREF_NO', Messages['Tb1SaikiGrid.norefNo'], 90, '', 'NOREF_MEI'),
        Column.refer('EX_IDREF_ID', Messages['Tb1SaikiGrid.exIdrefId'], 90, '', 'EX_IDREF_MEI'),
        Column.refer('IDBN_BN', Messages['Tb1SaikiGrid.idbnBn'], 90, '', 'IDBN_NO'),
        Column.refer('OYA_SAIKI_ID', Messages['Tb1SaikiGrid.oyaSaikiId'], 90, '', 'OYA_SAIKI_MEI'),
        Column.cell('UPDATE_TS', Messages['Tb1SaikiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
