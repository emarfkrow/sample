package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Prev;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 前世照会
 *
 * @author emarfkrow
 */
public class Tb5PrevGetAction extends BaseAction {

    /** 前世照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object prevId = postJson.get("prevId");
        if (prevId == null) {
            prevId = postJson.get("Tb5Prev.prevId");
        }
        if (prevId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb5Prev tb5Prev = Tb5Prev.get(prevId);
            // 子
            tb5Prev.referTb5PrevDets();
            // 転生先
            tb5Prev.referTb5Reborns();
            // 集約元
            tb5Prev.referTb5Derives();
            map.put("Tb5Prev", tb5Prev);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
