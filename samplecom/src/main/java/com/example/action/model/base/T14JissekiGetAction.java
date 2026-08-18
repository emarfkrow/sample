package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T14Jisseki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T14_JISSEKI照会
 *
 * @author emarfkrow
 */
public class T14JissekiGetAction extends BaseAction {

    /** T14_JISSEKI照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kouteiId = form.get("kouteiId");
        if (kouteiId == null) {
            kouteiId = form.get("T14Jisseki.kouteiId");
        }
        if (kouteiId == null) {
            isAllKey = false;
        }

        Object jissekiBn = form.get("jissekiBn");
        if (jissekiBn == null) {
            jissekiBn = form.get("T14Jisseki.jissekiBn");
        }
        if (jissekiBn == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T14Jisseki t14Jisseki = T14Jisseki.get(kouteiId, jissekiBn);
            map.put("T14Jisseki", t14Jisseki);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
