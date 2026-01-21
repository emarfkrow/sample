package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Prev2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 前世２照会
 *
 * @author emarfkrow
 */
public class Tb8Prev2GetAction extends BaseAction {

    /** 前世２照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prev2Id = postJson.get("prev2Id");
        if (prev2Id == null) {
            prev2Id = postJson.get("Tb8Prev2.prev2Id");
        }
        if (prev2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb8Prev2 tb8Prev2 = Tb8Prev2.get(prev2Id);
            // 転生先
            tb8Prev2.referTb8Sum2s();
            map.put("Tb8Prev2", tb8Prev2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
