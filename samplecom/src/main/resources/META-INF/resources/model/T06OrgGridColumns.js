/**
 * 起源グリッド定義
 */

let T06OrgGridColumns = [];

$(function() {
    T06OrgGridColumns = [
        Column.text('ORG_ID', Messages['T06OrgGrid.orgId'], 100, 'primaryKey numbering', null),
        Column.text('ORG_INFO', Messages['T06OrgGrid.orgInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T06OrgGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
