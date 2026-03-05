package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Unique;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * ユニークキー照会
 *
 * @author emarfkrow
 */
public class T00UniqueGetAction extends BaseAction {

    /** ユニークキー照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object dMei = postJson.get("dMei");
        if (dMei == null) {
            dMei = postJson.get("T00Unique.dMei");
        }
        if (dMei == null) {
            isAllKey = false;
        }

        Object eMei = postJson.get("eMei");
        if (eMei == null) {
            eMei = postJson.get("T00Unique.eMei");
        }
        if (eMei == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T00Unique t00Unique = T00Unique.get(dMei, eMei);
            map.put("T00Unique", t00Unique);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
