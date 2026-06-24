package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Mago;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 孫照会
 *
 * @author emarfkrow
 */
public class T01MagoGetAction extends BaseAction {

    /** 孫照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("T01Mago.oyaId");
        }
        if (oyaId == null) {
            isAllKey = false;
        }

        Object koBn = postJson.get("koBn");
        if (koBn == null) {
            koBn = postJson.get("T01Mago.koBn");
        }
        if (koBn == null) {
            isAllKey = false;
        }

        Object magoBn = postJson.get("magoBn");
        if (magoBn == null) {
            magoBn = postJson.get("T01Mago.magoBn");
        }
        if (magoBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T01Ko t01Ko = com.example.entity.T01Ko.get(oyaId, koBn);
            map.put("T01Ko", t01Ko);
        } catch (Exception e) {
        }
        try {
            com.example.entity.T01Orphan t01Orphan = com.example.entity.T01Orphan.get(oyaId, koBn);
            map.put("T01Orphan", t01Orphan);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T01Mago t01Mago = T01Mago.get(oyaId, koBn, magoBn);
            map.put("T01Mago", t01Mago);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
