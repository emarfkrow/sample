package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Unit3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 単位３照会
 *
 * @author emarfkrow
 */
public class Tb8Unit3GetAction extends BaseAction {

    /** 単位３照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object unit3Id = postJson.get("unit3Id");
        if (unit3Id == null) {
            unit3Id = postJson.get("Tb8Unit3.unit3Id");
        }
        if (unit3Id == null) {

            Tb8Unit3 tb8Unit3 = new Tb8Unit3();

            // 派生先になる場合は派生元から情報をコピー
            Object sum2Id1 = postJson.get("sum2Id");
            if (sum2Id1 == null) {
                sum2Id1 = postJson.get("Tb8Unit3.sum2Id");
            }
            if (sum2Id1 != null) {
                com.example.entity.Tb8Sum2 tb8Sum2 = com.example.entity.Tb8Sum2.get(sum2Id1);
                tb8Unit3.setSum2Id(tb8Sum2.getSum2Id());
            }

            map.put("Tb8Unit3", tb8Unit3);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb8Unit3 tb8Unit3 = Tb8Unit3.get(unit3Id);
            map.put("Tb8Unit3", tb8Unit3);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
