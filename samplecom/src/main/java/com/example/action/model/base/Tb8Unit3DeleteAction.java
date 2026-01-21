package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Unit3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 単位３削除
 *
 * @author emarfkrow
 */
public class Tb8Unit3DeleteAction extends BaseAction {

    /** 単位３削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object unit3Id = postJson.get("unit3Id");
        if (unit3Id == null) {
            unit3Id = postJson.get("Tb8Unit3.unit3Id");
        }
        if (unit3Id == null) {
            throw new OptLockError("error.cant.delete", "単位３");
        }

        Tb8Unit3 e = FormValidator.toBean(Tb8Unit3.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "単位３");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
