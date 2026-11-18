/**
 * V14_YOJITSU grid columns
 */

let V14YojitsuGridColumns = [];

$(function() {
    V14YojitsuGridColumns = [
        Column.text('KOUTEI_ID', Messages['V14YojitsuGrid.kouteiId'], 100, '', null),
        Column.text('TASK_ID', Messages['V14YojitsuGrid.taskId'], 100, '', null),
        Column.text('TASK_MEI', Messages['V14YojitsuGrid.taskMei'], 300, '', null),
        Column.text('TASK_START', Messages['V14YojitsuGrid.taskStart'], 100, '', null),
        Column.text('TASK_UNTIL', Messages['V14YojitsuGrid.taskUntil'], 100, '', null),
        Column.text('DEPENDENCIES', Messages['V14YojitsuGrid.dependencies'], 300, '', null),
        Column.text('TASK_BEG', Messages['V14YojitsuGrid.taskBeg'], 100, '', null),
        Column.text('TASK_END', Messages['V14YojitsuGrid.taskEnd'], 100, '', null),
    ];
    V14YojitsuGridColumns.hasViewDetail = true;
});
