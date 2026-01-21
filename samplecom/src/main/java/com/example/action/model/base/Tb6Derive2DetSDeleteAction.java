package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.Tb6Derive2Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生２明細一覧削除
 *
 * @author emarfkrow
 */
public class Tb6Derive2DetSDeleteAction extends BaseAction {

    /** 派生２明細一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("Tb6Derive2DetGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("DERIVE2_ID"))) {
                    throw new OptLockError("error.cant.delete", "派生２明細");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("DERIVE2_BN"))) {
                    throw new OptLockError("error.cant.delete", "派生２明細");
                }

                Tb6Derive2Det e = FormValidator.toBean(Tb6Derive2Det.class.getName(), row);
                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "派生２明細");
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
