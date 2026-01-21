package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Idref;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * ID参照マスタ照会
 *
 * @author emarfkrow
 */
public class Tb1IdrefGetAction extends BaseAction {

    /** ID参照マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object idrefId = postJson.get("idrefId");
        if (idrefId == null) {
            idrefId = postJson.get("Tb1Idref.idrefId");
        }
        if (idrefId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Idref tb1Idref = Tb1Idref.get(idrefId);
            map.put("Tb1Idref", tb1Idref);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
