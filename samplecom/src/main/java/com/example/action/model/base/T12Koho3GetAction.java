package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T12Koho3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T12_KOHO3照会
 *
 * @author emarfkrow
 */
public class T12Koho3GetAction extends BaseAction {

    /** T12_KOHO3照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object koho3Id = postJson.get("koho3Id");
        if (koho3Id == null) {
            koho3Id = postJson.get("T12Koho3.koho3Id");
        }
        if (koho3Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T12Koho3 t12Koho3 = T12Koho3.get(koho3Id);
            map.put("T12Koho3", t12Koho3);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
