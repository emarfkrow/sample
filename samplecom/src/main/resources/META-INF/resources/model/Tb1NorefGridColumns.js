/**
 * NO参照マスタグリッド定義
 */

let Tb1NorefGridColumns = [];

$(function() {
    Tb1NorefGridColumns = [
        Column.text('NOREF_NO', Messages['Tb1NorefGrid.norefNo'], 90, 'primaryKey', null),
        Column.text('NOREF_MEI', Messages['Tb1NorefGrid.norefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Tb1NorefGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
