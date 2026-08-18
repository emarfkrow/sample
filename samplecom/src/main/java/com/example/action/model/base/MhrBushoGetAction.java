package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrBusho;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * MHR_BUSHO照会
 *
 * @author emarfkrow
 */
public class MhrBushoGetAction extends BaseAction {

    /** MHR_BUSHO照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object bushoId = form.get("bushoId");
        if (bushoId == null) {
            bushoId = form.get("MhrBusho.bushoId");
        }
        if (bushoId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MhrBusho mhrBusho = MhrBusho.get(bushoId);
            map.put("MhrBusho", mhrBusho);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
