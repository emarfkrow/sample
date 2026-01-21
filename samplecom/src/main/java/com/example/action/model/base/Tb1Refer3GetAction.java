package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Refer3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 参照３マスタ照会
 *
 * @author emarfkrow
 */
public class Tb1Refer3GetAction extends BaseAction {

    /** 参照３マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object refer3Id = postJson.get("refer3Id");
        if (refer3Id == null) {
            refer3Id = postJson.get("Tb1Refer3.refer3Id");
        }
        if (refer3Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Refer3 tb1Refer3 = Tb1Refer3.get(refer3Id);
            map.put("Tb1Refer3", tb1Refer3);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
