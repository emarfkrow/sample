/**
 * 稼働日マスタグリッド定義
 */

let MsyKadobiGridColumns = [];

$(function() {
    MsyKadobiGridColumns = [
        Column.date('KADO_BI', Messages['MsyKadobiGrid.kadoBi'], 90, 'primaryKey', Slick.Formatters.Extends.Date),
        Column.refer('BUSHO_ID', Messages['MsyKadobiGrid.bushoId'], 90, 'primaryKey', 'BUSHO_MEI'),
        Column.check('KADOBI_F', Messages['MsyKadobiGrid.kadobiF'], 30, 'notblank'),
        Column.text('MEMO', Messages['MsyKadobiGrid.memo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['MsyKadobiGrid.updateTs'], 207, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
