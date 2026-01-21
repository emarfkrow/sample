package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 転生照会
 *
 * @author emarfkrow
 */
public class Tb5RebornGetAction extends BaseAction {

    /** 転生照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object rebornId = postJson.get("rebornId");
        if (rebornId == null) {
            rebornId = postJson.get("Tb5Reborn.rebornId");
        }
        if (rebornId == null) {

            Tb5Reborn tb5Reborn = new Tb5Reborn();

            // 転生先になる場合は転生元から情報をコピー
            Object prevId1 = postJson.get("prevId");
            if (prevId1 == null) {
                prevId1 = postJson.get("Tb5Reborn.prevId");
            }
            if (prevId1 != null) {
                com.example.entity.Tb5Prev tb5Prev = com.example.entity.Tb5Prev.get(prevId1);
                tb5Reborn.setPrevId(tb5Prev.getPrevId());
                tb5Reborn.setPrevInfo(tb5Prev.getPrevInfo());
                tb5Prev.referTb5PrevDets();
                tb5Reborn.setTb5RebornDets(new java.util.ArrayList<com.example.entity.Tb5RebornDet>());
                for (com.example.entity.Tb5PrevDet tb5PrevDet : tb5Prev.referTb5PrevDets()) {
                    com.example.entity.Tb5RebornDet tb5RebornDet = new com.example.entity.Tb5RebornDet();
                    tb5RebornDet.setId(tb5PrevDet.getId());
                    tb5RebornDet.setPrevDetInfo(tb5PrevDet.getPrevDetInfo());
                    tb5Reborn.getTb5RebornDets().add(tb5RebornDet);
                }

            }

            map.put("Tb5Reborn", tb5Reborn);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb5Reborn tb5Reborn = Tb5Reborn.get(rebornId);
            // 子
            tb5Reborn.referTb5RebornDets();
            map.put("Tb5Reborn", tb5Reborn);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
