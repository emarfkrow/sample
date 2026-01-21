package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb7Unit1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 単位１照会
 *
 * @author emarfkrow
 */
public class Tb7Unit1GetAction extends BaseAction {

    /** 単位１照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object unit1Id = postJson.get("unit1Id");
        if (unit1Id == null) {
            unit1Id = postJson.get("Tb7Unit1.unit1Id");
        }
        if (unit1Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb7Unit1 tb7Unit1 = Tb7Unit1.get(unit1Id);
            map.put("Tb7Unit1", tb7Unit1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
