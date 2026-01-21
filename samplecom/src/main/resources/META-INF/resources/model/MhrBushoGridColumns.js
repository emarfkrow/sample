/**
 * 部署マスタグリッド定義
 */

let MhrBushoGridColumns = [];

$(function() {
    MhrBushoGridColumns = [
        Column.text('BUSHO_ID', Messages['MhrBushoGrid.bushoId'], 90, 'primaryKey numbering', null),
        Column.text('BUSHO_MEI', Messages['MhrBushoGrid.bushoMei'], 300, 'notblank', null),
        Column.refer('OYA_BUSHO_ID', Messages['MhrBushoGrid.oyaBushoId'], 90, '', 'OYA_BUSHO_MEI'),
        Column.date('TEKIYO_BI', Messages['MhrBushoGrid.tekiyoBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['MhrBushoGrid.haishiBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['MhrBushoGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
