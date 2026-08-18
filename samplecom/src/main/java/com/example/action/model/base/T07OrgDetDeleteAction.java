package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07OrgDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 起源明細削除
 *
 * @author emarfkrow
 */
public class T07OrgDetDeleteAction extends BaseAction {

    /** 起源明細削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object orgId = form.get("orgId");
        if (orgId == null) {
            orgId = form.get("T07OrgDet.orgId");
        }
        if (orgId == null) {
            throw new OptLockError("error.cant.delete", "起源明細");
        }
        Object orgBn = form.get("orgBn");
        if (orgBn == null) {
            orgBn = form.get("T07OrgDet.orgBn");
        }
        if (orgBn == null) {
            throw new OptLockError("error.cant.delete", "起源明細");
        }

        T07OrgDet e = FormValidator.toBean(T07OrgDet.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "起源明細");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
