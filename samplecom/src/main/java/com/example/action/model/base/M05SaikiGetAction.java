package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Saiki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * M05_SAIKI照会
 *
 * @author emarfkrow
 */
public class M05SaikiGetAction extends BaseAction {

    /** M05_SAIKI照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object saikiId = form.get("saikiId");
        if (saikiId == null) {
            saikiId = form.get("M05Saiki.saikiId");
        }
        if (saikiId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M05Saiki m05Saiki = M05Saiki.get(saikiId);
            map.put("M05Saiki", m05Saiki);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
