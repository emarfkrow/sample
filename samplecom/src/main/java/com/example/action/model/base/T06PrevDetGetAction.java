package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06PrevDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T06_PREV_DET照会
 *
 * @author emarfkrow
 */
public class T06PrevDetGetAction extends BaseAction {

    /** T06_PREV_DET照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prevId = postJson.get("prevId");
        if (prevId == null) {
            prevId = postJson.get("T06PrevDet.prevId");
        }
        if (prevId == null) {
            isAllKey = false;
        }

        Object prevBn = postJson.get("prevBn");
        if (prevBn == null) {
            prevBn = postJson.get("T06PrevDet.prevBn");
        }
        if (prevBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T06Prev t06Prev = com.example.entity.T06Prev.get(prevId);
            map.put("T06Prev", t06Prev);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06PrevDet t06PrevDet = T06PrevDet.get(prevId, prevBn);
            map.put("T06PrevDet", t06PrevDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
