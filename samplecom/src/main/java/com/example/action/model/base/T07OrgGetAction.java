package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Org;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T07_ORG照会
 *
 * @author emarfkrow
 */
public class T07OrgGetAction extends BaseAction {

    /** T07_ORG照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object orgId = postJson.get("orgId");
        if (orgId == null) {
            orgId = postJson.get("T07Org.orgId");
        }
        if (orgId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07Org t07Org = T07Org.get(orgId);
            // 子
            t07Org.referT07OrgDets();
            map.put("T07Org", t07Org);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
