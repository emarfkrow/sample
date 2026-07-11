package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06Derive2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T06_DERIVE2照会
 *
 * @author emarfkrow
 */
public class T06Derive2GetAction extends BaseAction {

    /** T06_DERIVE2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive2Id = postJson.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = postJson.get("T06Derive2.derive2Id");
        }
        if (derive2Id == null) {

            T06Derive2 t06Derive2 = new T06Derive2();

            // 派生先になる場合は派生元から情報をコピー
            Object orgId1 = postJson.get("orgId");
            if (orgId1 == null) {
                orgId1 = postJson.get("T06Derive2.orgId");
            }
            if (orgId1 != null) {
                com.example.entity.T06Org t06Org = com.example.entity.T06Org.get(orgId1);
                t06Derive2.setOrgId(t06Org.getOrgId());
                t06Derive2.setOrgInfo(t06Org.getOrgInfo());
                t06Org.referT06OrgDets();
                t06Derive2.setT06Derive2Dets(new java.util.ArrayList<com.example.entity.T06Derive2Det>());
                for (com.example.entity.T06OrgDet t06OrgDet : t06Org.referT06OrgDets()) {
                    com.example.entity.T06Derive2Det t06Derive2Det = new com.example.entity.T06Derive2Det();
                    t06Derive2Det.setId(t06OrgDet.getId());
                    t06Derive2Det.setDetInfo(t06OrgDet.getDetInfo());
                    t06Derive2.getT06Derive2Dets().add(t06Derive2Det);
                }

            }

            map.put("T06Derive2", t06Derive2);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T06Derive2 t06Derive2 = T06Derive2.get(derive2Id);
            // 子
            t06Derive2.referT06Derive2Dets();
            map.put("T06Derive2", t06Derive2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
