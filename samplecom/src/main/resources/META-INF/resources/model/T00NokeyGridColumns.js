/**
 * キーなしグリッド定義
 */

let T00NokeyGridColumns = [];

$(function() {
    T00NokeyGridColumns = [
        Column.text('A_MEI', Messages['T00NokeyGrid.aMei'], 300, '', null),
        Column.text('B_MEI', Messages['T00NokeyGrid.bMei'], 300, '', null),
        Column.text('C_MEI', Messages['T00NokeyGrid.cMei'], 300, '', null),
        Column.text('D_MEI', Messages['T00NokeyGrid.dMei'], 300, '', null),
        Column.text('E_MEI', Messages['T00NokeyGrid.eMei'], 300, '', null),
        Column.cell('UPDATE_TS', Messages['T00NokeyGrid.updateTs'], 230, 'metaInfo optLock', Slick.Formatters.Extends.Timestamp),
    ];
});
