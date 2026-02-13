/**
 * 転生３グリッド定義
 */

let T12Reborn3GridColumns = [];

$(function() {
    T12Reborn3GridColumns = [
        Column.text('REBORN3_ID', Messages['T12Reborn3Grid.reborn3Id'], 100, 'primaryKey numbering', null),
        Column.refer('TASHO2_ID', Messages['T12Reborn3Grid.tasho2Id'], 100, 'notblank', ''),
        Column.cell('UPDATE_TS', Messages['T12Reborn3Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
