/**
 * 参照１マスタグリッド定義
 */

let Tb1Refer1GridColumns = [];

$(function() {
    Tb1Refer1GridColumns = [
        Column.text('REFER1_ID', Messages['Tb1Refer1Grid.refer1Id'], 90, 'primaryKey numbering', null),
        Column.text('REFER1_MEI', Messages['Tb1Refer1Grid.refer1Mei'], 300, 'notblank', null),
        Column.check('DELETE_F', Messages['Tb1Refer1Grid.deleteF'], 30, ''),
        Column.date('TEKIYO_BI', Messages['Tb1Refer1Grid.tekiyoBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.date('HAISHI_BI', Messages['Tb1Refer1Grid.haishiBi'], 90, '', Slick.Formatters.Extends.Date),
        Column.cell('UPDATE_TS', Messages['Tb1Refer1Grid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
