package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T02_OYA照会
 *
 * @author emarfkrow
 */
public class T02OyaGetAction extends BaseAction {

    /** T02_OYA照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object oyaId = form.get("oyaId");
        if (oyaId == null) {
            oyaId = form.get("T02Oya.oyaId");
        }
        if (oyaId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T02Oya t02Oya = T02Oya.get(oyaId);
            // 子
            t02Oya.referT02Dinkss();
            t02Oya.referT02Kos();
            t02Oya.referT02Orphans();
            map.put("T02Oya", t02Oya);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
