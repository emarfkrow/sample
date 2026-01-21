/**
 * 長兄グリッド定義
 */

let Tb2EldestGridColumns = [];

$(function() {
    Tb2EldestGridColumns = [
        Column.text('BRO_ID', Messages['Tb2EldestGrid.broId'], 90, 'primaryKey numbering', null),
        Column.text('ELDEST_INFO', Messages['Tb2EldestGrid.eldestInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb2EldestGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
