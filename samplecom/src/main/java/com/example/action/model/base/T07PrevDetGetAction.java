package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07PrevDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T07_PREV_DET照会
 *
 * @author emarfkrow
 */
public class T07PrevDetGetAction extends BaseAction {

    /** T07_PREV_DET照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prevId = postJson.get("prevId");
        if (prevId == null) {
            prevId = postJson.get("T07PrevDet.prevId");
        }
        if (prevId == null) {
            isAllKey = false;
        }

        Object prevBn = postJson.get("prevBn");
        if (prevBn == null) {
            prevBn = postJson.get("T07PrevDet.prevBn");
        }
        if (prevBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T07Prev t07Prev = com.example.entity.T07Prev.get(prevId);
            map.put("T07Prev", t07Prev);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07PrevDet t07PrevDet = T07PrevDet.get(prevId, prevBn);
            map.put("T07PrevDet", t07PrevDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
