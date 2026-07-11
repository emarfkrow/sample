package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Derive2Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T06_DERIVE2_DET照会
 *
 * @author emarfkrow
 */
public class T06Derive2DetGetAction extends BaseAction {

    /** T06_DERIVE2_DET照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive2Id = postJson.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = postJson.get("T06Derive2Det.derive2Id");
        }
        if (derive2Id == null) {
            isAllKey = false;
        }

        Object derive2Bn = postJson.get("derive2Bn");
        if (derive2Bn == null) {
            derive2Bn = postJson.get("T06Derive2Det.derive2Bn");
        }
        if (derive2Bn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T06Derive2 t06Derive2 = com.example.entity.T06Derive2.get(derive2Id);
            map.put("T06Derive2", t06Derive2);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06Derive2Det t06Derive2Det = T06Derive2Det.get(derive2Id, derive2Bn);
            map.put("T06Derive2Det", t06Derive2Det);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
