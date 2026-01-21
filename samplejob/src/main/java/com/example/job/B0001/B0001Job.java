package com.example.job.B0001;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.entity.Tb4Ko;

import jp.co.golorp.emarf.exception.AppError;
import jp.co.golorp.emarf.job.BaseJob;

/**
 * エンティティEntity 追加・照会・更新・削除バッチ
 *
 * @author toshiyuki
 *
 */
public class B0001Job extends BaseJob {

    /**
     * logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(B0001Job.class);

    /**
     * エントリポイント
     *
     * @param args
     */
    public static void main(final String[] args) {
        new B0001Job().run(args);
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
        Tb4Ko tKo = new Tb4Ko();
        tKo.setOyaId(1);
        tKo.setKoBn(1);
        tKo.setKoInfo("子追加");
        if (tKo.insert(now, jobId) != 1) {
            throw new AppError("error.cant.insert");
        }

        // 照会
        tKo = Tb4Ko.get(1, 1);
        tKo.getTb4Magos();
        LOG.debug(tKo.toString());

        // 更新
        tKo.setKoInfo("子更新");
        if (tKo.update(now, jobId) != 1) {
            throw new AppError("error.cant.update");
        }

        // 削除
        if (tKo.delete() != 1) {
            throw new AppError("error.cant.delete");
        }

    }

}
