package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T09Grp2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T09_GRP2照会
 *
 * @author emarfkrow
 */
public class T09Grp2GetAction extends BaseAction {

    /** T09_GRP2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object grp2Id = postJson.get("grp2Id");
        if (grp2Id == null) {
            grp2Id = postJson.get("T09Grp2.grp2Id");
        }
        if (grp2Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T09Grp2 t09Grp2 = T09Grp2.get(grp2Id);
            map.put("T09Grp2", t09Grp2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
