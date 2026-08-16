/**
 * T07_DERIVE2 grid columns
 */

let T07Derive2GridColumns = [];

$(function() {
    T07Derive2GridColumns = [
        Column.text('DERIVE2_ID', Messages['T07Derive2Grid.derive2Id'], 100, 'primaryKey numbering', null),
        Column.text('ORG_INFO', Messages['T07Derive2Grid.orgInfo'], 300, '', null),
        Column.refer('ORG_ID', Messages['T07Derive2Grid.orgId'], 100, 'notblank', ''),
        Column.cell('UPDATE_TS', Messages['T07Derive2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
