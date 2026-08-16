/**
 * T07_DERIVE1 grid columns
 */

let T07Derive1GridColumns = [];

$(function() {
    T07Derive1GridColumns = [
        Column.text('DERIVE1_ID', Messages['T07Derive1Grid.derive1Id'], 100, 'primaryKey numbering', null),
        Column.text('ORG_INFO', Messages['T07Derive1Grid.orgInfo'], 300, '', null),
        Column.refer('ORG_ID', Messages['T07Derive1Grid.orgId'], 100, 'notblank', ''),
        Column.cell('UPDATE_TS', Messages['T07Derive1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
