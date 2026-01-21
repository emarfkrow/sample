package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Idbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * ID連番マスタ照会
 *
 * @author emarfkrow
 */
public class Tb1IdbnGetAction extends BaseAction {

    /** ID連番マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("Tb1Idbn.idrefId");
        }
        if (idrefId == null) {
            isAllKey = false;
        }

        Object idbnBn = postJson.get("idbnBn");
        if (idbnBn == null) {
            idbnBn = postJson.get("Tb1Idbn.idbnBn");
        }
        if (idbnBn == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Idbn tb1Idbn = Tb1Idbn.get(idrefId, idbnBn);
            map.put("Tb1Idbn", tb1Idbn);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
