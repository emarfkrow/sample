/**
 * T03_STATUS_KB grid columns
 */

let T03StatusKbGridColumns = [];

$(function() {
    T03StatusKbGridColumns = [
        Column.text('FLOW_ID', Messages['T03StatusKbGrid.flowId'], 100, 'primaryKey numbering', null),
        Column.text('TABLE_NM', Messages['T03StatusKbGrid.tableNm'], 200, '', null),
        Column.text('PRIMARY_KEYS', Messages['T03StatusKbGrid.primaryKeys'], 300, '', null),
        Column.select('STATUS_KB', Messages['T03StatusKbGrid.statusKb'], 30, '', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.cell('KESSAI_TS', Messages['T03StatusKbGrid.kessaiTs'], 230, '', Slick.Formatters.Extends.Timestamp),
        Column.text('KESSAI_ID', Messages['T03StatusKbGrid.kessaiId'], 100, '', null),
        Column.longText('RIYU_TX', Messages['T03StatusKbGrid.riyuTx'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T03StatusKbGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
