/**
 * 変換先グリッド定義
 */

let T13DestGridColumns = [];

$(function() {
    T13DestGridColumns = [
        Column.text('DEST_ID', Messages['T13DestGrid.destId'], 100, 'primaryKey numbering', null),
        Column.text('DEST_INFO', Messages['T13DestGrid.destInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T13DestGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
