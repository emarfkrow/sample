/**
 * 子なしグリッド定義
 */

let Tb4KoDinksGridColumns = [];

$(function() {
    Tb4KoDinksGridColumns = [
        Column.text('OYA_ID', Messages['Tb4KoDinksGrid.oyaId'], 90, 'primaryKey numbering', null),
        Column.text('KO_BN', Messages['Tb4KoDinksGrid.koBn'], 90, 'primaryKey numbering', null),
        Column.text('DINKS_INFO', Messages['Tb4KoDinksGrid.dinksInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['Tb4KoDinksGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
