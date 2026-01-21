package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Tasho2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 他生２照会
 *
 * @author emarfkrow
 */
public class Tb8Tasho2GetAction extends BaseAction {

    /** 他生２照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object tasho2Id = postJson.get("tasho2Id");
        if (tasho2Id == null) {
            tasho2Id = postJson.get("Tb8Tasho2.tasho2Id");
        }
        if (tasho2Id == null) {

            Tb8Tasho2 tb8Tasho2 = new Tb8Tasho2();

            // 派生先になる場合は派生元から情報をコピー
            Object sum3Id1 = postJson.get("sum3Id");
            if (sum3Id1 == null) {
                sum3Id1 = postJson.get("Tb8Tasho2.sum3Id");
            }
            if (sum3Id1 != null) {
                com.example.entity.Tb8Sum3 tb8Sum3 = com.example.entity.Tb8Sum3.get(sum3Id1);
                tb8Tasho2.setSum3Id(tb8Sum3.getSum3Id());
            }

            map.put("Tb8Tasho2", tb8Tasho2);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb8Tasho2 tb8Tasho2 = Tb8Tasho2.get(tasho2Id);
            // 転生先
            tb8Tasho2.referTb8Reborn2s();
            map.put("Tb8Tasho2", tb8Tasho2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
