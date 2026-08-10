/**
 * V14_FUKA_KADOBI grid columns
 */

let V14FukaKadobiGridColumns = [];

$(function() {
    V14FukaKadobiGridColumns = [
        Column.text('LABELS', Messages['V14FukaKadobiGrid.labels'], 80, '', null),
        Column.text('TYPE', Messages['V14FukaKadobiGrid.type'], 30, '', null),
        Column.text('STACK', Messages['V14FukaKadobiGrid.stack'], 50, '', null),
        Column.text('LABEL', Messages['V14FukaKadobiGrid.label'], 100, '', null),
        Column.text('DATA', Messages['V14FukaKadobiGrid.data'], 190, '', null),
    ];
});
