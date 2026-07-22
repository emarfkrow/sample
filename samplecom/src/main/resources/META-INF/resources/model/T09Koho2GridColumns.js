/**
 * T09_KOHO2 grid columns
 */

let T09Koho2GridColumns = [];

$(function() {
    T09Koho2GridColumns = [
        Column.text('KOHO2_ID', Messages['T09Koho2Grid.koho2Id'], 100, 'primaryKey numbering', null),
        Column.text('KOHO2_INFO', Messages['T09Koho2Grid.koho2Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T09Koho2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
