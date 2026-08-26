package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Eldest;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T01_ELDEST照会
 *
 * @author emarfkrow
 */
public class T01EldestGetAction extends BaseAction {

    /** T01_ELDEST照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object broId = form.get("broId");
        if (broId == null) {
            broId = form.get("T01Eldest.broId");
        }
        if (broId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T01Eldest t01Eldest = T01Eldest.get(broId);
            // 兄弟
            t01Eldest.referT01Younger();
            t01Eldest.referT01Youngest();
            map.put("T01Eldest", t01Eldest);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
