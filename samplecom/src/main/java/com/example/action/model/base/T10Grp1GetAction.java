package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T10Grp1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T10_GRP1照会
 *
 * @author emarfkrow
 */
public class T10Grp1GetAction extends BaseAction {

    /** T10_GRP1照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object grp1Id = postJson.get("grp1Id");
        if (grp1Id == null) {
            grp1Id = postJson.get("T10Grp1.grp1Id");
        }
        if (grp1Id == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T10Grp1 t10Grp1 = T10Grp1.get(grp1Id);
            map.put("T10Grp1", t10Grp1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
