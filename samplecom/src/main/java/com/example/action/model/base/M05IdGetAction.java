package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Id;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * M05_ID照会
 *
 * @author emarfkrow
 */
public class M05IdGetAction extends BaseAction {

    /** M05_ID照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("M05Id.idrefId");
        }
        if (idrefId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M05Id m05Id = M05Id.get(idrefId);
            // 子
            m05Id.referM05Idbns();
            map.put("M05Id", m05Id);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
