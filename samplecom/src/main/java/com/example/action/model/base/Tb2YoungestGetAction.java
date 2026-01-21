package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb2Youngest;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 末弟照会
 *
 * @author emarfkrow
 */
public class Tb2YoungestGetAction extends BaseAction {

    /** 末弟照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object broId = postJson.get("broId");
        if (broId == null) {
            broId = postJson.get("Tb2Youngest.broId");
        }
        if (broId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb2Youngest tb2Youngest = Tb2Youngest.get(broId);
            map.put("Tb2Youngest", tb2Youngest);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
