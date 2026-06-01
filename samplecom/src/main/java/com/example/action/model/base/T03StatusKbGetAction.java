package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T03StatusKb;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 決裁フロー照会
 *
 * @author emarfkrow
 */
public class T03StatusKbGetAction extends BaseAction {

    /** 決裁フロー照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object flowId = postJson.get("flowId");
        if (flowId == null) {
            flowId = postJson.get("T03StatusKb.flowId");
        }
        if (flowId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T03StatusKb t03StatusKb = T03StatusKb.get(flowId);
            map.put("T03StatusKb", t03StatusKb);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
