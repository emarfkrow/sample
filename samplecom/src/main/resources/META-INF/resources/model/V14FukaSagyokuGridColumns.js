/**
 * V14_FUKA_SAGYOKU grid columns
 */

let V14FukaSagyokuGridColumns = [];

$(function() {
    V14FukaSagyokuGridColumns = [
        Column.text('LABELS', Messages['V14FukaSagyokuGrid.labels'], 80, '', null),
        Column.text('TYPE', Messages['V14FukaSagyokuGrid.type'], 40, '', null),
        Column.text('STACK', Messages['V14FukaSagyokuGrid.stack'], 100, '', null),
        Column.text('LABEL', Messages['V14FukaSagyokuGrid.label'], 100, '', null),
        Column.text('DATA', Messages['V14FukaSagyokuGrid.data'], 190, '', null),
    ];
});
