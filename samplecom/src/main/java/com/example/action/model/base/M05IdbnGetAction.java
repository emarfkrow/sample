package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M05Idbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * M05_IDBN照会
 *
 * @author emarfkrow
 */
public class M05IdbnGetAction extends BaseAction {

    /** M05_IDBN照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("M05Idbn.idrefId");
        }
        if (idrefId == null) {
            isAllKey = false;
        }

        Object idbnBn = postJson.get("idbnBn");
        if (idbnBn == null) {
            idbnBn = postJson.get("M05Idbn.idbnBn");
        }
        if (idbnBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.M05Id m05Id = com.example.entity.M05Id.get(idrefId);
            map.put("M05Id", m05Id);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M05Idbn m05Idbn = M05Idbn.get(idrefId, idbnBn);
            map.put("M05Idbn", m05Idbn);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
