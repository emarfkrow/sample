package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb0Entity;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * エンティティ承認
 *
 * @author emarfkrow
 */
public class Tb0EntityPermitAction extends BaseAction {

    /** エンティティ承認処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object entityId = postJson.get("entityId");
        if (entityId == null) {
            entityId = postJson.get("Tb0Entity.entityId");
        }
        if (entityId == null) {
            throw new OptLockError("error.cant.permit", "エンティティ");
        }

        Tb0Entity e = FormValidator.toBean(Tb0Entity.class.getName(), postJson);

        Tb0Entity f = Tb0Entity.get(e.getEntityId());
        f.setStatusKb(1);
        if (f.update(now, execId) != 1) {
            throw new OptLockError("error.cant.permit", "エンティティ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.permit"));
        return map;
    }

}
