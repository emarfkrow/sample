package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Prev2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 前世２削除
 *
 * @author emarfkrow
 */
public class Tb8Prev2DeleteAction extends BaseAction {

    /** 前世２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object prev2Id = postJson.get("prev2Id");
        if (prev2Id == null) {
            prev2Id = postJson.get("Tb8Prev2.prev2Id");
        }
        if (prev2Id == null) {
            throw new OptLockError("error.cant.delete", "前世２");
        }

        Tb8Prev2 e = FormValidator.toBean(Tb8Prev2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "前世２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
