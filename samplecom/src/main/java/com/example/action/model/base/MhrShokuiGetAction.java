package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrShokui;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * MHR_SHOKUI照会
 *
 * @author emarfkrow
 */
public class MhrShokuiGetAction extends BaseAction {

    /** MHR_SHOKUI照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object shokuiId = form.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = form.get("MhrShokui.shokuiId");
        }
        if (shokuiId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MhrShokui mhrShokui = MhrShokui.get(shokuiId);
            map.put("MhrShokui", mhrShokui);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
