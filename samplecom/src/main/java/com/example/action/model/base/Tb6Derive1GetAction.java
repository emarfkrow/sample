package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Derive1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 派生１照会
 *
 * @author emarfkrow
 */
public class Tb6Derive1GetAction extends BaseAction {

    /** 派生１照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive1Id = postJson.get("derive1Id");
        if (derive1Id == null) {
            derive1Id = postJson.get("Tb6Derive1.derive1Id");
        }
        if (derive1Id == null) {

            Tb6Derive1 tb6Derive1 = new Tb6Derive1();

            // 派生先になる場合は派生元から情報をコピー
            Object orgId1 = postJson.get("orgId");
            if (orgId1 == null) {
                orgId1 = postJson.get("Tb6Derive1.orgId");
            }
            if (orgId1 != null) {
                com.example.entity.Tb6Org tb6Org = com.example.entity.Tb6Org.get(orgId1);
                tb6Derive1.setOrgId(tb6Org.getOrgId());
                tb6Derive1.setOrgInfo(tb6Org.getOrgInfo());
                tb6Org.referTb6OrgDets();
                tb6Derive1.setTb6Derive1Dets(new java.util.ArrayList<com.example.entity.Tb6Derive1Det>());
                for (com.example.entity.Tb6OrgDet tb6OrgDet : tb6Org.referTb6OrgDets()) {
                    com.example.entity.Tb6Derive1Det tb6Derive1Det = new com.example.entity.Tb6Derive1Det();
                    tb6Derive1Det.setId(tb6OrgDet.getId());
                    tb6Derive1Det.setOrgDetInfo(tb6OrgDet.getOrgDetInfo());
                    tb6Derive1.getTb6Derive1Dets().add(tb6Derive1Det);
                }

            }

            map.put("Tb6Derive1", tb6Derive1);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6Derive1 tb6Derive1 = Tb6Derive1.get(derive1Id);
            // 子
            tb6Derive1.referTb6Derive1Dets();
            map.put("Tb6Derive1", tb6Derive1);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
