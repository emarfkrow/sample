package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T03Trans;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 変遷申請
 *
 * @author emarfkrow
 */
public class T03TransApplyAction extends BaseAction {

    /** 変遷申請処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object transId = form.get("transId");
        if (transId == null) {
            transId = form.get("T03Trans.transId");
        }
        if (transId == null) {
            throw new OptLockError("error.cant.apply", "変遷");
        }

        T03Trans e = FormValidator.toBean(T03Trans.class.getName(), form);

        if (e.getStatusKb() != null && !e.getStatusKb().equals("")) {
            throw new jp.co.golorp.emarf.exception.AppError("error.notmatch",
                    Messages.get("T03Trans.statusKb"), Messages.get("common.notapply"));
        }
        e.setStatusKb(0);
        if (e.update(at, by) != 1) {
            throw new OptLockError("error.cant.apply", "変遷");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.apply"));
        return map;
    }

}
