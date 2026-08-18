package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T04Comp1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 複合１一覧削除
 *
 * @author emarfkrow
 */
public class T04Comp1SDeleteAction extends BaseAction {

    /** 複合１一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T04Comp1Grid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("REF1_ID"))) {
                    throw new OptLockError("error.cant.delete", "複合１");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("REF2_ID"))) {
                    throw new OptLockError("error.cant.delete", "複合１");
                }

                T04Comp1 e = FormValidator.toBean(T04Comp1.class.getName(), row);

                java.util.List<com.example.entity.T04Comp2> t04Comp2s = e.referT04Comp2s();
                if (t04Comp2s != null) {
                    for (com.example.entity.T04Comp2 t04Comp2 : t04Comp2s) {

                        if (t04Comp2.delete() != 1) {
                            throw new OptLockError("error.cant.delete", "複合２");
                        }
                    }
                }

                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "複合１");
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
