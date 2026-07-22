package com.example.job.B0000;

import java.time.LocalDateTime;

import com.example.entity.T02Foster;

import jp.co.golorp.emarf.job.BaseJob;
import jp.co.golorp.emarf.sql.Connections;

/**
 * Entityの、追加・照会・更新・削除
 *
 * @author toshiyuki
 *
 */
public class B0004 extends BaseJob {

    //    /**
    //     * logger
    //     */
    //    private static final Logger LOG = LoggerFactory.getLogger(B0004.class);

    /**
     * エントリポイント
     *
     * @param args
     */
    public static void main(final String[] args) {
        new B0004().run(args);
    }

    /**
     * 主処理
     *
     * @param now
     * @param jobId
     * @param args
     */
    public void running(final LocalDateTime now, final String jobId, final String[] args) {

        T02Foster.truncate();

        for (int i = 0; i < 10000; i++) {
            T02Foster e = new T02Foster();
            e.setFosterInfo(jobId);
            e.insert(now, jobId);
            if ((i + 1) % 1000 == 0) {
                Connections.commit();
            }
        }
    }

}
