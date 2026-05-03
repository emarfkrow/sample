package com.example.job.B0000.B0005;

import java.time.LocalDateTime;

import com.example.entity.T01Oya;

import jp.co.golorp.emarf.job.BaseJob;
import jp.co.golorp.emarf.report.TextUtil;

/**
 * CSVファイルの入力
 *
 * @author toshiyuki
 *
 */
public class B0005Job extends BaseJob {

    //    /**
    //     * logger
    //     */
    //    private static final Logger LOG = LoggerFactory.getLogger(B0005Job.class);

    /**
     * エントリポイント
     *
     * @param args
     */
    public static void main(final String[] args) {
        new B0005Job().run(args);
    }

    /**
     * 主処理
     *
     * @param now
     * @param jobId
     * @param args
     */
    public void running(final LocalDateTime now, final String jobId, final String[] args) {
        TextUtil.in(now, jobId, "out/output_fixed.csv", true, T01Oya.class);
    }

}
