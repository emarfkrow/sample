/**
 * 区分値マスタグリッド定義
 */

let MsyKbnValGridColumns = [];

$(function() {
    MsyKbnValGridColumns = [
        Column.refer('KBN_NM', Messages['MsyKbnValGrid.kbnNm'], 200, 'primaryKey numbering', 'KBN_MEI'),
        Column.text('KBN_VAL', Messages['MsyKbnValGrid.kbnVal'], 30, 'primaryKey', null),
        Column.text('KBN_VAL_MEI', Messages['MsyKbnValGrid.kbnValMei'], 300, 'notblank', null),
        Column.text('HYOJI_ON', Messages['MsyKbnValGrid.hyojiOn'], 100, '', null),
        Column.text('CRITERIA', Messages['MsyKbnValGrid.criteria'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['MsyKbnValGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
