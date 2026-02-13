/**
 * 子なしグリッド定義
 */

let T01DinksGridColumns = [];

$(function() {
    T01DinksGridColumns = [
        Column.text('OYA_ID', Messages['T01DinksGrid.oyaId'], 100, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['T01DinksGrid.koBn'], 100, 'primaryKey numbering', null),
        Column.text('DINKS_INFO', Messages['T01DinksGrid.dinksInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T01DinksGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
