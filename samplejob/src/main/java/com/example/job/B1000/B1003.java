package com.example.job.B1000;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.job.BaseJob;
import jp.co.golorp.emarf.report.PdfUtil;
import jp.co.golorp.emarf.report.XlsxUtil;
import jp.co.golorp.emarf.sql.Queries;
import jp.co.golorp.emarf.util.MapList;

/**
 * XLS/PDFファイルの出力
 *
 * @author toshiyuki
 *
 */
public class B1003 extends BaseJob {

    /**
     * logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(B1003.class);

    /**
     * エントリポイント
     *
     * @param args
     */
    public static void main(final String[] args) {
        new B1003().run(args);
    }

    /**
     * 主処理
     *
     * @param now
     * @param jobId
     * @param args
     */
    public void running(final LocalDateTime now, final String jobId, final String[] args) {

        // データ取得
        String sql = this.loadSqlFile("B1003");
        Map<String, Object> params = new HashMap<String, Object>();
        MapList data = Queries.select(sql, params, null, null);

        // シート内のどのデータか（ヘッダ・明細）
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("DataName", data);

        // ブック内のシート名
        Map<String, Map<String, Object>> destSheetMap = new HashMap<String, Map<String, Object>>();
        destSheetMap.put("DestSheetName", dataMap);

        // 複製元のシート名
        Map<String, Map<String, Map<String, Object>>> srcSheetMap = new HashMap<String, Map<String, Map<String, Object>>>();
        srcSheetMap.put("layout", destSheetMap);

        // エクセルファイル出力
        List<String> pathes = new ArrayList<String>();
        pathes.add("D0000");
        String layoutFileName = "D0001Search.xlsx";
        String baseMei = "検索画面タイトル";
        String tempFilePath = XlsxUtil.getGeneratedPath(pathes, layoutFileName, srcSheetMap, baseMei);

        // PDFに変換
        String pdfPath = PdfUtil.byXlsx(tempFilePath);
        LOG.info("pdfPath: " + pdfPath);
    }

}
