package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T12Reborn3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T12_REBORN3照会
 *
 * @author emarfkrow
 */
public class T12Reborn3GetAction extends BaseAction {

    /** T12_REBORN3照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object reborn3Id = postJson.get("reborn3Id");
        if (reborn3Id == null) {
            reborn3Id = postJson.get("T12Reborn3.reborn3Id");
        }
        if (reborn3Id == null) {

            T12Reborn3 t12Reborn3 = new T12Reborn3();

            // 転生先になる場合は転生元から情報をコピー
            Object tasho2Id1 = postJson.get("tasho2Id");
            if (tasho2Id1 == null) {
                tasho2Id1 = postJson.get("T12Reborn3.tasho2Id");
            }
            if (tasho2Id1 != null) {
                com.example.entity.T12Tasho2 t12Tasho2 = com.example.entity.T12Tasho2.get(tasho2Id1);
                t12Reborn3.setTasho2Id(t12Tasho2.getTasho2Id());
            }

            map.put("T12Reborn3", t12Reborn3);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T12Reborn3 t12Reborn3 = T12Reborn3.get(reborn3Id);
            map.put("T12Reborn3", t12Reborn3);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
