package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrUserPos;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * MHR_USER_POS照会
 *
 * @author emarfkrow
 */
public class MhrUserPosGetAction extends BaseAction {

    /** MHR_USER_POS照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object bushoId = form.get("bushoId");
        if (bushoId == null) {
            bushoId = form.get("MhrUserPos.bushoId");
        }
        if (bushoId == null) {
            isAllKey = false;
        }

        Object shokuiId = form.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = form.get("MhrUserPos.shokuiId");
        }
        if (shokuiId == null) {
            isAllKey = false;
        }

        Object userId = form.get("userId");
        if (userId == null) {
            userId = form.get("MhrUserPos.userId");
        }
        if (userId == null) {
            isAllKey = false;
        }

        Object tekiyoBi = form.get("tekiyoBi");
        if (tekiyoBi == null) {
            tekiyoBi = form.get("MhrUserPos.tekiyoBi");
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
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
