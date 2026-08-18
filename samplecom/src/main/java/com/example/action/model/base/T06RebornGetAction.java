package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T06_REBORN照会
 *
 * @author emarfkrow
 */
public class T06RebornGetAction extends BaseAction {

    /** T06_REBORN照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object rebornId = form.get("rebornId");
        if (rebornId == null) {
            rebornId = form.get("T06Reborn.rebornId");
        }
        if (rebornId == null) {

            T06Reborn t06Reborn = new T06Reborn();

            // 転生先になる場合は転生元から情報をコピー
            Object prevId1 = form.get("prevId");
            if (prevId1 == null) {
                prevId1 = form.get("T06Reborn.prevId");
            }
            if (prevId1 != null) {
                com.example.entity.T06Prev t06Prev = com.example.entity.T06Prev.get(prevId1);
                t06Reborn.setPrevId(t06Prev.getPrevId());
                t06Reborn.setPrevInfo(t06Prev.getPrevInfo());
                t06Prev.referT06PrevDets();
                t06Reborn.setT06RebornDets(new java.util.ArrayList<com.example.entity.T06RebornDet>());
                for (com.example.entity.T06PrevDet t06PrevDet : t06Prev.referT06PrevDets()) {
                    com.example.entity.T06RebornDet t06RebornDet = new com.example.entity.T06RebornDet();
                    t06RebornDet.setId(t06PrevDet.getId());
                    t06RebornDet.setDetInfo(t06PrevDet.getDetInfo());
                    t06Reborn.getT06RebornDets().add(t06RebornDet);
                }

            }

            map.put("T06Reborn", t06Reborn);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06Reborn t06Reborn = T06Reborn.get(rebornId);
            // 子
            t06Reborn.referT06RebornDets();
            map.put("T06Reborn", t06Reborn);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
