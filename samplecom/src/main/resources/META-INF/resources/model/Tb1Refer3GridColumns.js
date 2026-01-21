/**
 * 参照３マスタグリッド定義
 */

let Tb1Refer3GridColumns = [];

$(function() {
    Tb1Refer3GridColumns = [
        Column.text('REFER3_ID', Messages['Tb1Refer3Grid.refer3Id'], 90, 'primaryKey numbering', null),
        Column.text('REFER3_MEI', Messages['Tb1Refer3Grid.refer3Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['Tb1Refer3Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['Tb1Refer3Grid.tekiyoBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['Tb1Refer3Grid.haishiBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['Tb1Refer3Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
