package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T04Comp2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 複合２登録
 *
 * @author emarfkrow
 */
public class T04Comp2RegistAction extends BaseAction {

    /** 複合２登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        T04Comp2 e = FormValidator.toBean(T04Comp2.class.getName(), form);

        if (e.isNew()) {

            if (e.insert(at, by) != 1) {
                throw new OptLockError("error.cant.insert", "複合２");
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(at, by) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(at, by) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "複合２");
            }
        }

        return map;
    }

}
