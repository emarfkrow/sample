package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T11Tasho1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T11_TASHO1照会
 *
 * @author emarfkrow
 */
public class T11Tasho1GetAction extends BaseAction {

    /** T11_TASHO1照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object tasho1Id = postJson.get("tasho1Id");
        if (tasho1Id == null) {
            tasho1Id = postJson.get("T11Tasho1.tasho1Id");
        }
        if (tasho1Id == null) {

            T11Tasho1 t11Tasho1 = new T11Tasho1();

            // 派生先になる場合は派生元から情報をコピー
            Object reborn2Id1 = postJson.get("reborn2Id");
            if (reborn2Id1 == null) {
                reborn2Id1 = postJson.get("T11Tasho1.reborn2Id");
            }
            if (reborn2Id1 != null) {
                com.example.entity.T11Reborn2 t11Reborn2 = com.example.entity.T11Reborn2.get(reborn2Id1);
                t11Tasho1.setReborn2Id(t11Reborn2.getReborn2Id());
            }

            map.put("T11Tasho1", t11Tasho1);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T11Tasho1 t11Tasho1 = T11Tasho1.get(tasho1Id);
            map.put("T11Tasho1", t11Tasho1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
