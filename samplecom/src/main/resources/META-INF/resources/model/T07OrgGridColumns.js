/**
 * T07_ORG grid columns
 */

let T07OrgGridColumns = [];

$(function() {
    T07OrgGridColumns = [
        Column.text('ORG_ID', Messages['T07OrgGrid.orgId'], 100, 'primaryKey numbering', null),
        Column.text('ORG_INFO', Messages['T07OrgGrid.orgInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T07OrgGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
