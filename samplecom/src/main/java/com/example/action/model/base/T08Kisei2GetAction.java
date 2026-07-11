package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T08Kisei2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T08_KISEI2照会
 *
 * @author emarfkrow
 */
public class T08Kisei2GetAction extends BaseAction {

    /** T08_KISEI2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kisei2Id = postJson.get("kisei2Id");
        if (kisei2Id == null) {
            kisei2Id = postJson.get("T08Kisei2.kisei2Id");
        }
        if (kisei2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T08Kisei2 t08Kisei2 = T08Kisei2.get(kisei2Id);
            map.put("T08Kisei2", t08Kisei2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
