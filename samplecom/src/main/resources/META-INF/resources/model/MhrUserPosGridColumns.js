/**
 * 所属マスタグリッド定義
 */

let MhrUserPosGridColumns = [];

$(function() {
    MhrUserPosGridColumns = [
        Column.refer('BUSHO_ID', Messages['MhrUserPosGrid.bushoId'], 100, 'primaryKey', 'BUSHO_MEI'),
        Column.refer('SHOKUI_ID', Messages['MhrUserPosGrid.shokuiId'], 100, 'primaryKey', 'SHOKUI_MEI'),
        Column.refer('USER_ID', Messages['MhrUserPosGrid.userId'], 100, 'primaryKey', 'USER_SEI'),
        Column.date('TEKIYO_BI', Messages['MhrUserPosGrid.tekiyoBi'], 100, 'primaryKey', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['MhrUserPosGrid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['MhrUserPosGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
