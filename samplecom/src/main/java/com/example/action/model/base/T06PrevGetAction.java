package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Prev;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T06_PREV照会
 *
 * @author emarfkrow
 */
public class T06PrevGetAction extends BaseAction {

    /** T06_PREV照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prevId = form.get("prevId");
        if (prevId == null) {
            prevId = form.get("T06Prev.prevId");
        }
        if (prevId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06Prev t06Prev = T06Prev.get(prevId);
            // 子
            t06Prev.referT06PrevDets();
            // 転生先
            t06Prev.referT06Reborns();
            map.put("T06Prev", t06Prev);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
