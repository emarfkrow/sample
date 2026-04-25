package com.example.job.B0000.B0002;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.entity.T01Oya;

import jp.co.golorp.emarf.exception.AppError;
import jp.co.golorp.emarf.job.BaseJob;
import jp.co.golorp.emarf.sql.Queries;
import jp.co.golorp.emarf.util.MapList;

/**
 * クラスパス内SQLの発行
 *
 * @author toshiyuki
 *
 */
public class B0002Job extends BaseJob {

    /**
     * logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(B0002Job.class);

    /**
     * エントリポイント
     *
     * @param args
     */
    public static void main(final String[] args) {
        new B0002Job().run(args);
    }

    /**
     * 主処理
     *
     * @param now
     * @param jobId
     * @param args
     */
    public void running(final LocalDateTime now, final String jobId, final String[] args) {

        // 追加
        T01Oya e = new T01Oya();
        e.setOyaInfo("親情報");
        if (e.insert(now, jobId) != 1) {
            throw new AppError("error.cant.insert");
        }

        String sql = this.loadSqlFile("T01OyaSearch");
        Map<String, Object> params = new HashMap<String, Object>();
        MapList list = Queries.select(sql, params, null, null);

        LOG.debug("T01_OYA:");
        for (Map<String, Object> map : list) {
            LOG.debug(map.toString());
        }
    }

}
