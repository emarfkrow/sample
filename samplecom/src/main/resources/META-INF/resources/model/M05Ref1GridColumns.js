/**
 * マスタ参照１グリッド定義
 */

let M05Ref1GridColumns = [];

$(function() {
    M05Ref1GridColumns = [
        Column.text('REF1_ID', Messages['M05Ref1Grid.ref1Id'], 100, 'primaryKey numbering', null),
        Column.text('REF1_MEI', Messages['M05Ref1Grid.ref1Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['M05Ref1Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['M05Ref1Grid.tekiyoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['M05Ref1Grid.haishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['M05Ref1Grid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
