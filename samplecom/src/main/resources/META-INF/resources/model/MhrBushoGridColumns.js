/**
 * 部署マスタグリッド定義
 */

let MhrBushoGridColumns = [];

$(function() {
    MhrBushoGridColumns = [
        Column.text('BUSHO_ID', Messages['MhrBushoGrid.bushoId'], 100, 'primaryKey numbering', null),
        Column.text('BUSHO_MEI', Messages['MhrBushoGrid.bushoMei'], 300, 'notblank', null),
        Column.refer('OYA_BUSHO_ID', Messages['MhrBushoGrid.oyaBushoId'], 100, '', 'OYA_BUSHO_MEI'),
        Column.date('TEKIYO_BI', Messages['MhrBushoGrid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['MhrBushoGrid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['MhrBushoGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
