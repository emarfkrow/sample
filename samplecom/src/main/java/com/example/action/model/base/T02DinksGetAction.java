package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Dinks;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T02_DINKS照会
 *
 * @author emarfkrow
 */
public class T02DinksGetAction extends BaseAction {

    /** T02_DINKS照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("T02Dinks.oyaId");
        }
        if (oyaId == null) {
            isAllKey = false;
        }

        Object koBn = postJson.get("koBn");
        if (koBn == null) {
            koBn = postJson.get("T02Dinks.koBn");
        }
        if (koBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T02Oya t02Oya = com.example.entity.T02Oya.get(oyaId);
            map.put("T02Oya", t02Oya);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T02Dinks t02Dinks = T02Dinks.get(oyaId, koBn);
            // 兄弟
            t02Dinks.referT02Ko();
            t02Dinks.referT02Orphan();
            // 子
            t02Dinks.referT02Magos();
            map.put("T02Dinks", t02Dinks);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
