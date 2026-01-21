/**
 * CD参照マスタグリッド定義
 */

let Tb1CdrefGridColumns = [];

$(function() {
    Tb1CdrefGridColumns = [
        Column.text('CDREF_CD', Messages['Tb1CdrefGrid.cdrefCd'], 90, 'primaryKey', null),
        Column.text('CDREF_MEI', Messages['Tb1CdrefGrid.cdrefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Tb1CdrefGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
