package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb5Merge;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 統合照会
 *
 * @author emarfkrow
 */
public class Tb5MergeGetAction extends BaseAction {

    /** 統合照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object mergeId = postJson.get("mergeId");
        if (mergeId == null) {
            mergeId = postJson.get("Tb5Merge.mergeId");
        }
        if (mergeId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb5Merge tb5Merge = Tb5Merge.get(mergeId);
            map.put("Tb5Merge", tb5Merge);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
