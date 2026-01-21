/**
 * 起源明細グリッド定義
 */

let Tb6OrgDetGridColumns = [];

$(function() {
    Tb6OrgDetGridColumns = [
        Column.text('ORG_ID', Messages['Tb6OrgDetGrid.orgId'], 90, 'primaryKey numbering', null),
        Column.text('ORG_BN', Messages['Tb6OrgDetGrid.orgBn'], 90, 'primaryKey numbering', null),
        Column.text('ORG_DET_INFO', Messages['Tb6OrgDetGrid.orgDetInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6OrgDetGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
