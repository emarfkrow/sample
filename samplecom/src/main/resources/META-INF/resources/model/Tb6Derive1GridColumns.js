/**
 * 派生１グリッド定義
 */

let Tb6Derive1GridColumns = [];

$(function() {
    Tb6Derive1GridColumns = [
        Column.text('DERIVE1_ID', Messages['Tb6Derive1Grid.derive1Id'], 90, 'primaryKey numbering', null),
        Column.refer('ORG_ID', Messages['Tb6Derive1Grid.orgId'], 90, 'notblank', ''),
        Column.text('ORG_INFO', Messages['Tb6Derive1Grid.orgInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6Derive1Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
