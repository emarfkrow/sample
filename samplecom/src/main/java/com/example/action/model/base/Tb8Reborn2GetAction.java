package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Reborn2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 転生２照会
 *
 * @author emarfkrow
 */
public class Tb8Reborn2GetAction extends BaseAction {

    /** 転生２照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object reborn2Id = postJson.get("reborn2Id");
        if (reborn2Id == null) {
            reborn2Id = postJson.get("Tb8Reborn2.reborn2Id");
        }
        if (reborn2Id == null) {

            Tb8Reborn2 tb8Reborn2 = new Tb8Reborn2();

            // 転生先になる場合は転生元から情報をコピー
            Object tasho2Id1 = postJson.get("tasho2Id");
            if (tasho2Id1 == null) {
                tasho2Id1 = postJson.get("Tb8Reborn2.tasho2Id");
            }
            if (tasho2Id1 != null) {
                com.example.entity.Tb8Tasho2 tb8Tasho2 = com.example.entity.Tb8Tasho2.get(tasho2Id1);
                tb8Reborn2.setTasho2Id(tb8Tasho2.getTasho2Id());
            }

            map.put("Tb8Reborn2", tb8Reborn2);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb8Reborn2 tb8Reborn2 = Tb8Reborn2.get(reborn2Id);
            map.put("Tb8Reborn2", tb8Reborn2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
