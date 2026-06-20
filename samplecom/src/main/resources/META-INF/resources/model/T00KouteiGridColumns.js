/**
 * 工程グリッド定義
 */

let T00KouteiGridColumns = [];

$(function() {
    T00KouteiGridColumns = [
        Column.text('KOUTEI_ID', Messages['T00KouteiGrid.kouteiId'], 100, 'primaryKey numbering', null),
        Column.text('KOUTEI_MEI', Messages['T00KouteiGrid.kouteiMei'], 300, 'notblank', null),
        Column.date('KAISHI_BI', Messages['T00KouteiGrid.kaishiBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.date('SHURYO_BI', Messages['T00KouteiGrid.shuryoBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.refer('OYA_KOUTEI_ID', Messages['T00KouteiGrid.oyaKouteiId'], 100, '', 'OYA_KOUTEI_MEI'),
        Column.cell('UPDATE_TS', Messages['T00KouteiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
