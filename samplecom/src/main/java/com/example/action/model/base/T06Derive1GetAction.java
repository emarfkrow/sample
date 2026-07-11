package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Derive1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T06_DERIVE1照会
 *
 * @author emarfkrow
 */
public class T06Derive1GetAction extends BaseAction {

    /** T06_DERIVE1照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive1Id = postJson.get("derive1Id");
        if (derive1Id == null) {
            derive1Id = postJson.get("T06Derive1.derive1Id");
        }
        if (derive1Id == null) {

            T06Derive1 t06Derive1 = new T06Derive1();

            // 派生先になる場合は派生元から情報をコピー
            Object orgId1 = postJson.get("orgId");
            if (orgId1 == null) {
                orgId1 = postJson.get("T06Derive1.orgId");
            }
            if (orgId1 != null) {
                com.example.entity.T06Org t06Org = com.example.entity.T06Org.get(orgId1);
                t06Derive1.setOrgId(t06Org.getOrgId());
                t06Derive1.setOrgInfo(t06Org.getOrgInfo());
                t06Org.referT06OrgDets();
                t06Derive1.setT06Derive1Dets(new java.util.ArrayList<com.example.entity.T06Derive1Det>());
                for (com.example.entity.T06OrgDet t06OrgDet : t06Org.referT06OrgDets()) {
                    com.example.entity.T06Derive1Det t06Derive1Det = new com.example.entity.T06Derive1Det();
                    t06Derive1Det.setId(t06OrgDet.getId());
                    t06Derive1Det.setDetInfo(t06OrgDet.getDetInfo());
                    t06Derive1.getT06Derive1Dets().add(t06Derive1Det);
                }

            }

            map.put("T06Derive1", t06Derive1);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06Derive1 t06Derive1 = T06Derive1.get(derive1Id);
            // 子
            t06Derive1.referT06Derive1Dets();
            map.put("T06Derive1", t06Derive1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
