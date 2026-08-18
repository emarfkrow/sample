package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T14Koutei;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 工程登録
 *
 * @author emarfkrow
 */
public class T14KouteiRegistAction extends BaseAction {

    /** 工程登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        Map<String, Object> map = new HashMap<String, Object>();

        T14Koutei e = FormValidator.toBean(T14Koutei.class.getName(), form);

        if (e.isNew()) {

            if (e.insert(at, by) != 1) {
                throw new OptLockError("error.cant.insert", "工程");
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(at, by) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(at, by) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "工程");
            }
        }

        return map;
    }

}
