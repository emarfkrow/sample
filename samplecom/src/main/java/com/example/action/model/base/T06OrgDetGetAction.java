package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06OrgDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T06_ORG_DET照会
 *
 * @author emarfkrow
 */
public class T06OrgDetGetAction extends BaseAction {

    /** T06_ORG_DET照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object orgId = postJson.get("orgId");
        if (orgId == null) {
            orgId = postJson.get("T06OrgDet.orgId");
        }
        if (orgId == null) {
            isAllKey = false;
        }

        Object orgBn = postJson.get("orgBn");
        if (orgBn == null) {
            orgBn = postJson.get("T06OrgDet.orgBn");
        }
        if (orgBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T06Org t06Org = com.example.entity.T06Org.get(orgId);
            map.put("T06Org", t06Org);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06OrgDet t06OrgDet = T06OrgDet.get(orgId, orgBn);
            map.put("T06OrgDet", t06OrgDet);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
