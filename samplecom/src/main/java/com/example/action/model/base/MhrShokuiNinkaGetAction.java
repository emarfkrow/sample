package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.MhrShokuiNinka;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * MHR_SHOKUI_NINKA照会
 *
 * @author emarfkrow
 */
public class MhrShokuiNinkaGetAction extends BaseAction {

    /** MHR_SHOKUI_NINKA照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object bushoId = form.get("bushoId");
        if (bushoId == null) {
            bushoId = form.get("MhrShokuiNinka.bushoId");
        }
        if (bushoId == null) {
            isAllKey = false;
        }

        Object shokuiId = form.get("shokuiId");
        if (shokuiId == null) {
            shokuiId = form.get("MhrShokuiNinka.shokuiId");
        }
        if (shokuiId == null) {
            isAllKey = false;
        }

        Object tableRe = form.get("tableRe");
        if (tableRe == null) {
            tableRe = form.get("MhrShokuiNinka.tableRe");
        }
        if (tableRe == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            MhrShokuiNinka mhrShokuiNinka = MhrShokuiNinka.get(bushoId, shokuiId, tableRe);
            map.put("MhrShokuiNinka", mhrShokuiNinka);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
