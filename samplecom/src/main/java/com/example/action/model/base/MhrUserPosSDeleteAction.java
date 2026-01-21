package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.MhrUserPos;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 所属マスタ一覧削除
 *
 * @author emarfkrow
 */
public class MhrUserPosSDeleteAction extends BaseAction {

    /** 所属マスタ一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("MhrUserPosGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("BUSHO_ID"))) {
                    throw new OptLockError("error.cant.delete", "所属マスタ");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("SHOKUI_ID"))) {
                    throw new OptLockError("error.cant.delete", "所属マスタ");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("USER_ID"))) {
                    throw new OptLockError("error.cant.delete", "所属マスタ");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("TEKIYO_BI"))) {
                    throw new OptLockError("error.cant.delete", "所属マスタ");
                }

                MhrUserPos e = FormValidator.toBean(MhrUserPos.class.getName(), row);
                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "所属マスタ");
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
