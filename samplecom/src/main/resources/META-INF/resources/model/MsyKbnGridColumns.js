/**
 * 区分マスタグリッド定義
 */

let MsyKbnGridColumns = [];

$(function() {
    MsyKbnGridColumns = [
        Column.text('KBN_NM', Messages['MsyKbnGrid.kbnNm'], 180, 'primaryKey', null),
        Column.text('KBN_MEI', Messages['MsyKbnGrid.kbnMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['MsyKbnGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
