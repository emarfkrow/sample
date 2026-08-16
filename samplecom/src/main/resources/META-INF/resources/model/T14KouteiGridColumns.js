/**
 * T14_KOUTEI grid columns
 */

let T14KouteiGridColumns = [];

$(function() {
    T14KouteiGridColumns = [
        Column.text('KOUTEI_ID', Messages['T14KouteiGrid.kouteiId'], 100, 'primaryKey numbering', null),
        Column.text('KOUTEI_MEI', Messages['T14KouteiGrid.kouteiMei'], 300, 'notblank', null),
        Column.date8('KAISHI_YMD', Messages['T14KouteiGrid.kaishiYmd'], 80, 'notblank', null),
        Column.date8('SHURYO_YMD', Messages['T14KouteiGrid.shuryoYmd'], 80, 'notblank', null),
        Column.text('SAGYOKU_CD', Messages['T14KouteiGrid.sagyokuCd'], 100, 'notblank', null),
        Column.refer('OYA_KOUTEI_ID', Messages['T14KouteiGrid.oyaKouteiId'], 100, '', 'OYA_KOUTEI_MEI'),
        Column.cell('UPDATE_TS', Messages['T14KouteiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
