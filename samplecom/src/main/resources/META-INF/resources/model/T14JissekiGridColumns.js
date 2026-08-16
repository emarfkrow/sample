/**
 * T14_JISSEKI grid columns
 */

let T14JissekiGridColumns = [];

$(function() {
    T14JissekiGridColumns = [
        Column.refer('KOUTEI_ID', Messages['T14JissekiGrid.kouteiId'], 100, 'primaryKey', 'KOUTEI_MEI'),
        Column.text('JISSEKI_BN', Messages['T14JissekiGrid.jissekiBn'], 100, 'primaryKey numbering', null),
        Column.date8('JISSHI_YMD', Messages['T14JissekiGrid.jisshiYmd'], 80, 'notblank', null),
        Column.date8('KANRYO_YMD', Messages['T14JissekiGrid.kanryoYmd'], 80, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['T14JissekiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
