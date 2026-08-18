package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T07Derive1Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生１明細一覧削除
 *
 * @author emarfkrow
 */
public class T07Derive1DetSDeleteAction extends BaseAction {

    /** 派生１明細一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T07Derive1DetGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("DERIVE1_ID"))) {
                    throw new OptLockError("error.cant.delete", "派生１明細");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("DERIVE1_BN"))) {
                    throw new OptLockError("error.cant.delete", "派生１明細");
                }

                T07Derive1Det e = FormValidator.toBean(T07Derive1Det.class.getName(), row);
                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "派生１明細");
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
