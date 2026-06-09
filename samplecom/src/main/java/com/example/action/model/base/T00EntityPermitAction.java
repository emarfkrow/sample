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
 * エンティティ承認
 *
 * @author emarfkrow
 */
public class T00EntityPermitAction extends BaseAction {

    /** エンティティ承認処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object entityId = postJson.get("entityId");
        if (entityId == null) {
            entityId = postJson.get("T00Entity.entityId");
        }
        if (entityId == null) {
            throw new OptLockError("error.cant.permit", "エンティティ");
        }

        T00Entity e = FormValidator.toBean(T00Entity.class.getName(), postJson);

        if (!e.getStatusKb().equals("0")) {
            throw new jp.co.golorp.emarf.exception.AppError("error.notmatch", Messages.get("T00Entity.statusKb"), Messages.get("common.applied"));
        }
        e.setStatusKb(1);
        if (e.update(now, execId) != 1) {
            throw new OptLockError("error.cant.permit", "エンティティ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.permit"));
        return map;
    }

}
