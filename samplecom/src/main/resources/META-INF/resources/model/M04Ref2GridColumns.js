/**
 * M04_REF2 grid columns
 */

let M04Ref2GridColumns = [];

$(function() {
    M04Ref2GridColumns = [
        Column.text('REF2_ID', Messages['M04Ref2Grid.ref2Id'], 100, 'primaryKey numbering', null),
        Column.text('REF2_MEI', Messages['M04Ref2Grid.ref2Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['M04Ref2Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['M04Ref2Grid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['M04Ref2Grid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['M04Ref2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
