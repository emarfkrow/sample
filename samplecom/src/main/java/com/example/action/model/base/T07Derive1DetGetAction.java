package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive1Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T07_DERIVE1_DET照会
 *
 * @author emarfkrow
 */
public class T07Derive1DetGetAction extends BaseAction {

    /** T07_DERIVE1_DET照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive1Id = postJson.get("derive1Id");
        if (derive1Id == null) {
            derive1Id = postJson.get("T07Derive1Det.derive1Id");
        }
        if (derive1Id == null) {
            isAllKey = false;
        }

        Object derive1Bn = postJson.get("derive1Bn");
        if (derive1Bn == null) {
            derive1Bn = postJson.get("T07Derive1Det.derive1Bn");
        }
        if (derive1Bn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T07Derive1 t07Derive1 = com.example.entity.T07Derive1.get(derive1Id);
            map.put("T07Derive1", t07Derive1);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07Derive1Det t07Derive1Det = T07Derive1Det.get(derive1Id, derive1Bn);
            map.put("T07Derive1Det", t07Derive1Det);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
