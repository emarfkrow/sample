package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Tasho1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 他生１照会
 *
 * @author emarfkrow
 */
public class Tb8Tasho1GetAction extends BaseAction {

    /** 他生１照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object tasho1Id = postJson.get("tasho1Id");
        if (tasho1Id == null) {
            tasho1Id = postJson.get("Tb8Tasho1.tasho1Id");
        }
        if (tasho1Id == null) {

            Tb8Tasho1 tb8Tasho1 = new Tb8Tasho1();

            // 派生先になる場合は派生元から情報をコピー
            Object sum2Id1 = postJson.get("sum2Id");
            if (sum2Id1 == null) {
                sum2Id1 = postJson.get("Tb8Tasho1.sum2Id");
            }
            if (sum2Id1 != null) {
                com.example.entity.Tb8Sum2 tb8Sum2 = com.example.entity.Tb8Sum2.get(sum2Id1);
                tb8Tasho1.setSum2Id(tb8Sum2.getSum2Id());
            }

            map.put("Tb8Tasho1", tb8Tasho1);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb8Tasho1 tb8Tasho1 = Tb8Tasho1.get(tasho1Id);
            map.put("Tb8Tasho1", tb8Tasho1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
