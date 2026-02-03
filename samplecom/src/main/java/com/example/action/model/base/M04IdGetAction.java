package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Id;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * IDマスタ照会
 *
 * @author emarfkrow
 */
public class M04IdGetAction extends BaseAction {

    /** IDマスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("M04Id.idrefId");
        }
        if (idrefId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M04Id m04Id = M04Id.get(idrefId);
            // 子
            m04Id.referM04Idbns();
            map.put("M04Id", m04Id);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
