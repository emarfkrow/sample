package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T09Koho2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T09_KOHO2照会
 *
 * @author emarfkrow
 */
public class T09Koho2GetAction extends BaseAction {

    /** T09_KOHO2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object koho2Id = form.get("koho2Id");
        if (koho2Id == null) {
            koho2Id = form.get("T09Koho2.koho2Id");
        }
        if (koho2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T09Koho2 t09Koho2 = T09Koho2.get(koho2Id);
            map.put("T09Koho2", t09Koho2);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
