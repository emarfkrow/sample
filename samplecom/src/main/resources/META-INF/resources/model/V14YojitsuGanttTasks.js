/**
 * V14_YOJITSU gantt tasks
 */

let V14YojitsuGanttTasks = {

    load: function(data) {

        let tasks = [];

        for (let r in data) {
            let row = data[r];

            let task = {};
            task.id = row.TASK_ID;
            task.name = row.TASK_MEI;
            task.start = row.TASK_START;
            task.end = row.TASK_UNTIL;
            task.dependencies = row.DEPENDENCIES ? row.DEPENDENCIES + '' : '';
            task.description = row.DESCRIPTION ? row.DESCRIPTION + '' : '';

            task.since = row.TASK_BEG;
            task.until = row.TASK_END;

            task.tableName = row.TABLE_NAME;
            task.kouteiId = row.KOUTEI_ID;
            task.taskId = row.TASK_ID;
            task.taskMei = row.TASK_MEI;
            task.taskStart = row.TASK_START;
            task.taskUntil = row.TASK_UNTIL;
            task.taskBeg = row.TASK_BEG;
            task.taskEnd = row.TASK_END;

            tasks.push(task);
        }

        return tasks;
    }
};
