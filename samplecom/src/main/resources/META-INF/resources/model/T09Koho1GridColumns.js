/**
 * T09_KOHO1 grid columns
 */

let T09Koho1GridColumns = [];

$(function() {
    T09Koho1GridColumns = [
        Column.text('KOHO1_ID', Messages['T09Koho1Grid.koho1Id'], 100, 'primaryKey numbering', null),
        Column.text('KOHO1_INFO', Messages['T09Koho1Grid.koho1Info'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T09Koho1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
