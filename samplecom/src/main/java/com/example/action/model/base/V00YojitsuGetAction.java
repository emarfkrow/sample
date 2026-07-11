package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.V00Yojitsu;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * VIEW照会
 *
 * @author emarfkrow
 */
public class V00YojitsuGetAction extends BaseAction {

    /** VIEW照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kouteiId = postJson.get("kouteiId");
        if (kouteiId == null) {
            kouteiId = postJson.get("V00Yojitsu.kouteiId");
        }
        if (kouteiId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            V00Yojitsu v00Yojitsu = V00Yojitsu.get(kouteiId);
            map.put("V00Yojitsu", v00Yojitsu);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
