package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Refer2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 参照２マスタ照会
 *
 * @author emarfkrow
 */
public class Tb1Refer2GetAction extends BaseAction {

    /** 参照２マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object refer2Id = postJson.get("refer2Id");
        if (refer2Id == null) {
            refer2Id = postJson.get("Tb1Refer2.refer2Id");
        }
        if (refer2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Refer2 tb1Refer2 = Tb1Refer2.get(refer2Id);
            map.put("Tb1Refer2", tb1Refer2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
