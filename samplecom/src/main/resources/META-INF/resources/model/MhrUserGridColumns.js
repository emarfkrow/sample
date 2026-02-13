/**
 * ユーザマスタグリッド定義
 */

let MhrUserGridColumns = [];

$(function() {
    MhrUserGridColumns = [
        Column.text('USER_ID', Messages['MhrUserGrid.userId'], 100, 'primaryKey numbering', null),
        Column.text('USER_SEI', Messages['MhrUserGrid.userSei'], 300, 'notblank', null),
        Column.text('USER_MEI', Messages['MhrUserGrid.userMei'], 300, 'notblank', null),
        Column.text('E_MAIL', Messages['MhrUserGrid.eMail'], 300, 'notblank', null),
        Column.text('PASSWORD', Messages['MhrUserGrid.password'], 300, 'notblank', null),
        Column.date('TEKIYO_BI', Messages['MhrUserGrid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['MhrUserGrid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['MhrUserGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
