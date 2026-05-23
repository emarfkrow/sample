/**
 *
 */
let D0001GridColumns = [];

$(function() {
    D0001GridColumns = [
        Column.text('OYA_ID', Messages['oyaId'], 100, 'primaryKey numbering', null),
        Column.text('OYA_INFO', Messages['oyaInfo'], 300, '', null),
        Column.text('KO_BN', Messages['koBn'], 100, 'primaryKey numbering', null),
        Column.text('KO_INFO', Messages['koInfo'], 300, '', null),
		Column.text('MAGO_BN', Messages['magoBn'], 100, 'primaryKey numbering', null),
		Column.text('MAGO_INFO', Messages['magoInfo'], 300, '', null),
    ];
});
