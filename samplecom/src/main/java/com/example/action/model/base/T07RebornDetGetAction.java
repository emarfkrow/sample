package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07RebornDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 転生明細照会
 *
 * @author emarfkrow
 */
public class T07RebornDetGetAction extends BaseAction {

    /** 転生明細照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("T07RebornDet.rebornId");
        }
        if (rebornId == null) {
            isAllKey = false;
        }

        Object rebornBn = postJson.get("rebornBn");
        if (rebornBn == null) {
            rebornBn = postJson.get("T07RebornDet.rebornBn");
        }
        if (rebornBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T07Reborn t07Reborn = com.example.entity.T07Reborn.get(rebornId);
            map.put("T07Reborn", t07Reborn);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07RebornDet t07RebornDet = T07RebornDet.get(rebornId, rebornBn);
            map.put("T07RebornDet", t07RebornDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
