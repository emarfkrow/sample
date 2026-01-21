package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Derive2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.NoDataError;

/**
 * 派生２照会
 *
 * @author emarfkrow
 */
public class Tb6Derive2GetAction extends BaseAction {

    /** 派生２照会処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        // 主キーのチェック
        boolean isAllKey = true;

        Object derive2Id = postJson.get("derive2Id");
        if (derive2Id == null) {
            derive2Id = postJson.get("Tb6Derive2.derive2Id");
        }
        if (derive2Id == null) {

            Tb6Derive2 tb6Derive2 = new Tb6Derive2();

            // 派生先になる場合は派生元から情報をコピー
            Object orgId1 = postJson.get("orgId");
            if (orgId1 == null) {
                orgId1 = postJson.get("Tb6Derive2.orgId");
            }
            if (orgId1 != null) {
                com.example.entity.Tb6Org tb6Org = com.example.entity.Tb6Org.get(orgId1);
                tb6Derive2.setOrgId(tb6Org.getOrgId());
                tb6Derive2.setOrgInfo(tb6Org.getOrgInfo());
                tb6Org.referTb6OrgDets();
                tb6Derive2.setTb6Derive2Dets(new java.util.ArrayList<com.example.entity.Tb6Derive2Det>());
                for (com.example.entity.Tb6OrgDet tb6OrgDet : tb6Org.referTb6OrgDets()) {
                    com.example.entity.Tb6Derive2Det tb6Derive2Det = new com.example.entity.Tb6Derive2Det();
                    tb6Derive2Det.setId(tb6OrgDet.getId());
                    tb6Derive2Det.setOrgDetInfo(tb6OrgDet.getOrgDetInfo());
                    tb6Derive2.getTb6Derive2Dets().add(tb6Derive2Det);
                }

            }

            map.put("Tb6Derive2", tb6Derive2);
            isAllKey = false;
        }

        // 主キーが不足していたら終了
        if (!isAllKey) {
            return map;
        }

        try {
            Tb6Derive2 tb6Derive2 = Tb6Derive2.get(derive2Id);
            // 子
            tb6Derive2.referTb6Derive2Dets();
            map.put("Tb6Derive2", tb6Derive2);
        } catch (NoDataError e) {
            if (postJson.get("IsSilent") == null || !postJson.get("IsSilent").equals("true")) {
                throw e;
            }
        }

        return map;
    }

}
