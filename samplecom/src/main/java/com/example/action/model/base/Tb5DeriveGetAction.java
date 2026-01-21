package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Derive;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 派生照会
 *
 * @author emarfkrow
 */
public class Tb5DeriveGetAction extends BaseAction {

    /** 派生照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object deriveId = postJson.get("deriveId");
        if (deriveId == null) {
            deriveId = postJson.get("Tb5Derive.deriveId");
        }
        if (deriveId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb5Derive tb5Derive = Tb5Derive.get(deriveId);
            map.put("Tb5Derive", tb5Derive);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
