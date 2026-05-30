package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00StatusKb;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 決裁フロー照会
 *
 * @author emarfkrow
 */
public class T00StatusKbGetAction extends BaseAction {

    /** 決裁フロー照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object flowId = postJson.get("flowId");
        if (flowId == null) {
            flowId = postJson.get("T00StatusKb.flowId");
        }
        if (flowId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T00StatusKb t00StatusKb = T00StatusKb.get(flowId);
            map.put("T00StatusKb", t00StatusKb);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
