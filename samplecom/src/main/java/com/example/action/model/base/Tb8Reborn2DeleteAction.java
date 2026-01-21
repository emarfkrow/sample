package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Reborn2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 転生２削除
 *
 * @author emarfkrow
 */
public class Tb8Reborn2DeleteAction extends BaseAction {

    /** 転生２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object reborn2Id = postJson.get("reborn2Id");
        if (reborn2Id == null) {
            reborn2Id = postJson.get("Tb8Reborn2.reborn2Id");
        }
        if (reborn2Id == null) {
            throw new OptLockError("error.cant.delete", "転生２");
        }

        Tb8Reborn2 e = FormValidator.toBean(Tb8Reborn2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "転生２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
