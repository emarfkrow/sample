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
 * 寄生１登録
 *
 * @author emarfkrow
 */
public class T08Kisei1RegistAction extends BaseAction {

    /** 寄生１登録処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        Map<String, Object> map = new HashMap<String, Object>();

        T08Kisei1 e = FormValidator.toBean(T08Kisei1.class.getName(), postJson);

        if (e.isNew()) {

            if (e.insert(now, execId) != 1) {
                throw new OptLockError("error.cant.insert", "寄生１");
            }

            map.put("INFO", Messages.get("info.insert"));

        } else {

            if (e.update(now, execId) == 1) {
                map.put("INFO", Messages.get("info.update"));
            } else if (e.insert(now, execId) == 1) {
                map.put("INFO", Messages.get("info.insert"));
            } else {
                throw new OptLockError("error.cant.update", "寄生１");
            }
        }

        return map;
    }

}
