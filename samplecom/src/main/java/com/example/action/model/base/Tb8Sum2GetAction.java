package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Sum2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 集約２照会
 *
 * @author emarfkrow
 */
public class Tb8Sum2GetAction extends BaseAction {

    /** 集約２照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object sum2Id = postJson.get("sum2Id");
        if (sum2Id == null) {
            sum2Id = postJson.get("Tb8Sum2.sum2Id");
        }
        if (sum2Id == null) {

            Tb8Sum2 tb8Sum2 = new Tb8Sum2();

            // 転生先になる場合は転生元から情報をコピー
            Object prev2Id1 = postJson.get("prev2Id");
            if (prev2Id1 == null) {
                prev2Id1 = postJson.get("Tb8Sum2.prev2Id");
            }
            if (prev2Id1 != null) {
                com.example.entity.Tb8Prev2 tb8Prev2 = com.example.entity.Tb8Prev2.get(prev2Id1);
                tb8Sum2.setPrev2Id(tb8Prev2.getPrev2Id());
            }

            map.put("Tb8Sum2", tb8Sum2);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb8Sum2 tb8Sum2 = Tb8Sum2.get(sum2Id);
            map.put("Tb8Sum2", tb8Sum2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
