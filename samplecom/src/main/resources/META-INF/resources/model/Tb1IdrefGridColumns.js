/**
 * ID参照マスタグリッド定義
 */

let Tb1IdrefGridColumns = [];

$(function() {
    Tb1IdrefGridColumns = [
        Column.text('IDREF_ID', Messages['Tb1IdrefGrid.idrefId'], 90, 'primaryKey numbering', null),
        Column.text('IDREF_MEI', Messages['Tb1IdrefGrid.idrefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Tb1IdrefGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
