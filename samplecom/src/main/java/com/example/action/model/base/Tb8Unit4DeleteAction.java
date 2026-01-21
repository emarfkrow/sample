package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Unit4;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 単位４削除
 *
 * @author emarfkrow
 */
public class Tb8Unit4DeleteAction extends BaseAction {

    /** 単位４削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object unit4Id = postJson.get("unit4Id");
        if (unit4Id == null) {
            unit4Id = postJson.get("Tb8Unit4.unit4Id");
        }
        if (unit4Id == null) {
            throw new OptLockError("error.cant.delete", "単位４");
        }

        Tb8Unit4 e = FormValidator.toBean(Tb8Unit4.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "単位４");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
