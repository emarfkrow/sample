/**
 * 集約２グリッド定義
 */

let Tb8Sum2GridColumns = [];

$(function() {
    Tb8Sum2GridColumns = [
        Column.text('SUM2_ID', Messages['Tb8Sum2Grid.sum2Id'], 90, 'primaryKey numbering', null),
        Column.text('SUM2_INFO', Messages['Tb8Sum2Grid.sum2Info'], 300, '', null),
        Column.refer('PREV2_ID', Messages['Tb8Sum2Grid.prev2Id'], 90, 'notblank', ''),
        Column.cell('UPDATE_TS', Messages['Tb8Sum2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
