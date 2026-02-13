/**
 * 区分マスタグリッド定義
 */

let MsyKbnGridColumns = [];

$(function() {
    MsyKbnGridColumns = [
        Column.text('KBN_NM', Messages['MsyKbnGrid.kbnNm'], 200, 'primaryKey', null),
        Column.text('KBN_MEI', Messages['MsyKbnGrid.kbnMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['MsyKbnGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
