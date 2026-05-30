package com.example.job.B0000.B0006;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.job.B0000.B0004.B0004Job;

import jp.co.golorp.emarf.job.BaseJob;
import jp.co.golorp.emarf.report.PdfUtil;
import jp.co.golorp.emarf.report.XlsxUtil;
import jp.co.golorp.emarf.sql.Queries;
import jp.co.golorp.emarf.util.MapList;

/**
 * CSVファイルの出力
 *
 * @author toshiyuki
 *
 */
public class B0006Job extends BaseJob {

    /**
     * logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(B0004Job.class);

    /**
     * エントリポイント
     *
     * @param args
     */
    public static void main(final String[] args) {
        new B0006Job().run(args);
    }

    /**
     * 主処理
     *
     * @param now
     * @param jobId
     * @param args
     */
    public void running(final LocalDateTime now, final String jobId, final String[] args) {

        String sql = this.loadSqlFile("B0004");
        Map<String, Object> params = new HashMap<String, Object>();

        List<String> pathes = new ArrayList<String>();
        pathes.add("D0000");
        String layoutFileName = "D0001Search.xlsx";
        Map<String, Map<String, Map<String, Object>>> layoutSheetMap = new HashMap<String, Map<String, Map<String, Object>>>();
        Map<String, Map<String, Object>> layoutSheetMap2 = new HashMap<String, Map<String, Object>>();
        layoutSheetMap.put("layout", layoutSheetMap2);
        Map<String, Object> layoutSheetMap3 = new HashMap<String, Object>();
        layoutSheetMap2.put("D0001Search", layoutSheetMap3);
        MapList layoutSheetMap4 = Queries.select(sql, params, null, null);
        layoutSheetMap3.put("D0001Search", layoutSheetMap4);
        String baseMei = "検索画面タイトル";

        String tempFilePath = XlsxUtil.getGeneratedPath(pathes, layoutFileName, layoutSheetMap, baseMei);
        String pdfPath = PdfUtil.byXlsx(tempFilePath);

        LOG.info("pdfPath: " + pdfPath);
    }

}
