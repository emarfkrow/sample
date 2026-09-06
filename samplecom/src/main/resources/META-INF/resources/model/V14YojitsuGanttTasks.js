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
            task.start = row.KAISHI_YMD;
            task.end = row.SHURYO_YMD;
            task.dependencies = row.DEPENDENCIES ? row.DEPENDENCIES + '' : '';

            task.since = row.JISSHI_YMD;
            task.until = row.KANRYO_YMD;

            task.kouteiId = row.KOUTEI_ID;
            task.kouteiTx = row.KOUTEI_TX;
            task.kaishiYmd = row.KAISHI_YMD;
            task.shuryoYmd = row.SHURYO_YMD;
            task.sagyokuCd = row.SAGYOKU_CD;
            task.oyaKouteiId = row.OYA_KOUTEI_ID;
            task.jisshiYmd = row.JISSHI_YMD;
            task.kanryoYmd = row.KANRYO_YMD;
            task.kouteiPath = row.KOUTEI_PATH;
            task.root = row.ROOT;

            tasks.push(task);
        }

        return tasks;
    }
};
