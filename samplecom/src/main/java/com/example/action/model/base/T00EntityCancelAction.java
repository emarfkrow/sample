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
 * エンティティ取消
 *
 * @author emarfkrow
 */
public class T00EntityCancelAction extends BaseAction {

    /** エンティティ取消処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object entityId = form.get("entityId");
        if (entityId == null) {
            entityId = form.get("T00Entity.entityId");
        }
        if (entityId == null) {
            throw new OptLockError("error.cant.cancel", "エンティティ");
        }

        T00Entity e = FormValidator.toBean(T00Entity.class.getName(), form);

        if (!e.getStatusKb().equals("0") && !e.getStatusKb().equals("-1")) {
            throw new jp.co.golorp.emarf.exception.AppError("error.notmatch",
                    Messages.get("T00Entity.statusKb"), Messages.get("common.apply.forbid"));
        }
        e.setStatusKb(null);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.cancel", "エンティティ");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.cancel"));
        return map;
    }

}
