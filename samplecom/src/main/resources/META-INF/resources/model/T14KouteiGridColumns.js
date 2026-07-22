/**
 * T14_KOUTEI grid columns
 */

let T14KouteiGridColumns = [];

$(function() {
    T14KouteiGridColumns = [
        Column.text('KOUTEI_ID', Messages['T14KouteiGrid.kouteiId'], 100, 'primaryKey numbering', null),
        Column.text('KOUTEI_MEI', Messages['T14KouteiGrid.kouteiMei'], 300, 'notblank', null),
        Column.date('KAISHI_BI', Messages['T14KouteiGrid.kaishiBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.date('SHURYO_BI', Messages['T14KouteiGrid.shuryoBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.text('SAGYOKU_CD', Messages['T14KouteiGrid.sagyokuCd'], 100, 'notblank', null),
        Column.refer('OYA_KOUTEI_ID', Messages['T14KouteiGrid.oyaKouteiId'], 100, '', 'OYA_KOUTEI_MEI'),
        Column.cell('UPDATE_TS', Messages['T14KouteiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
