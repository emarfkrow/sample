package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6OrgDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 起源明細照会
 *
 * @author emarfkrow
 */
public class Tb6OrgDetGetAction extends BaseAction {

    /** 起源明細照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object orgId = postJson.get("orgId");
        if (orgId == null) {
            orgId = postJson.get("Tb6OrgDet.orgId");
        }
        if (orgId == null) {
            isAllKey = false;
        }

        Object orgBn = postJson.get("orgBn");
        if (orgBn == null) {
            orgBn = postJson.get("Tb6OrgDet.orgBn");
        }
        if (orgBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        com.example.entity.Tb6Org tb6Org = com.example.entity.Tb6Org.get(orgId);
        map.put("Tb6Org", tb6Org);

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6OrgDet tb6OrgDet = Tb6OrgDet.get(orgId, orgBn);
            map.put("Tb6OrgDet", tb6OrgDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
