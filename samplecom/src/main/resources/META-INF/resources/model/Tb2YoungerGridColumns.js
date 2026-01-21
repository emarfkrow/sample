/**
 * 弟グリッド定義
 */

let Tb2YoungerGridColumns = [];

$(function() {
    Tb2YoungerGridColumns = [
        Column.text('BRO_ID', Messages['Tb2YoungerGrid.broId'], 90, 'primaryKey numbering', null),
        Column.text('YOUNGER_INFO', Messages['Tb2YoungerGrid.youngerInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb2YoungerGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
