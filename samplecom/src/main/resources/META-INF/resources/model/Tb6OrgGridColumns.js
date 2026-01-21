/**
 * 起源グリッド定義
 */

let Tb6OrgGridColumns = [];

$(function() {
    Tb6OrgGridColumns = [
        Column.text('ORG_ID', Messages['Tb6OrgGrid.orgId'], 90, 'primaryKey numbering', null),
        Column.text('ORG_INFO', Messages['Tb6OrgGrid.orgInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6OrgGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
