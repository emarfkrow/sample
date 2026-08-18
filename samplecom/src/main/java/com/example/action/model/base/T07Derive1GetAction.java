package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T07_DERIVE1照会
 *
 * @author emarfkrow
 */
public class T07Derive1GetAction extends BaseAction {

    /** T07_DERIVE1照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive1Id = form.get("derive1Id");
        if (derive1Id == null) {
            derive1Id = form.get("T07Derive1.derive1Id");
        }
        if (derive1Id == null) {

            T07Derive1 t07Derive1 = new T07Derive1();

            // 派生先になる場合は派生元から情報をコピー
            Object orgId1 = form.get("orgId");
            if (orgId1 == null) {
                orgId1 = form.get("T07Derive1.orgId");
            }
            if (orgId1 != null) {
                com.example.entity.T07Org t07Org = com.example.entity.T07Org.get(orgId1);
                t07Derive1.setOrgId(t07Org.getOrgId());
                t07Derive1.setOrgInfo(t07Org.getOrgInfo());
                t07Org.referT07OrgDets();
                t07Derive1.setT07Derive1Dets(new java.util.ArrayList<com.example.entity.T07Derive1Det>());
                for (com.example.entity.T07OrgDet t07OrgDet : t07Org.referT07OrgDets()) {
                    com.example.entity.T07Derive1Det t07Derive1Det = new com.example.entity.T07Derive1Det();
                    t07Derive1Det.setId(t07OrgDet.getId());
                    t07Derive1Det.setDetInfo(t07OrgDet.getDetInfo());
                    t07Derive1.getT07Derive1Dets().add(t07Derive1Det);
                }

            }

            map.put("T07Derive1", t07Derive1);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07Derive1 t07Derive1 = T07Derive1.get(derive1Id);
            // 子
            t07Derive1.referT07Derive1Dets();
            map.put("T07Derive1", t07Derive1);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
