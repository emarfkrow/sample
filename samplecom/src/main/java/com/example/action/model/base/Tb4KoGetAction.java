package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb4Ko;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 子照会
 *
 * @author emarfkrow
 */
public class Tb4KoGetAction extends BaseAction {

    /** 子照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("Tb4Ko.oyaId");
        }
        if (oyaId == null) {
            isAllKey = false;
        }

        Object koBn = postJson.get("koBn");
        if (koBn == null) {
            koBn = postJson.get("Tb4Ko.koBn");
        }
        if (koBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.Tb4Oya tb4Oya = com.example.entity.Tb4Oya.get(oyaId);
        map.put("Tb4Oya", tb4Oya);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb4Ko tb4Ko = Tb4Ko.get(oyaId, koBn);
            // 兄弟
            tb4Ko.referTb4KoDinks();
            tb4Ko.referTb4KoOrphans();
            // 子
            tb4Ko.referTb4Magos();
            map.put("Tb4Ko", tb4Ko);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
