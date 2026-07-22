/**
 * V14_YOJITSU grid columns
 */

let V14YojitsuGridColumns = [];

$(function() {
    V14YojitsuGridColumns = [
        Column.text('KOUTEI_ID', Messages['V14YojitsuGrid.kouteiId'], 100, '', null),
        Column.longText('KOUTEI_TX', Messages['V14YojitsuGrid.kouteiTx'], 300, '', null),
        Column.date('KAISHI_BI', Messages['V14YojitsuGrid.kaishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('SHURYO_BI', Messages['V14YojitsuGrid.shuryoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.text('SAGYOKU_CD', Messages['V14YojitsuGrid.sagyokuCd'], 100, '', null),
        Column.text('OYA_KOUTEI_ID', Messages['V14YojitsuGrid.oyaKouteiId'], 100, '', null),
        Column.date('JISSHI_BI', Messages['V14YojitsuGrid.jisshiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('KANRYO_BI', Messages['V14YojitsuGrid.kanryoBi'], 100, '', Slick.Formatters.Extends.Date),
    ];
});
