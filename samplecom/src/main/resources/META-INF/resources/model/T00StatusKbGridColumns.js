/**
 * 決裁フローグリッド定義
 */

let T00StatusKbGridColumns = [];

$(function() {
    T00StatusKbGridColumns = [
        Column.text('FLOW_ID', Messages['T00StatusKbGrid.flowId'], 100, 'primaryKey numbering', null),
        Column.text('TABLE_NM', Messages['T00StatusKbGrid.tableNm'], 200, '', null),
        Column.text('PRIMARY_KEYS', Messages['T00StatusKbGrid.primaryKeys'], 300, '', null),
        Column.select('STATUS_KB', Messages['T00StatusKbGrid.statusKb'], 30, '', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.cell('KESSAI_TS', Messages['T00StatusKbGrid.kessaiTs'], 230, '', Slick.Formatters.Extends.Timestamp),
        Column.text('KESSAI_ID', Messages['T00StatusKbGrid.kessaiId'], 100, '', null),
        Column.longText('RIYU_TX', Messages['T00StatusKbGrid.riyuTx'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T00StatusKbGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
