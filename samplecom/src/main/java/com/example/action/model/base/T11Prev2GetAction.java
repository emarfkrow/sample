package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T11Prev2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T11_PREV2照会
 *
 * @author emarfkrow
 */
public class T11Prev2GetAction extends BaseAction {

    /** T11_PREV2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prev2Id = postJson.get("prev2Id");
        if (prev2Id == null) {
            prev2Id = postJson.get("T11Prev2.prev2Id");
        }
        if (prev2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T11Prev2 t11Prev2 = T11Prev2.get(prev2Id);
            // 転生先
            t11Prev2.referT11Reborn2s();
            map.put("T11Prev2", t11Prev2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
