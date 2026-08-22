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

            task.kouteiId = row.koutei_id;
            task.kouteiTx = row.koutei_tx;
            task.kaishiYmd = row.kaishi_ymd;
            task.shuryoYmd = row.shuryo_ymd;
            task.sagyokuCd = row.sagyoku_cd;
            task.oyaKouteiId = row.oya_koutei_id;
            task.jisshiYmd = row.jisshi_ymd;
            task.kanryoYmd = row.kanryo_ymd;
            task.kouteiPath = row.koutei_path;
            task.root = row.root;

            tasks.push(task);
        }

        return tasks;
    }
};
