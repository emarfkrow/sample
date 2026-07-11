package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Jisseki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T00_JISSEKI照会
 *
 * @author emarfkrow
 */
public class T00JissekiGetAction extends BaseAction {

    /** T00_JISSEKI照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kouteiId = postJson.get("kouteiId");
        if (kouteiId == null) {
            kouteiId = postJson.get("T00Jisseki.kouteiId");
        }
        if (kouteiId == null) {
            isAllKey = false;
        }

        Object jissekiBn = postJson.get("jissekiBn");
        if (jissekiBn == null) {
            jissekiBn = postJson.get("T00Jisseki.jissekiBn");
        }
        if (jissekiBn == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T00Jisseki t00Jisseki = T00Jisseki.get(kouteiId, jissekiBn);
            map.put("T00Jisseki", t00Jisseki);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
