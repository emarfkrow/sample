/**
 * 変換先グリッド定義
 */

let Tb9DestGridColumns = [];

$(function() {
    Tb9DestGridColumns = [
        Column.text('DEST_ID', Messages['Tb9DestGrid.destId'], 90, 'primaryKey numbering', null),
        Column.text('DEST_INFO', Messages['Tb9DestGrid.destInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb9DestGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
