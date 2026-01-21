package com.example.job.B0002;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.golorp.emarf.job.BaseJob;
import jp.co.golorp.emarf.sql.Queries;
import jp.co.golorp.emarf.util.MapList;

/**
 * エンティティEntity 検索バッチ
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

        String sql = this.loadSqlFile("TEntitySearch");
        Map<String, Object> params = new HashMap<String, Object>();
        MapList list = Queries.select(sql, params, null, null);

        LOG.debug(list.toString());
    }

}
