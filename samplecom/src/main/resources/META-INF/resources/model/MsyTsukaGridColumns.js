/**
 * 通貨マスタグリッド定義
 */

let MsyTsukaGridColumns = [];

$(function() {
    MsyTsukaGridColumns = [
        Column.select('TSUKA_KB', Messages['MsyTsukaGrid.tsukaKb'], 30, 'primaryKey', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.date('TEKIYO_BI', Messages['MsyTsukaGrid.tekiyoBi'], 90, 'primaryKey', Slick.Formatters.Extends.Date),
        Column.dec2('TTS', Messages['MsyTsukaGrid.tts'], 45, 'notblank', null),
        Column.dec2('TTB', Messages['MsyTsukaGrid.ttb'], 45, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['MsyTsukaGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
