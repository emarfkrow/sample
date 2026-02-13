/**
 * エンティティグリッド定義
 */

let T00EntityGridColumns = [];

$(function() {
    T00EntityGridColumns = [
        Column.text('ENTITY_ID', Messages['T00EntityGrid.entityId'], 100, 'primaryKey numbering', null),
        Column.text('ENTITY_NM', Messages['T00EntityGrid.entityNm'], 200, 'notblank', null),
        Column.text('ENTITY_MEI', Messages['T00EntityGrid.entityMei'], 300, 'notblank', null),
        Column.check('CHECK_F', Messages['T00EntityGrid.checkF'], 30, 'notblank'),
        Column.select('RADIO_KB', Messages['T00EntityGrid.radioKb'], 30, 'notblank', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.select('PULLDOWN_KB', Messages['T00EntityGrid.pulldownKb'], 30, 'notblank', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.select('PULLDOWN_SB', Messages['T00EntityGrid.pulldownSb'], 30, 'notblank', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.longText('MEMO_TX', Messages['T00EntityGrid.memoTx'], 300, 'notblank', null),
        Column.text('MEMO', Messages['T00EntityGrid.memo'], 300, 'notblank', null),
        Column.link('TENPU_FILE', Messages['T00EntityGrid.tenpuFile'], 300, 'notblank'),
        Column.text('NENGAPPI_Y', Messages['T00EntityGrid.nengappiY'], 40, 'notblank', null),
        Column.text('NENGAPPI_M', Messages['T00EntityGrid.nengappiM'], 30, 'notblank', null),
        Column.text('NENGAPPI_D', Messages['T00EntityGrid.nengappiD'], 30, 'notblank', null),
        Column.month('NENGETSU_YM', Messages['T00EntityGrid.nengetsuYm'], 60, 'notblank', Slick.Formatters.Extends.Month),
        Column.date8('NENGAPPI_YMD', Messages['T00EntityGrid.nengappiYmd'], 80, 'notblank', null),
        Column.cell('TIMESTAMP_TS', Messages['T00EntityGrid.timestampTs'], 230, 'notblank', Slick.Formatters.Extends.Timestamp),
        Column.dateTime('NICHIJI_DT', Messages['T00EntityGrid.nichijiDt'], 190, 'notblank'),
        Column.date('HIDUKE_BI', Messages['T00EntityGrid.hidukeBi'], 100, 'notblank', Slick.Formatters.Extends.Date),
        Column.time('JIKOKU_HM', Messages['T00EntityGrid.jikokuHm'], 50, 'notblank', null),
        Column.text('JIKAN_TM', Messages['T00EntityGrid.jikanTm'], 90, 'notblank', null),
        Column.dec3('SURYO_QT', Messages['T00EntityGrid.suryoQt'], 110, 'notblank', null),
        Column.select('TSUKA_KB', Messages['T00EntityGrid.tsukaKb'], 30, 'notblank', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.dec2('JUCHU_PR', Messages['T00EntityGrid.juchuPr'], 110, 'notblank', null),
        Column.dec2('JUCHU_AM', Messages['T00EntityGrid.juchuAm'], 110, 'notblank', null),
        Column.dec2('HACHU_PR', Messages['T00EntityGrid.hachuPr'], 110, 'notblank', null),
        Column.dec2('HACHU_AM', Messages['T00EntityGrid.hachuAm'], 110, 'notblank', null),
        Column.check('DELETE_F', Messages['T00EntityGrid.deleteF'], 30, ''),
        Column.select('STATUS_KB', Messages['T00EntityGrid.statusKb'], 30, '', { json: 'MsyKbnValSearch.json', paramkey: 'KBN_NM', value: 'KBN_VAL', label: 'KBN_VAL_MEI' }),
        Column.cell('UPDATE_TS', Messages['T00EntityGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
