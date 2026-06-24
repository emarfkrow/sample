package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Derive1Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 派生１明細照会
 *
 * @author emarfkrow
 */
public class T06Derive1DetGetAction extends BaseAction {

    /** 派生１明細照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive1Id = postJson.get("derive1Id");
        if (derive1Id == null) {
            derive1Id = postJson.get("T06Derive1Det.derive1Id");
        }
        if (derive1Id == null) {
            isAllKey = false;
        }

        Object derive1Bn = postJson.get("derive1Bn");
        if (derive1Bn == null) {
            derive1Bn = postJson.get("T06Derive1Det.derive1Bn");
        }
        if (derive1Bn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T06Derive1 t06Derive1 = com.example.entity.T06Derive1.get(derive1Id);
            map.put("T06Derive1", t06Derive1);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06Derive1Det t06Derive1Det = T06Derive1Det.get(derive1Id, derive1Bn);
            map.put("T06Derive1Det", t06Derive1Det);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
