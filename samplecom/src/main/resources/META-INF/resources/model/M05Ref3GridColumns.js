/**
 * マスタ参照３グリッド定義
 */

let M05Ref3GridColumns = [];

$(function() {
    M05Ref3GridColumns = [
        Column.text('REF3_ID', Messages['M05Ref3Grid.ref3Id'], 100, 'primaryKey numbering', null),
        Column.text('REF3_MEI', Messages['M05Ref3Grid.ref3Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['M05Ref3Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['M05Ref3Grid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['M05Ref3Grid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['M05Ref3Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
