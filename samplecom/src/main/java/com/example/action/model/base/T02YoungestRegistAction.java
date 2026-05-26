package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Youngest;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 末弟登録
 *
 * @author emarfkrow
 */
public class T02YoungestRegistAction extends BaseAction {

    /** 末弟登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        T02Youngest e = FormValidator.toBean(T02Youngest.class.getName(), postJson);

        if (e.isNew()) {

            if (e.insert(now, execId) != 1) {
                throw new OptLockError("error.cant.insert", "末弟");
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(now, execId) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(now, execId) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "末弟");
            }
        }

        return map;
    }

}
