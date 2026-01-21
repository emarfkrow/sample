package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb1Saiki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 再帰照会
 *
 * @author emarfkrow
 */
public class Tb1SaikiGetAction extends BaseAction {

    /** 再帰照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object saikiId = postJson.get("saikiId");
        if (saikiId == null) {
            saikiId = postJson.get("Tb1Saiki.saikiId");
        }
        if (saikiId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb1Saiki tb1Saiki = Tb1Saiki.get(saikiId);
            map.put("Tb1Saiki", tb1Saiki);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
