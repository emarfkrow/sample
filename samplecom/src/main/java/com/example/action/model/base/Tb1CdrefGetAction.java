package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Cdref;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * CD参照マスタ照会
 *
 * @author emarfkrow
 */
public class Tb1CdrefGetAction extends BaseAction {

    /** CD参照マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object cdrefCd = postJson.get("cdrefCd");
        if (cdrefCd == null) {
            cdrefCd = postJson.get("Tb1Cdref.cdrefCd");
        }
        if (cdrefCd == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Cdref tb1Cdref = Tb1Cdref.get(cdrefCd);
            map.put("Tb1Cdref", tb1Cdref);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
