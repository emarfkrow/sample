package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrShokuiNinka;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 認可マスタ照会
 *
 * @author emarfkrow
 */
public class MhrShokuiNinkaGetAction extends BaseAction {

    /** 認可マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object bushoId = postJson.get("bushoId");
        if (bushoId == null) {
            bushoId = postJson.get("MhrShokuiNinka.bushoId");
        }
        if (bushoId == null) {
            isAllKey = false;
        }

        Object shokuiId = postJson.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = postJson.get("MhrShokuiNinka.shokuiId");
        }
        if (shokuiId == null) {
            isAllKey = false;
        }

        Object kinoNm = postJson.get("kinoNm");
        if (kinoNm == null) {
            kinoNm = postJson.get("MhrShokuiNinka.kinoNm");
        }
        if (kinoNm == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MhrShokuiNinka mhrShokuiNinka = MhrShokuiNinka.get(bushoId, shokuiId, kinoNm);
            map.put("MhrShokuiNinka", mhrShokuiNinka);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
