/**
 * 認可マスタグリッド定義
 */

let MhrShokuiNinkaGridColumns = [];

$(function() {
    MhrShokuiNinkaGridColumns = [
        Column.refer('BUSHO_ID', Messages['MhrShokuiNinkaGrid.bushoId'], 100, 'primaryKey', 'BUSHO_MEI'),
        Column.refer('SHOKUI_ID', Messages['MhrShokuiNinkaGrid.shokuiId'], 100, 'primaryKey', 'SHOKUI_MEI'),
        Column.text('KINO_NM', Messages['MhrShokuiNinkaGrid.kinoNm'], 200, 'primaryKey', null),
        Column.select('KENGEN_KB', Messages['MhrShokuiNinkaGrid.kengenKb'], 30, 'notblank', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.date('TEKIYO_BI', Messages['MhrShokuiNinkaGrid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['MhrShokuiNinkaGrid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['MhrShokuiNinkaGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
