package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5PrevDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 前世明細照会
 *
 * @author emarfkrow
 */
public class Tb5PrevDetGetAction extends BaseAction {

    /** 前世明細照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prevId = postJson.get("prevId");
        if (prevId == null) {
            prevId = postJson.get("Tb5PrevDet.prevId");
        }
        if (prevId == null) {
            isAllKey = false;
        }

        Object prevBn = postJson.get("prevBn");
        if (prevBn == null) {
            prevBn = postJson.get("Tb5PrevDet.prevBn");
        }
        if (prevBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.Tb5Prev tb5Prev = com.example.entity.Tb5Prev.get(prevId);
        map.put("Tb5Prev", tb5Prev);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb5PrevDet tb5PrevDet = Tb5PrevDet.get(prevId, prevBn);
            map.put("Tb5PrevDet", tb5PrevDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
