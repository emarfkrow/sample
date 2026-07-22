/**
 * T10_SUM grid columns
 */

let T10SumGridColumns = [];

$(function() {
    T10SumGridColumns = [
        Column.text('SUM_ID', Messages['T10SumGrid.sumId'], 100, 'primaryKey numbering', null),
        Column.text('SUM_INFO', Messages['T10SumGrid.sumInfo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T10SumGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
