package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T07_REBORN照会
 *
 * @author emarfkrow
 */
public class T07RebornGetAction extends BaseAction {

    /** T07_REBORN照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("T07Reborn.rebornId");
        }
        if (rebornId == null) {

            T07Reborn t07Reborn = new T07Reborn();

            // 転生先になる場合は転生元から情報をコピー
            Object prevId1 = postJson.get("prevId");
            if (prevId1 == null) {
                prevId1 = postJson.get("T07Reborn.prevId");
            }
            if (prevId1 != null) {
                com.example.entity.T07Prev t07Prev = com.example.entity.T07Prev.get(prevId1);
                t07Reborn.setPrevId(t07Prev.getPrevId());
                t07Reborn.setPrevInfo(t07Prev.getPrevInfo());
                t07Prev.referT07PrevDets();
                t07Reborn.setT07RebornDets(new java.util.ArrayList<com.example.entity.T07RebornDet>());
                for (com.example.entity.T07PrevDet t07PrevDet : t07Prev.referT07PrevDets()) {
                    com.example.entity.T07RebornDet t07RebornDet = new com.example.entity.T07RebornDet();
                    t07RebornDet.setId(t07PrevDet.getId());
                    t07RebornDet.setDetInfo(t07PrevDet.getDetInfo());
                    t07Reborn.getT07RebornDets().add(t07RebornDet);
                }

            }

            map.put("T07Reborn", t07Reborn);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07Reborn t07Reborn = T07Reborn.get(rebornId);
            // 子
            t07Reborn.referT07RebornDets();
            map.put("T07Reborn", t07Reborn);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
