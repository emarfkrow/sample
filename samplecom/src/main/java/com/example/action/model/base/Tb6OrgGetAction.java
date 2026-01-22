package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Org;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 起源照会
 *
 * @author emarfkrow
 */
public class Tb6OrgGetAction extends BaseAction {

    /** 起源照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object orgId = postJson.get("orgId");
        if (orgId == null) {
            orgId = postJson.get("Tb6Org.orgId");
        }
        if (orgId == null) {
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6Org tb6Org = Tb6Org.get(orgId);
            // 子
            tb6Org.referTb6OrgDets();
            // 集約元
            tb6Org.referTb6Kisei2s();
            map.put("Tb6Org", tb6Org);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
