package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Prev;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 前世登録
 *
 * @author emarfkrow
 */
public class Tb5PrevRegistAction extends BaseAction {

    /** 前世登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        Tb5Prev e = FormValidator.toBean(Tb5Prev.class.getName(), postJson);

        // 主キーが不足していたらINSERT
        boolean isNew = false;
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getPrevId())) {
            isNew = true;
        }
        // 楽観ロック値がなくてもINSERT
        if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(e.getUpdateTs())) {
            isNew = true;
        }

        if (isNew) {

            if (e.insert(now, execId) != 1) {
                throw new OptLockError("error.cant.insert", "前世");
            }

            //集約先に該当する場合は、集約元に主キーを反映
            String summaryKey1 = postJson.get("Tb5Derive.deriveId").toString();
            if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(summaryKey1)) {
                String[] summaryKeys = summaryKey1.trim().split(",");
                for (String pk : summaryKeys) {
                    com.example.entity.Tb5Derive tb5Derive = com.example.entity.Tb5Derive.get(pk);
                    //集約済みならエラー
                    if (!jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(tb5Derive.getPrevId())) {
                        throw new OptLockError("error.already.summary", "派生");
                    }
                    tb5Derive.setPrevId(e.getPrevId());
                    if (tb5Derive.update(now, execId) != 1) {
                        throw new OptLockError("error.cant.insert", "派生");
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
                throw new OptLockError("error.cant.update", "前世");
            }
        }

        return map;
    }

}
