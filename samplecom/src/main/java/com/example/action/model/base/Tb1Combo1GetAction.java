package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Combo1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 複合１照会
 *
 * @author emarfkrow
 */
public class Tb1Combo1GetAction extends BaseAction {

    /** 複合１照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object refer1Id = postJson.get("refer1Id");
        if (refer1Id == null) {
            refer1Id = postJson.get("Tb1Combo1.refer1Id");
        }
        if (refer1Id == null) {
            isAllKey = false;
        }

        Object refer2Id = postJson.get("refer2Id");
        if (refer2Id == null) {
            refer2Id = postJson.get("Tb1Combo1.refer2Id");
        }
        if (refer2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Combo1 tb1Combo1 = Tb1Combo1.get(refer1Id, refer2Id);
            // 子
            tb1Combo1.referTb1Combo2s();
            map.put("Tb1Combo1", tb1Combo1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
