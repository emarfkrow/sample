package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Mago;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T02_MAGO照会
 *
 * @author emarfkrow
 */
public class T02MagoGetAction extends BaseAction {

    /** T02_MAGO照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object oyaId = form.get("oyaId");
        if (oyaId == null) {
            oyaId = form.get("T02Mago.oyaId");
        }
        if (oyaId == null) {
            isAllKey = false;
        }

        Object koBn = form.get("koBn");
        if (koBn == null) {
            koBn = form.get("T02Mago.koBn");
        }
        if (koBn == null) {
            isAllKey = false;
        }

        Object magoBn = form.get("magoBn");
        if (magoBn == null) {
            magoBn = form.get("T02Mago.magoBn");
        }
        if (magoBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T02Dinks t02Dinks = com.example.entity.T02Dinks.get(oyaId, koBn);
            map.put("T02Dinks", t02Dinks);
        } catch (Exception e) {
        }
        try {
            com.example.entity.T02Ko t02Ko = com.example.entity.T02Ko.get(oyaId, koBn);
            map.put("T02Ko", t02Ko);
        } catch (Exception e) {
        }
        try {
            com.example.entity.T02Orphan t02Orphan = com.example.entity.T02Orphan.get(oyaId, koBn);
            map.put("T02Orphan", t02Orphan);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T02Mago t02Mago = T02Mago.get(oyaId, koBn, magoBn);
            map.put("T02Mago", t02Mago);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
