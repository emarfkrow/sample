package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb7Sum;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 集約登録
 *
 * @author emarfkrow
 */
public class Tb7SumRegistAction extends BaseAction {

    /** 集約登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        Tb7Sum e = FormValidator.toBean(Tb7Sum.class.getName(), postJson);

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
            String summaryKey1 = postJson.get("Tb7Unit1.unit1Id").toString();
            if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(summaryKey1)) {
                String[] summaryKeys = summaryKey1.trim().split(",");
                for (String pk : summaryKeys) {
                    com.example.entity.Tb7Unit1 tb7Unit1 = com.example.entity.Tb7Unit1.get(pk);
                    //集約済みならエラー
                    if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(tb7Unit1.getSumId())) {
                        throw new OptLockError("error.already.summary", "単位１");
                    }
                    tb7Unit1.setSumId(e.getSumId());
                    if (tb7Unit1.update(now, execId) != 1) {
                        throw new OptLockError("error.cant.insert", "単位１");
                    }
                }
            }

            //集約先に該当する場合は、集約元に主キーを反映
            String summaryKey2 = postJson.get("Tb7Unit2.unit2Id").toString();
            if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(summaryKey2)) {
                String[] summaryKeys = summaryKey2.trim().split(",");
                for (String pk : summaryKeys) {
                    com.example.entity.Tb7Unit2 tb7Unit2 = com.example.entity.Tb7Unit2.get(pk);
                    //集約済みならエラー
                    if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(tb7Unit2.getSumId())) {
                        throw new OptLockError("error.already.summary", "単位２");
                    }
                    tb7Unit2.setSumId(e.getSumId());
                    if (tb7Unit2.update(now, execId) != 1) {
                        throw new OptLockError("error.cant.insert", "単位２");
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
