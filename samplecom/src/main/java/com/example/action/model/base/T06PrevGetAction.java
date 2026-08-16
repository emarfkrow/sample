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
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prevId = postJson.get("prevId");
        if (prevId == null) {
            prevId = postJson.get("T06Prev.prevId");
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
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
