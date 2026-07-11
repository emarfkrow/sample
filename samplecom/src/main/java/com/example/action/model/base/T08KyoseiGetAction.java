package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T08Kyosei;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T08_KYOSEI照会
 *
 * @author emarfkrow
 */
public class T08KyoseiGetAction extends BaseAction {

    /** T08_KYOSEI照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kyoseiId = postJson.get("kyoseiId");
        if (kyoseiId == null) {
            kyoseiId = postJson.get("T08Kyosei.kyoseiId");
        }
        if (kyoseiId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T08Kyosei t08Kyosei = T08Kyosei.get(kyoseiId);
            map.put("T08Kyosei", t08Kyosei);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
