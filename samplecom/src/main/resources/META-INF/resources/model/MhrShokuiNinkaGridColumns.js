/**
 * 認可マスタグリッド定義
 */

let MhrShokuiNinkaGridColumns = [];

$(function() {
    MhrShokuiNinkaGridColumns = [
        Column.refer('BUSHO_ID', Messages['MhrShokuiNinkaGrid.bushoId'], 100, 'primaryKey', 'BUSHO_MEI'),
        Column.refer('SHOKUI_ID', Messages['MhrShokuiNinkaGrid.shokuiId'], 100, 'primaryKey', 'SHOKUI_MEI'),
        Column.text('TABLE_REGEX', Messages['MhrShokuiNinkaGrid.tableRegex'], 200, 'primaryKey', null),
        Column.comma('KENGEN_B', Messages['MhrShokuiNinkaGrid.kengenB'], 100, 'notblank', null),
        Column.date('TEKIYO_BI', Messages['MhrShokuiNinkaGrid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['MhrShokuiNinkaGrid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['MhrShokuiNinkaGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
