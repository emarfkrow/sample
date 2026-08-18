package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T08Kisei1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 寄生１削除
 *
 * @author emarfkrow
 */
public class T08Kisei1DeleteAction extends BaseAction {

    /** 寄生１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kisei1Id = form.get("kisei1Id");
        if (kisei1Id == null) {
            kisei1Id = form.get("T08Kisei1.kisei1Id");
        }
        if (kisei1Id == null) {
            throw new OptLockError("error.cant.delete", "寄生１");
        }

        T08Kisei1 e = FormValidator.toBean(T08Kisei1.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "寄生１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
