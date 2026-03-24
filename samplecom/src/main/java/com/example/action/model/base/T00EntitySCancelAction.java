package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.entity.T00Entity;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * エンティティ一覧取消
 *
 * @author emarfkrow
 */
public class T00EntitySCancelAction extends BaseAction {

    /** エンティティ一覧取消処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        int count = 0;

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> data = (List<Map<String, Object>>) form.get("T00EntityGrid");
        if (data != null) {
            for (Map<String, Object> row : data) {

                if (row.isEmpty()) {
                    continue;
                }

                T00Entity e = FormValidator.toBean(T00Entity.class.getName(), row);

                // 主キーが不足していたらエラー
                Object entityId = e.getEntityId();
                if (entityId == null) {
                    throw new OptLockError("error.cant.cancel", "エンティティ");
                }

                T00Entity f = T00Entity.get(entityId);
                f.setStatusKb(null);
                if (f.update(now, execId) != 1) {
                    throw new OptLockError("error.cant.cancel", "エンティティ");
                }
                ++count;
            }
        }

        if (count == 0) {
            map.put("ERROR", Messages.get("error.nopost"));
            return map;
        }

        map.put("INFO", Messages.get("info.cancel"));
        return map;
    }

}
