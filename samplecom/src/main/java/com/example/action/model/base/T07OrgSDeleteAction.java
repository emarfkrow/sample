package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T07Org;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 起源一覧削除
 *
 * @author emarfkrow
 */
public class T07OrgSDeleteAction extends BaseAction {

    /** 起源一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T07OrgGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("ORG_ID"))) {
                    throw new OptLockError("error.cant.delete", "起源");
                }

                T07Org e = FormValidator.toBean(T07Org.class.getName(), row);

                java.util.List<com.example.entity.T07OrgDet> t07OrgDets = e.referT07OrgDets();
                if (t07OrgDets != null) {
                    for (com.example.entity.T07OrgDet t07OrgDet : t07OrgDets) {

                        if (t07OrgDet.delete() != 1) {
                            throw new OptLockError("error.cant.delete", "起源明細");
                        }
                    }
                }

                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "起源");
                }
                ++count;
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
