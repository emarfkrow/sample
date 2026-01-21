/**
 * 派生２グリッド定義
 */

let Tb6Derive2GridColumns = [];

$(function() {
    Tb6Derive2GridColumns = [
        Column.text('DERIVE2_ID', Messages['Tb6Derive2Grid.derive2Id'], 90, 'primaryKey numbering', null),
        Column.refer('ORG_ID', Messages['Tb6Derive2Grid.orgId'], 90, 'notblank', ''),
        Column.text('ORG_INFO', Messages['Tb6Derive2Grid.orgInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb6Derive2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
