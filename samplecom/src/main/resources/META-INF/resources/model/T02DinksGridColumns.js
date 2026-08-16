/**
 * T02_DINKS grid columns
 */

let T02DinksGridColumns = [];

$(function() {
    T02DinksGridColumns = [
        Column.text('OYA_ID', Messages['T02DinksGrid.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T02DinksGrid.koBn'], 100, 'primaryKey numbering', null),
        Column.text('DINKS_INFO', Messages['T02DinksGrid.dinksInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T02DinksGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
