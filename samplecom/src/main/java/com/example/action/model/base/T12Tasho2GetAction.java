package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T12Tasho2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T12_TASHO2照会
 *
 * @author emarfkrow
 */
public class T12Tasho2GetAction extends BaseAction {

    /** T12_TASHO2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object tasho2Id = postJson.get("tasho2Id");
        if (tasho2Id == null) {
            tasho2Id = postJson.get("T12Tasho2.tasho2Id");
        }
        if (tasho2Id == null) {

            T12Tasho2 t12Tasho2 = new T12Tasho2();

            // 派生先になる場合は派生元から情報をコピー
            Object koho3Id1 = postJson.get("koho3Id");
            if (koho3Id1 == null) {
                koho3Id1 = postJson.get("T12Tasho2.koho3Id");
            }
            if (koho3Id1 != null) {
                com.example.entity.T12Koho3 t12Koho3 = com.example.entity.T12Koho3.get(koho3Id1);
                t12Tasho2.setKoho3Id(t12Koho3.getKoho3Id());
            }

            map.put("T12Tasho2", t12Tasho2);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T12Tasho2 t12Tasho2 = T12Tasho2.get(tasho2Id);
            // 転生先
            t12Tasho2.referT12Reborn3s();
            map.put("T12Tasho2", t12Tasho2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
