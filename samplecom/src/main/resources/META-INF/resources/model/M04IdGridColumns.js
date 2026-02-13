/**
 * IDマスタグリッド定義
 */

let M04IdGridColumns = [];

$(function() {
    M04IdGridColumns = [
        Column.text('IDREF_ID', Messages['M04IdGrid.idrefId'], 100, 'primaryKey numbering', null),
        Column.text('IDREF_MEI', Messages['M04IdGrid.idrefMei'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['M04IdGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
