/**
 * 税マスタグリッド定義
 */

let MsyTaxGridColumns = [];

$(function() {
    MsyTaxGridColumns = [
        Column.select('TAX_KB', Messages['MsyTaxGrid.taxKb'], 30, 'primaryKey', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.date('TEKIYO_BI', Messages['MsyTaxGrid.tekiyoBi'], 90, 'primaryKey', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['MsyTaxGrid.haishiBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.dec2('TAX_RT', Messages['MsyTaxGrid.taxRt'], 45, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['MsyTaxGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
