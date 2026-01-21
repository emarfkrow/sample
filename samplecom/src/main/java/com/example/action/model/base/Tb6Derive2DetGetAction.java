package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Derive2Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 派生２明細照会
 *
 * @author emarfkrow
 */
public class Tb6Derive2DetGetAction extends BaseAction {

    /** 派生２明細照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive2Id = postJson.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = postJson.get("Tb6Derive2Det.derive2Id");
        }
        if (derive2Id == null) {
            isAllKey = false;
        }

        Object derive2Bn = postJson.get("derive2Bn");
        if (derive2Bn == null) {
            derive2Bn = postJson.get("Tb6Derive2Det.derive2Bn");
        }
        if (derive2Bn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.Tb6Derive2 tb6Derive2 = com.example.entity.Tb6Derive2.get(derive2Id);
        map.put("Tb6Derive2", tb6Derive2);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6Derive2Det tb6Derive2Det = Tb6Derive2Det.get(derive2Id, derive2Bn);
            map.put("Tb6Derive2Det", tb6Derive2Det);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
