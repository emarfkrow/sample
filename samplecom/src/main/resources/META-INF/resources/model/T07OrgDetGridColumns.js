/**
 * T07_ORG_DET grid columns
 */

let T07OrgDetGridColumns = [];

$(function() {
    T07OrgDetGridColumns = [
        Column.text('ORG_ID', Messages['T07OrgDetGrid.orgId'], 100, 'primaryKey numbering', null),
        Column.text('ORG_BN', Messages['T07OrgDetGrid.orgBn'], 100, 'primaryKey numbering', null),
        Column.text('DET_INFO', Messages['T07OrgDetGrid.detInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T07OrgDetGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
