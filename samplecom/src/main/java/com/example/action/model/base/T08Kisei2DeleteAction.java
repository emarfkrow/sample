package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T08Kisei2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 寄生２削除
 *
 * @author emarfkrow
 */
public class T08Kisei2DeleteAction extends BaseAction {

    /** 寄生２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kisei2Id = form.get("kisei2Id");
        if (kisei2Id == null) {
            kisei2Id = form.get("T08Kisei2.kisei2Id");
        }
        if (kisei2Id == null) {
            throw new OptLockError("error.cant.delete", "寄生２");
        }

        T08Kisei2 e = FormValidator.toBean(T08Kisei2.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "寄生２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
