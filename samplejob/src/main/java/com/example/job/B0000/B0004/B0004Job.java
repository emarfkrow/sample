package com.example.job.B0000.B0004;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import jp.co.golorp.emarf.exception.SysError;
import jp.co.golorp.emarf.job.BaseJob;
import jp.co.golorp.emarf.sql.Queries;
import jp.co.golorp.emarf.util.MapList;

/**
 * CSVファイルの出力
 *
 * @author toshiyuki
 *
 */
public class B0004Job extends BaseJob {

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
        new B0004Job().run(args);
    }

    /**
     * 主処理
     *
     * @param now
     * @param jobId
     * @param args
     */
    public void running(final LocalDateTime now, final String jobId, final String[] args) {

        // 外部SQLファイルでデータ取得
        String sql = this.loadSqlFile("B0004");
        Map<String, Object> params = new HashMap<String, Object>();
        MapList list = Queries.select(sql, params, null, null);

        String csvPath = "output_fixed.csv";

        CsvSchema schema = CsvSchema.builder()
                .addColumn("OYA_ID")
                .addColumn("OYA_INFO")
                .build()
                .withHeader();

        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        try {
            mapper.writer(schema).writeValue(new File(csvPath), list);
        } catch (IOException e1) {
            throw new SysError(e1);
        }
    }

}
