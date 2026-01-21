/**
 * 参照２マスタグリッド定義
 */

let Tb1Refer2GridColumns = [];

$(function() {
    Tb1Refer2GridColumns = [
        Column.text('REFER2_ID', Messages['Tb1Refer2Grid.refer2Id'], 90, 'primaryKey numbering', null),
        Column.text('REFER2_MEI', Messages['Tb1Refer2Grid.refer2Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['Tb1Refer2Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['Tb1Refer2Grid.tekiyoBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['Tb1Refer2Grid.haishiBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['Tb1Refer2Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
