/**
 * T00_JISSEKI grid columns
 */

let T00JissekiGridColumns = [];

$(function() {
    T00JissekiGridColumns = [
        Column.refer('KOUTEI_ID', Messages['T00JissekiGrid.kouteiId'], 100, 'primaryKey', 'KOUTEI_MEI'),
        Column.text('JISSEKI_BN', Messages['T00JissekiGrid.jissekiBn'], 100, 'primaryKey numbering', null),
        Column.date('JISSHI_BI', Messages['T00JissekiGrid.jisshiBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.date('KANRYO_BI', Messages['T00JissekiGrid.kanryoBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['T00JissekiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
