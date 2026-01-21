package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Refer1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 参照１マスタ照会
 *
 * @author emarfkrow
 */
public class Tb1Refer1GetAction extends BaseAction {

    /** 参照１マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object refer1Id = postJson.get("refer1Id");
        if (refer1Id == null) {
            refer1Id = postJson.get("Tb1Refer1.refer1Id");
        }
        if (refer1Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Refer1 tb1Refer1 = Tb1Refer1.get(refer1Id);
            map.put("Tb1Refer1", tb1Refer1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
