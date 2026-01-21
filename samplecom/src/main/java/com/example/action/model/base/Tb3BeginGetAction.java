package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb3Begin;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 当初照会
 *
 * @author emarfkrow
 */
public class Tb3BeginGetAction extends BaseAction {

    /** 当初照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object beginId = postJson.get("beginId");
        if (beginId == null) {
            beginId = postJson.get("Tb3Begin.beginId");
        }
        if (beginId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb3Begin tb3Begin = Tb3Begin.get(beginId);
            map.put("Tb3Begin", tb3Begin);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
