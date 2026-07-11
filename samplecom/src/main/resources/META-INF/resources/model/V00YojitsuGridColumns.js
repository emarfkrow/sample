/**
 * V00_YOJITSU grid columns
 */

let V00YojitsuGridColumns = [];

$(function() {
    V00YojitsuGridColumns = [
        Column.text('KOUTEI_ID', Messages['V00YojitsuGrid.kouteiId'], 100, '', null),
        Column.longText('KOUTEI_TX', Messages['V00YojitsuGrid.kouteiTx'], 300, '', null),
        Column.date('KAISHI_BI', Messages['V00YojitsuGrid.kaishiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('SHURYO_BI', Messages['V00YojitsuGrid.shuryoBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.text('OYA_KOUTEI_ID', Messages['V00YojitsuGrid.oyaKouteiId'], 100, '', null),
        Column.date('JISSHI_BI', Messages['V00YojitsuGrid.jisshiBi'], 100, '', Slick.Formatters.Extends.Date),
        Column.date('KANRYO_BI', Messages['V00YojitsuGrid.kanryoBi'], 100, '', Slick.Formatters.Extends.Date),
    ];
});
