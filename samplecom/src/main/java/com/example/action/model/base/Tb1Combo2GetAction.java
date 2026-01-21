package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Combo2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 複合２照会
 *
 * @author emarfkrow
 */
public class Tb1Combo2GetAction extends BaseAction {

    /** 複合２照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object refer1Id = postJson.get("refer1Id");
        if (refer1Id == null) {
            refer1Id = postJson.get("Tb1Combo2.refer1Id");
        }
        if (refer1Id == null) {
            isAllKey = false;
        }

        Object refer2Id = postJson.get("refer2Id");
        if (refer2Id == null) {
            refer2Id = postJson.get("Tb1Combo2.refer2Id");
        }
        if (refer2Id == null) {
            isAllKey = false;
        }

        Object refer3Id = postJson.get("refer3Id");
        if (refer3Id == null) {
            refer3Id = postJson.get("Tb1Combo2.refer3Id");
        }
        if (refer3Id == null) {
            isAllKey = false;
        }

        Object tekiyoBi = postJson.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = postJson.get("Tb1Combo2.tekiyoBi");
        }
        if (tekiyoBi == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.Tb1Combo1 tb1Combo1 = com.example.entity.Tb1Combo1.get(refer1Id, refer2Id);
        map.put("Tb1Combo1", tb1Combo1);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Combo2 tb1Combo2 = Tb1Combo2.get(refer1Id, refer2Id, refer3Id, tekiyoBi);
            map.put("Tb1Combo2", tb1Combo2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
