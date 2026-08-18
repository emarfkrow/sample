package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * T07_DERIVE2照会
 *
 * @author emarfkrow
 */
public class T07Derive2GetAction extends BaseAction {

    /** T07_DERIVE2照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive2Id = form.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = form.get("T07Derive2.derive2Id");
        }
        if (derive2Id == null) {

            T07Derive2 t07Derive2 = new T07Derive2();

            // 派生先になる場合は派生元から情報をコピー
            Object orgId1 = form.get("orgId");
            if (orgId1 == null) {
                orgId1 = form.get("T07Derive2.orgId");
            }
            if (orgId1 != null) {
                com.example.entity.T07Org t07Org = com.example.entity.T07Org.get(orgId1);
                t07Derive2.setOrgId(t07Org.getOrgId());
                t07Derive2.setOrgInfo(t07Org.getOrgInfo());
                t07Org.referT07OrgDets();
                t07Derive2.setT07Derive2Dets(new java.util.ArrayList<com.example.entity.T07Derive2Det>());
                for (com.example.entity.T07OrgDet t07OrgDet : t07Org.referT07OrgDets()) {
                    com.example.entity.T07Derive2Det t07Derive2Det = new com.example.entity.T07Derive2Det();
                    t07Derive2Det.setId(t07OrgDet.getId());
                    t07Derive2Det.setDetInfo(t07OrgDet.getDetInfo());
                    t07Derive2.getT07Derive2Dets().add(t07Derive2Det);
                }

            }

            map.put("T07Derive2", t07Derive2);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            T07Derive2 t07Derive2 = T07Derive2.get(derive2Id);
            // 子
            t07Derive2.referT07Derive2Dets();
            map.put("T07Derive2", t07Derive2);
        } catch (NoDataError e) {
            if (form.get("IsSilent") == null || !form.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
