/**
 * V14_YOJITSU gantt tasks
 */

let V14YojitsuGanttTasks = {

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

            task.kouteiId = row.KOUTEI_ID;
            task.kouteiTx = row.KOUTEI_TX;
            task.kaishiBi = row.KAISHI_BI;
            task.shuryoBi = row.SHURYO_BI;
            task.sagyokuCd = row.SAGYOKU_CD;
            task.oyaKouteiId = row.OYA_KOUTEI_ID;
            task.jisshiBi = row.JISSHI_BI;
            task.kanryoBi = row.KANRYO_BI;
            task.kouteiPath = row.KOUTEI_PATH;
            task.root = row.ROOT;

            tasks.push(task);
        }

        return tasks;
    }
};
