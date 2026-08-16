/**
 * T06_REBORN_DET grid columns
 */

let T06RebornDetGridColumns = [];

$(function() {
    T06RebornDetGridColumns = [
        Column.text('REBORN_ID', Messages['T06RebornDetGrid.rebornId'], 100, 'primaryKey numbering', null),
        Column.text('REBORN_BN', Messages['T06RebornDetGrid.rebornBn'], 100, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T06RebornDetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T06RebornDetGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
