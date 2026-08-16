package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MsyKadobi;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * MSY_KADOBI照会
 *
 * @author emarfkrow
 */
public class MsyKadobiGetAction extends BaseAction {

    /** MSY_KADOBI照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object kadoYmd = postJson.get("kadoYmd");
        if (kadoYmd == null) {
            kadoYmd = postJson.get("MsyKadobi.kadoYmd");
        }
        if (kadoYmd == null) {
            isAllKey = false;
        }

        Object bushoId = postJson.get("bushoId");
        if (bushoId == null) {
            bushoId = postJson.get("MsyKadobi.bushoId");
        }
        if (bushoId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MsyKadobi msyKadobi = MsyKadobi.get(kadoYmd, bushoId);
            map.put("MsyKadobi", msyKadobi);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
