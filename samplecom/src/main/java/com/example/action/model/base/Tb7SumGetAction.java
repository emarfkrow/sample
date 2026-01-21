package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb7Sum;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 集約照会
 *
 * @author emarfkrow
 */
public class Tb7SumGetAction extends BaseAction {

    /** 集約照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object sumId = postJson.get("sumId");
        if (sumId == null) {
            sumId = postJson.get("Tb7Sum.sumId");
        }
        if (sumId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb7Sum tb7Sum = Tb7Sum.get(sumId);
            // 集約元
            tb7Sum.referTb7Unit1s();
            tb7Sum.referTb7Unit2s();
            map.put("Tb7Sum", tb7Sum);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
