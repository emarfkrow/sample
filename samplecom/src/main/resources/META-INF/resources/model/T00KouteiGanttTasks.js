/**
 * T00_KOUTEI gantt tasks
 */

let T00KouteiGanttTasks = {

    load: function(data) {

        let tasks = [];

        for (let r in data) {
            let row = data[r];

            let task = {};
            task.id = row.KOUTEI_ID;
            task.name = row.KOUTEI_MEI;
            task.start = row.KAISHI_BI;
            task.end = row.SHURYO_BI;
            task.dependencies = row.DEPENDENCIES ? row.DEPENDENCIES + '' : '';

            task.kouteiId = row.KOUTEI_ID;
            task.kouteiMei = row.KOUTEI_MEI;
            task.kaishiBi = row.KAISHI_BI;
            task.shuryoBi = row.SHURYO_BI;
            task.oyaKouteiId = row.OYA_KOUTEI_ID;
            task.insertTs = row.INSERT_TS;
            task.insertUserId = row.INSERT_USER_ID;
            task.updateTs = row.UPDATE_TS;
            task.updateUserId = row.UPDATE_USER_ID;

            tasks.push(task);
        }

        return tasks;
    }
};
