package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T09Sum;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 集約照会
 *
 * @author emarfkrow
 */
public class T09SumGetAction extends BaseAction {

    /** 集約照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object sumId = postJson.get("sumId");
        if (sumId == null) {
            sumId = postJson.get("T09Sum.sumId");
        }
        if (sumId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T09Sum t09Sum = T09Sum.get(sumId);
            // 集約元
            t09Sum.referT09Grp1s();
            t09Sum.referT09Grp2s();
            map.put("T09Sum", t09Sum);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
