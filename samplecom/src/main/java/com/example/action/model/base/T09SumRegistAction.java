package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T09Sum;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集約登録
 *
 * @author emarfkrow
 */
public class T09SumRegistAction extends BaseAction {

    /** 集約登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        T09Sum e = FormValidator.toBean(T09Sum.class.getName(), postJson);

        // 主キーが不足していたらINSERT
        boolean isNew = false;
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getSumId())) {
            isNew = true;
        }
        // 楽観ロック値がなくてもINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getUpdateTs())) {
            isNew = true;
        }

        if (isNew) {

            if (e.insert(now, execId) != 1) {
                throw new OptLockError("error.cant.insert", "集約");
            }

            //集約先に該当する場合は、集約元に主キーを反映
            String summaryKey1 = postJson.get("T09Grp1.grp1Id").toString();
            if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(summaryKey1)) {
                String[] summaryKeys = summaryKey1.trim().split(",");
                for (String pk : summaryKeys) {
                    com.example.entity.T09Grp1 t09Grp1 = com.example.entity.T09Grp1.get(pk);
                    //集約済みならエラー
                    if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(t09Grp1.getSumId())) {
                        throw new OptLockError("error.already.summary", "集団１");
                    }
                    t09Grp1.setSumId(e.getSumId());
                    if (t09Grp1.update(now, execId) != 1) {
                        throw new OptLockError("error.cant.insert", "集団１");
                    }
                }
            }

            //集約先に該当する場合は、集約元に主キーを反映
            String summaryKey2 = postJson.get("T09Grp2.grp2Id").toString();
            if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(summaryKey2)) {
                String[] summaryKeys = summaryKey2.trim().split(",");
                for (String pk : summaryKeys) {
                    com.example.entity.T09Grp2 t09Grp2 = com.example.entity.T09Grp2.get(pk);
                    //集約済みならエラー
                    if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(t09Grp2.getSumId())) {
                        throw new OptLockError("error.already.summary", "集団２");
                    }
                    t09Grp2.setSumId(e.getSumId());
                    if (t09Grp2.update(now, execId) != 1) {
                        throw new OptLockError("error.cant.insert", "集団２");
                    }
                }
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(now, execId) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(now, execId) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "集約");
            }
        }

        return map;
    }

}
