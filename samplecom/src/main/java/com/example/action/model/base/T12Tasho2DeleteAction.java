package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T12Tasho2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 他生２削除
 *
 * @author emarfkrow
 */
public class T12Tasho2DeleteAction extends BaseAction {

    /** 他生２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object tasho2Id = form.get("tasho2Id");
        if (tasho2Id == null) {
            tasho2Id = form.get("T12Tasho2.tasho2Id");
        }
        if (tasho2Id == null) {
            throw new OptLockError("error.cant.delete", "他生２");
        }

        T12Tasho2 e = FormValidator.toBean(T12Tasho2.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "他生２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
