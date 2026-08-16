/**
 * M04_REF3 grid columns
 */

let M04Ref3GridColumns = [];

$(function() {
    M04Ref3GridColumns = [
        Column.text('REF3_ID', Messages['M04Ref3Grid.ref3Id'], 100, 'primaryKey numbering', null),
        Column.text('REF3_MEI', Messages['M04Ref3Grid.ref3Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['M04Ref3Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['M04Ref3Grid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['M04Ref3Grid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['M04Ref3Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
