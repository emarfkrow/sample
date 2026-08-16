/**
 * M05_SAIKI grid columns
 */

let M05SaikiGridColumns = [];

$(function() {
    M05SaikiGridColumns = [
        Column.text('SAIKI_ID', Messages['M05SaikiGrid.saikiId'], 100, 'primaryKey numbering', null),
        Column.text('SAIKI_MEI', Messages['M05SaikiGrid.saikiMei'], 300, 'notblank', null),
        Column.refer('IDREF_ID', Messages['M05SaikiGrid.idrefId'], 100, '', 'IDREF_MEI'),
        Column.refer('CDREF_CD', Messages['M05SaikiGrid.cdrefCd'], 100, '', 'CDREF_MEI'),
        Column.refer('NOREF_NO', Messages['M05SaikiGrid.norefNo'], 100, '', 'NOREF_MEI'),
        Column.refer('EX_IDREF_ID', Messages['M05SaikiGrid.exIdrefId'], 100, '', 'EX_IDREF_MEI'),
        Column.refer('EX_IDBN_BN', Messages['M05SaikiGrid.exIdbnBn'], 100, '', 'EX_IDBN_NO'),
        Column.refer('OYA_SAIKI_ID', Messages['M05SaikiGrid.oyaSaikiId'], 100, '', 'OYA_SAIKI_MEI'),
        Column.cell('UPDATE_TS', Messages['M05SaikiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
