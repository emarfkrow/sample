package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07OrgDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T07_ORG_DET照会
 *
 * @author emarfkrow
 */
public class T07OrgDetGetAction extends BaseAction {

    /** T07_ORG_DET照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object orgId = form.get("orgId");
        if (orgId == null) {
            orgId = form.get("T07OrgDet.orgId");
        }
        if (orgId == null) {
            isAllKey = false;
        }

        Object orgBn = form.get("orgBn");
        if (orgBn == null) {
            orgBn = form.get("T07OrgDet.orgBn");
        }
        if (orgBn == null) {
            isAllKey = false;
        }

        // 親モデルの取得
        try {
            com.example.entity.T07Org t07Org = com.example.entity.T07Org.get(orgId);
            map.put("T07Org", t07Org);
        } catch (Exception e) {
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07OrgDet t07OrgDet = T07OrgDet.get(orgId, orgBn);
            map.put("T07OrgDet", t07OrgDet);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
