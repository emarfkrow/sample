/**
 * 統合グリッド定義
 */

let Tb5MergeGridColumns = [];

$(function() {
    Tb5MergeGridColumns = [
        Column.text('MERGE_ID', Messages['Tb5MergeGrid.mergeId'], 90, 'primaryKey numbering', null),
        Column.refer('PREV_ID', Messages['Tb5MergeGrid.prevId'], 90, 'notblank', ''),
        Column.text('PREV_INFO', Messages['Tb5MergeGrid.prevInfo'], 300, '', null),
        Column.refer('ORG_ID', Messages['Tb5MergeGrid.orgId'], 90, 'notblank', ''),
        Column.text('ORG_INFO', Messages['Tb5MergeGrid.orgInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb5MergeGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
