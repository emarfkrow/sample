/**
 * T14_JISSEKI grid columns
 */

let T14JissekiGridColumns = [];

$(function() {
    T14JissekiGridColumns = [
        Column.refer('KOUTEI_ID', Messages['T14JissekiGrid.kouteiId'], 100, 'primaryKey', 'KOUTEI_MEI'),
        Column.text('JISSEKI_BN', Messages['T14JissekiGrid.jissekiBn'], 100, 'primaryKey numbering', null),
        Column.date('JISSHI_BI', Messages['T14JissekiGrid.jisshiBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.date('KANRYO_BI', Messages['T14JissekiGrid.kanryoBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['T14JissekiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
