package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6Org;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 起源削除
 *
 * @author emarfkrow
 */
public class Tb6OrgDeleteAction extends BaseAction {

    /** 起源削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object orgId = postJson.get("orgId");
        if (orgId == null) {
            orgId = postJson.get("Tb6Org.orgId");
        }
        if (orgId == null) {
            throw new OptLockError("error.cant.delete", "起源");
        }

        Tb6Org e = FormValidator.toBean(Tb6Org.class.getName(), postJson);

        java.util.List<com.example.entity.Tb6OrgDet> tb6OrgDets = e.referTb6OrgDets();
        if (tb6OrgDets != null) {
            for (com.example.entity.Tb6OrgDet tb6OrgDet : tb6OrgDets) {

                if (tb6OrgDet.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "起源明細");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "起源");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
