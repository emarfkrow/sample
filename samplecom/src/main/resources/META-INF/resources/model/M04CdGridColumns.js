/**
 * CDマスタグリッド定義
 */

let M04CdGridColumns = [];

$(function() {
    M04CdGridColumns = [
        Column.text('CDREF_CD', Messages['M04CdGrid.cdrefCd'], 100, 'primaryKey', null),
        Column.text('CDREF_MEI', Messages['M04CdGrid.cdrefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M04CdGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
