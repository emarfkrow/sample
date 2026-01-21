package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb7Unit2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 単位２照会
 *
 * @author emarfkrow
 */
public class Tb7Unit2GetAction extends BaseAction {

    /** 単位２照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object unit2Id = postJson.get("unit2Id");
        if (unit2Id == null) {
            unit2Id = postJson.get("Tb7Unit2.unit2Id");
        }
        if (unit2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb7Unit2 tb7Unit2 = Tb7Unit2.get(unit2Id);
            map.put("Tb7Unit2", tb7Unit2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
