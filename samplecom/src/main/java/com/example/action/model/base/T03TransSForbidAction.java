package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T03Trans;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 変遷一覧否認
 *
 * @author emarfkrow
 */
public class T03TransSForbidAction extends BaseAction {

    /** 変遷一覧否認処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T03TransGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                T03Trans e = FormValidator.toBean(T03Trans.class.getName(), row);

                // 主キーが不足していたらエラー
                Object transId = e.getTransId();
                if (transId == null) {
                    throw new OptLockError("error.cant.forbid", "変遷");
                }

                e.setStatusKb(-1);
                if (e.update(now, execId) != 1) {
                    throw new OptLockError("error.cant.forbid", "変遷");
                }
                ++count;
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.forbid"));
        return map;
    }

}
