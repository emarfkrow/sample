package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T11Reborn2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T11_REBORN2照会
 *
 * @author emarfkrow
 */
public class T11Reborn2GetAction extends BaseAction {

    /** T11_REBORN2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object reborn2Id = postJson.get("reborn2Id");
        if (reborn2Id == null) {
            reborn2Id = postJson.get("T11Reborn2.reborn2Id");
        }
        if (reborn2Id == null) {

            T11Reborn2 t11Reborn2 = new T11Reborn2();

            // 転生先になる場合は転生元から情報をコピー
            Object prev2Id1 = postJson.get("prev2Id");
            if (prev2Id1 == null) {
                prev2Id1 = postJson.get("T11Reborn2.prev2Id");
            }
            if (prev2Id1 != null) {
                com.example.entity.T11Prev2 t11Prev2 = com.example.entity.T11Prev2.get(prev2Id1);
                t11Reborn2.setPrev2Id(t11Prev2.getPrev2Id());
                t11Reborn2.setPrev2Info(t11Prev2.getPrev2Info());
            }

            map.put("T11Reborn2", t11Reborn2);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T11Reborn2 t11Reborn2 = T11Reborn2.get(reborn2Id);
            map.put("T11Reborn2", t11Reborn2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
