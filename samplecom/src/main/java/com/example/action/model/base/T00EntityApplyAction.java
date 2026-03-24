package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Entity;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * エンティティ申請
 *
 * @author emarfkrow
 */
public class T00EntityApplyAction extends BaseAction {

    /** エンティティ申請処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object entityId = postJson.get("entityId");
        if (entityId == null) {
            entityId = postJson.get("T00Entity.entityId");
        }
        if (entityId == null) {
            throw new OptLockError("error.cant.apply", "エンティティ");
        }

        T00Entity e = FormValidator.toBean(T00Entity.class.getName(), postJson);

        T00Entity f = T00Entity.get(e.getEntityId());
        f.setStatusKb(0);
        if (f.update(now, execId) != 1) {
            throw new OptLockError("error.cant.apply", "エンティティ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.apply"));
        return map;
    }

}
