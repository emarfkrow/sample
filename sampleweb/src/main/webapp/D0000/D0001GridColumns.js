/**
 *
 */
let D0001GridColumns = [];

$(function() {
    D0001GridColumns = [
        Column.text('OYA_ID', Messages['D0001.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('OYA_INFO', Messages['D0001.oyaInfo'], 300, '', null),
        Column.text('KO_BN', Messages['D0001.koBn'], 100, 'primaryKey numbering', null),
        Column.text('KO_INFO', Messages['D0001.koInfo'], 300, '', null),
    ];
});