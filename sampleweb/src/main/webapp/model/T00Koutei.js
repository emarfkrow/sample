/**
 * 工程表ガント定義
 */

let T00KouteiGanttTasks = {

    hoge: function(data) {

        let tasks = [];

        for (let r in data) {
            let row = data[r];

            let task = {};
            task.id = row.KOUTEI_ID;
            task.name = row.KOUTEI_MEI;
            task.start = row.KAISHI_BI;
            task.end = row.SHURYO_BI;
            task.dependencies = row.OYA_KOUTEI_ID ? row.OYA_KOUTEI_ID + '' : '';

            tasks.push(task);
        }

        return tasks;
    }
};
