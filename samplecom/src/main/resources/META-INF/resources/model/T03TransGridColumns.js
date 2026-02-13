/**
 * 変遷グリッド定義
 */

let T03TransGridColumns = [];

$(function() {
    T03TransGridColumns = [
        Column.text('TRANS_ID', Messages['T03TransGrid.transId'], 100, 'primaryKey numbering', null),
        Column.text('TRANS_INFO', Messages['T03TransGrid.transInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T03TransGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
