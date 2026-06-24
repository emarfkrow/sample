/**
 * T03_TRANS_HIS grid columns
 */

let T03TransHisGridColumns = [];

$(function() {
    T03TransHisGridColumns = [
        Column.text('TRANS_ID', Messages['T03TransHisGrid.transId'], 100, 'primaryKey numbering', null),
        Column.text('TRANS_BN', Messages['T03TransHisGrid.transBn'], 100, 'primaryKey numbering', null),
        Column.text('TRANS_INFO', Messages['T03TransHisGrid.transInfo'], 300, '', null),
        Column.select('STATUS_KB', Messages['T03TransHisGrid.statusKb'], 30, '', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.longText('RIYU_TX', Messages['T03TransHisGrid.riyuTx'], 300, 'notblank', null),
        Column.cell('UPDATE_TS', Messages['T03TransHisGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
