package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T12Koho3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 候補３登録
 *
 * @author emarfkrow
 */
public class T12Koho3RegistAction extends BaseAction {

    /** 候補３登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        T12Koho3 e = FormValidator.toBean(T12Koho3.class.getName(), form);

        if (e.isNew()) {

            if (e.insert(at, by) != 1) {
                throw new OptLockError("error.cant.insert", "候補３");
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(at, by) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(at, by) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "候補３");
            }
        }

        return map;
    }

}
