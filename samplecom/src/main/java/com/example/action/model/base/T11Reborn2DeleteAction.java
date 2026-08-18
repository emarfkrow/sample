package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T11Reborn2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生２削除
 *
 * @author emarfkrow
 */
public class T11Reborn2DeleteAction extends BaseAction {

    /** 転生２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object reborn2Id = form.get("reborn2Id");
        if (reborn2Id == null) {
            reborn2Id = form.get("T11Reborn2.reborn2Id");
        }
        if (reborn2Id == null) {
            throw new OptLockError("error.cant.delete", "転生２");
        }

        T11Reborn2 e = FormValidator.toBean(T11Reborn2.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "転生２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
