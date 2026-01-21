/**
 * 履歴グリッド定義
 */

let Tb3BeginHisGridColumns = [];

$(function() {
    Tb3BeginHisGridColumns = [
        Column.text('BEGIN_ID', Messages['Tb3BeginHisGrid.beginId'], 90, 'primaryKey numbering', null),
        Column.text('RIREKI_BN', Messages['Tb3BeginHisGrid.rirekiBn'], 90, 'primaryKey numbering', null),
        Column.text('BEGIN_INFO', Messages['Tb3BeginHisGrid.beginInfo'], 300, '', null),
        Column.text('REASON', Messages['Tb3BeginHisGrid.reason'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['Tb3BeginHisGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
