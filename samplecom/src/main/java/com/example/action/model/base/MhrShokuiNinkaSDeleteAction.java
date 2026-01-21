package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.MhrShokuiNinka;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 認可マスタ一覧削除
 *
 * @author emarfkrow
 */
public class MhrShokuiNinkaSDeleteAction extends BaseAction {

    /** 認可マスタ一覧削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("MhrShokuiNinkaGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                // 主キーが不足していたらエラー
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("BUSHO_ID"))) {
                    throw new OptLockError("error.cant.delete", "認可マスタ");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("SHOKUI_ID"))) {
                    throw new OptLockError("error.cant.delete", "認可マスタ");
                }
                if (jp.co.golorp.emarf.lang.StringUtil.isNullOrWhiteSpace(row.get("KINO_NM"))) {
                    throw new OptLockError("error.cant.delete", "認可マスタ");
                }

                MhrShokuiNinka e = FormValidator.toBean(MhrShokuiNinka.class.getName(), row);
                if (e.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "認可マスタ");
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
