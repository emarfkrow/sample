package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.M04Idbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * ID連番マスタ照会
 *
 * @author emarfkrow
 */
public class M04IdbnGetAction extends BaseAction {

    /** ID連番マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("M04Idbn.idrefId");
        }
        if (idrefId == null) {
            isAllKey = false;
        }

        Object idbnBn = postJson.get("idbnBn");
        if (idbnBn == null) {
            idbnBn = postJson.get("M04Idbn.idbnBn");
        }
        if (idbnBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.M04Id m04Id = com.example.entity.M04Id.get(idrefId);
        map.put("M04Id", m04Id);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            M04Idbn m04Idbn = M04Idbn.get(idrefId, idbnBn);
            map.put("M04Idbn", m04Idbn);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
