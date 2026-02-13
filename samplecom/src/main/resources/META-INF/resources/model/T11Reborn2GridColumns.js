/**
 * 転生２グリッド定義
 */

let T11Reborn2GridColumns = [];

$(function() {
    T11Reborn2GridColumns = [
        Column.text('REBORN2_ID', Messages['T11Reborn2Grid.reborn2Id'], 100, 'primaryKey numbering', null),
        Column.text('PREV2_INFO', Messages['T11Reborn2Grid.prev2Info'], 300, '', null),
        Column.refer('PREV2_ID', Messages['T11Reborn2Grid.prev2Id'], 100, 'notblank', ''),
        Column.cell('UPDATE_TS', Messages['T11Reborn2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
