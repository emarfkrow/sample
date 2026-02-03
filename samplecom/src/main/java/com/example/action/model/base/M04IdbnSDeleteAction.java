package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.M04Idbn;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * ID連番マスタ一覧削除
 *
 * @author emarfkrow
 */
public class M04IdbnSDeleteAction extends BaseAction {

    /** ID連番マスタ一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("M04IdbnGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("IDREF_ID"))) {
                    throw new OptLockError("error.cant.delete", "ID連番マスタ");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("IDBN_BN"))) {
                    throw new OptLockError("error.cant.delete", "ID連番マスタ");
                }

                M04Idbn e = FormValidator.toBean(M04Idbn.class.getName(), row);
                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "ID連番マスタ");
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
