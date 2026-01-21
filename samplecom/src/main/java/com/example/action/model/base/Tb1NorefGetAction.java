package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Noref;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * NO参照マスタ照会
 *
 * @author emarfkrow
 */
public class Tb1NorefGetAction extends BaseAction {

    /** NO参照マスタ照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object norefNo = postJson.get("norefNo");
        if (norefNo == null) {
            norefNo = postJson.get("Tb1Noref.norefNo");
        }
        if (norefNo == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Noref tb1Noref = Tb1Noref.get(norefNo);
            map.put("Tb1Noref", tb1Noref);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
