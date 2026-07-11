/**
 * V00_YOJITSU gantt tasks
 */

let V00YojitsuGanttTasks = {

    load: function(data) {

        let tasks = [];

        for (let r in data) {
            let row = data[r];

            let task = {};
            task.id = row.KOUTEI_ID;
            task.name = row.KOUTEI_TX;
            task.start = row.KAISHI_BI;
            task.end = row.SHURYO_BI;
            task.dependencies = row.DEPENDENCIES ? row.DEPENDENCIES + '' : '';

            task.since = row.JISSHI_BI;
            task.until = row.KANRYO_BI;

            task.kouteiId = row.koutei_id;
            task.kouteiTx = row.koutei_tx;
            task.kaishiBi = row.kaishi_bi;
            task.shuryoBi = row.shuryo_bi;
            task.oyaKouteiId = row.oya_koutei_id;
            task.jisshiBi = row.jisshi_bi;
            task.kanryoBi = row.kanryo_bi;

            tasks.push(task);
        }

        return tasks;
    }
};
