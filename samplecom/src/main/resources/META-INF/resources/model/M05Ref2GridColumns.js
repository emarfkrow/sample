/**
 * マスタ参照２グリッド定義
 */

let M05Ref2GridColumns = [];

$(function() {
    M05Ref2GridColumns = [
        Column.text('REF2_ID', Messages['M05Ref2Grid.ref2Id'], 100, 'primaryKey numbering', null),
        Column.text('REF2_MEI', Messages['M05Ref2Grid.ref2Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['M05Ref2Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['M05Ref2Grid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['M05Ref2Grid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['M05Ref2Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
