package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Sum3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 集約３照会
 *
 * @author emarfkrow
 */
public class Tb8Sum3GetAction extends BaseAction {

    /** 集約３照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object sum3Id = postJson.get("sum3Id");
        if (sum3Id == null) {
            sum3Id = postJson.get("Tb8Sum3.sum3Id");
        }
        if (sum3Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb8Sum3 tb8Sum3 = Tb8Sum3.get(sum3Id);
            // 集約元
            tb8Sum3.referTb8Unit4s();
            map.put("Tb8Sum3", tb8Sum3);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
