package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5RebornDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 転生明細照会
 *
 * @author emarfkrow
 */
public class Tb5RebornDetGetAction extends BaseAction {

    /** 転生明細照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("Tb5RebornDet.rebornId");
        }
        if (rebornId == null) {
            isAllKey = false;
        }

        Object rebornBn = postJson.get("rebornBn");
        if (rebornBn == null) {
            rebornBn = postJson.get("Tb5RebornDet.rebornBn");
        }
        if (rebornBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.Tb5Reborn tb5Reborn = com.example.entity.Tb5Reborn.get(rebornId);
        map.put("Tb5Reborn", tb5Reborn);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb5RebornDet tb5RebornDet = Tb5RebornDet.get(rebornId, rebornBn);
            map.put("Tb5RebornDet", tb5RebornDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
