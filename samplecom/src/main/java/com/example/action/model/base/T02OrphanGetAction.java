package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Orphan;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T02_ORPHAN照会
 *
 * @author emarfkrow
 */
public class T02OrphanGetAction extends BaseAction {

    /** T02_ORPHAN照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object oyaId = form.get("oyaId");
        if (oyaId == null) {
            oyaId = form.get("T02Orphan.oyaId");
        }
        if (oyaId == null) {
            isAllKey = false;
        }

        Object koBn = form.get("koBn");
        if (koBn == null) {
            koBn = form.get("T02Orphan.koBn");
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
            T02Orphan t02Orphan = T02Orphan.get(oyaId, koBn);
            // 兄弟
            t02Orphan.referT02Dinks();
            t02Orphan.referT02Ko();
            // 子
            t02Orphan.referT02Magos();
            map.put("T02Orphan", t02Orphan);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
