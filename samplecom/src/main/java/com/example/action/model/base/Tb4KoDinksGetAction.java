package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb4KoDinks;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 子なし照会
 *
 * @author emarfkrow
 */
public class Tb4KoDinksGetAction extends BaseAction {

    /** 子なし照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object oyaId = postJson.get("oyaId");
        if (oyaId == null) {
            oyaId = postJson.get("Tb4KoDinks.oyaId");
        }
        if (oyaId == null) {
            isAllKey = false;
        }

        Object koBn = postJson.get("koBn");
        if (koBn == null) {
            koBn = postJson.get("Tb4KoDinks.koBn");
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
            Tb4KoDinks tb4KoDinks = Tb4KoDinks.get(oyaId, koBn);
            // 兄弟
            tb4KoDinks.referTb4Ko();
            tb4KoDinks.referTb4KoOrphans();
            map.put("Tb4KoDinks", tb4KoDinks);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
