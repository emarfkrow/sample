package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T00Jisseki;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 実績登録
 *
 * @author emarfkrow
 */
public class T00JissekiRegistAction extends BaseAction {

    /** 実績登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        T00Jisseki e = FormValidator.toBean(T00Jisseki.class.getName(), postJson);

        if (e.isNew()) {

            if (e.insert(now, execId) != 1) {
                throw new OptLockError("error.cant.insert", "実績");
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(now, execId) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(now, execId) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "実績");
            }
        }

        return map;
    }

}
