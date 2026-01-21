package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrUserPos;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 所属マスタ照会
 *
 * @author emarfkrow
 */
public class MhrUserPosGetAction extends BaseAction {

    /** 所属マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object bushoId = postJson.get("bushoId");
        if (bushoId == null) {
            bushoId = postJson.get("MhrUserPos.bushoId");
        }
        if (bushoId == null) {
            isAllKey = false;
        }

        Object shokuiId = postJson.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = postJson.get("MhrUserPos.shokuiId");
        }
        if (shokuiId == null) {
            isAllKey = false;
        }

        Object userId = postJson.get("userId");
        if (userId == null) {
            userId = postJson.get("MhrUserPos.userId");
        }
        if (userId == null) {
            isAllKey = false;
        }

        Object tekiyoBi = postJson.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = postJson.get("MhrUserPos.tekiyoBi");
        }
        if (tekiyoBi == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MhrUserPos mhrUserPos = MhrUserPos.get(bushoId, shokuiId, userId, tekiyoBi);
            map.put("MhrUserPos", mhrUserPos);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
