package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb6OrgDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 起源明細削除
 *
 * @author emarfkrow
 */
public class Tb6OrgDetDeleteAction extends BaseAction {

    /** 起源明細削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object orgId = postJson.get("orgId");
        if (orgId == null) {
            orgId = postJson.get("Tb6OrgDet.orgId");
        }
        if (orgId == null) {
            throw new OptLockError("error.cant.delete", "起源明細");
        }
        Object orgBn = postJson.get("orgBn");
        if (orgBn == null) {
            orgBn = postJson.get("Tb6OrgDet.orgBn");
        }
        if (orgBn == null) {
            throw new OptLockError("error.cant.delete", "起源明細");
        }

        Tb6OrgDet e = FormValidator.toBean(Tb6OrgDet.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "起源明細");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
