package com.example.job.B1000;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jp.co.golorp.emarf.job.BaseJob;
import jp.co.golorp.emarf.report.TextUtil;

/**
 * CSVファイルの出力
 *
 * @author toshiyuki
 *
 */
public class B1001 extends BaseJob {

    //    /**
    //     * logger
    //     */
    //    private static final Logger LOG = LoggerFactory.getLogger(B0004Job.class);

    /**
     * エントリポイント
     *
     * @param args
     */
    public static void main(final String[] args) {
        new B1001().run(args);
    }

    /**
     * 主処理
     *
     * @param now
     * @param jobId
     * @param args
     */
    public void running(final LocalDateTime now, final String jobId, final String[] args) {

        String sql = this.loadSqlFile("B1001");
        Map<String, Object> params = new HashMap<String, Object>();

        TextUtil.csv(sql, params, "out/output_fixed.csv");
        TextUtil.tsv(sql, params, "out/output_fixed.tsv");
        TextUtil.fix(sql, params, "out/output_fixed.dat");

        TextUtil.csv(sql, "out/output_fixed.csv");
        TextUtil.tsv(sql, "out/output_fixed.tsv");
        TextUtil.fix(sql, "out/output_fixed.dat");
    }

}
