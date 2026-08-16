package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06RebornDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T06_REBORN_DET照会
 *
 * @author emarfkrow
 */
public class T06RebornDetGetAction extends BaseAction {

    /** T06_REBORN_DET照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("T06RebornDet.rebornId");
        }
        if (rebornId == null) {
            isAllKey = false;
        }

        Object rebornBn = postJson.get("rebornBn");
        if (rebornBn == null) {
            rebornBn = postJson.get("T06RebornDet.rebornBn");
        }
        if (rebornBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T06Reborn t06Reborn = com.example.entity.T06Reborn.get(rebornId);
            map.put("T06Reborn", t06Reborn);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06RebornDet t06RebornDet = T06RebornDet.get(rebornId, rebornBn);
            map.put("T06RebornDet", t06RebornDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
