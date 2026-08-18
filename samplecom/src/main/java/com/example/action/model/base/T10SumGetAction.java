package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Sum;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T10_SUM照会
 *
 * @author emarfkrow
 */
public class T10SumGetAction extends BaseAction {

    /** T10_SUM照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object sumId = form.get("sumId");
        if (sumId == null) {
            sumId = form.get("T10Sum.sumId");
        }
        if (sumId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T10Sum t10Sum = T10Sum.get(sumId);
            // 集約元
            t10Sum.referT10Grp1s();
            t10Sum.referT10Grp2s();
            map.put("T10Sum", t10Sum);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
