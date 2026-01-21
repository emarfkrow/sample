package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb2Eldest;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 長兄照会
 *
 * @author emarfkrow
 */
public class Tb2EldestGetAction extends BaseAction {

    /** 長兄照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object broId = postJson.get("broId");
        if (broId == null) {
            broId = postJson.get("Tb2Eldest.broId");
        }
        if (broId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb2Eldest tb2Eldest = Tb2Eldest.get(broId);
            // 兄弟
            tb2Eldest.referTb2Younger();
            tb2Eldest.referTb2Youngest();
            map.put("Tb2Eldest", tb2Eldest);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
