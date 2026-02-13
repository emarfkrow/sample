/**
 * NOマスタグリッド定義
 */

let M04NoGridColumns = [];

$(function() {
    M04NoGridColumns = [
        Column.text('NOREF_NO', Messages['M04NoGrid.norefNo'], 100, 'primaryKey', null),
        Column.text('NOREF_MEI', Messages['M04NoGrid.norefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M04NoGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
