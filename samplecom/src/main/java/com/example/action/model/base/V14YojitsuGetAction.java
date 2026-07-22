package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.V14Yojitsu;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * V14_YOJITSU照会
 *
 * @author emarfkrow
 */
public class V14YojitsuGetAction extends BaseAction {

    /** V14_YOJITSU照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kouteiId = postJson.get("kouteiId");
        if (kouteiId == null) {
            kouteiId = postJson.get("V14Yojitsu.kouteiId");
        }
        if (kouteiId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            V14Yojitsu v14Yojitsu = V14Yojitsu.get(kouteiId);
            map.put("V14Yojitsu", v14Yojitsu);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
