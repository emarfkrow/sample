package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T06Reborn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生一覧削除
 *
 * @author emarfkrow
 */
public class T06RebornSDeleteAction extends BaseAction {

    /** 転生一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T06RebornGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("REBORN_ID"))) {
                    throw new OptLockError("error.cant.delete", "転生");
                }

                T06Reborn e = FormValidator.toBean(T06Reborn.class.getName(), row);

                java.util.List<com.example.entity.T06RebornDet> t06RebornDets = e.referT06RebornDets();
                if (t06RebornDets != null) {
                    for (com.example.entity.T06RebornDet t06RebornDet : t06RebornDets) {

                        if (t06RebornDet.delete() != 1) {
                            throw new OptLockError("error.cant.delete", "転生明細");
                        }
                    }
                }

                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "転生");
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
