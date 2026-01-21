package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.Tb0Entity;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * エンティティ一覧承認
 *
 * @author emarfkrow
 */
public class Tb0EntitySForbidAction extends BaseAction {

    /** エンティティ一覧承認処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("Tb0EntityGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                Tb0Entity e = FormValidator.toBean(Tb0Entity.class.getName(), row);

                // 主キーが不足していたらエラー
                Object entityId = e.getEntityId();
                if (entityId == null) {
                    throw new OptLockError("error.cant.forbid", "エンティティ");
                }

                Tb0Entity f = Tb0Entity.get(entityId);
                f.setStatusKb(-1);
                if (f.update(now, execId) != 1) {
                    throw new OptLockError("error.cant.forbid", "エンティティ");
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
