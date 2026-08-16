/**
 * MSY_KADOBI grid columns
 */

let MsyKadobiGridColumns = [];

$(function() {
    MsyKadobiGridColumns = [
        Column.date8('KADO_YMD', Messages['MsyKadobiGrid.kadoYmd'], 80, 'primaryKey', null),
        Column.refer('BUSHO_ID', Messages['MsyKadobiGrid.bushoId'], 100, 'primaryKey', 'BUSHO_MEI'),
        Column.check('KADOBI_F', Messages['MsyKadobiGrid.kadobiF'], 30, ''),
        Column.text('MEMO', Messages['MsyKadobiGrid.memo'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['MsyKadobiGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
