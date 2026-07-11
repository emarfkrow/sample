package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Koho1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T10_KOHO1照会
 *
 * @author emarfkrow
 */
public class T10Koho1GetAction extends BaseAction {

    /** T10_KOHO1照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object koho1Id = postJson.get("koho1Id");
        if (koho1Id == null) {
            koho1Id = postJson.get("T10Koho1.koho1Id");
        }
        if (koho1Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T10Koho1 t10Koho1 = T10Koho1.get(koho1Id);
            map.put("T10Koho1", t10Koho1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
