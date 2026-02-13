/**
 * 職位マスタグリッド定義
 */

let MhrShokuiGridColumns = [];

$(function() {
    MhrShokuiGridColumns = [
        Column.text('SHOKUI_ID', Messages['MhrShokuiGrid.shokuiId'], 100, 'primaryKey numbering', null),
        Column.text('SHOKUI_MEI', Messages['MhrShokuiGrid.shokuiMei'], 300, 'notblank', null),
        Column.text('SHOKUI_ON', Messages['MhrShokuiGrid.shokuiOn'], 100, 'notblank', null),
        Column.date('TEKIYO_BI', Messages['MhrShokuiGrid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['MhrShokuiGrid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['MhrShokuiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
