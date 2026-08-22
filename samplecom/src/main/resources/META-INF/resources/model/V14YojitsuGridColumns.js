/**
 * V14_YOJITSU grid columns
 */

let V14YojitsuGridColumns = [];

$(function() {
    V14YojitsuGridColumns = [
        Column.text('KOUTEI_ID', Messages['V14YojitsuGrid.kouteiId'], 100, '', null),
        Column.longText('KOUTEI_TX', Messages['V14YojitsuGrid.kouteiTx'], 300, '', null),
        Column.text('KAISHI_YMD', Messages['V14YojitsuGrid.kaishiYmd'], 30, '', null),
        Column.text('SHURYO_YMD', Messages['V14YojitsuGrid.shuryoYmd'], 30, '', null),
        Column.text('SAGYOKU_CD', Messages['V14YojitsuGrid.sagyokuCd'], 100, '', null),
        Column.text('OYA_KOUTEI_ID', Messages['V14YojitsuGrid.oyaKouteiId'], 100, '', null),
        Column.text('JISSHI_YMD', Messages['V14YojitsuGrid.jisshiYmd'], 30, '', null),
        Column.text('KANRYO_YMD', Messages['V14YojitsuGrid.kanryoYmd'], 30, '', null),
        Column.text('DEPENDENCIES', Messages['V14YojitsuGrid.dependencies'], 30, '', null),
        Column.text('KOUTEI_PATH', Messages['V14YojitsuGrid.kouteiPath'], 300, '', null),
        Column.text('ROOT', Messages['V14YojitsuGrid.root'], 100, '', null),
    ];
});
