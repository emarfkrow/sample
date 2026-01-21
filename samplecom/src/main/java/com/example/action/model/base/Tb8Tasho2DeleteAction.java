package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.Tb8Tasho2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 他生２削除
 *
 * @author emarfkrow
 */
public class Tb8Tasho2DeleteAction extends BaseAction {

    /** 他生２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object tasho2Id = postJson.get("tasho2Id");
        if (tasho2Id == null) {
            tasho2Id = postJson.get("Tb8Tasho2.tasho2Id");
        }
        if (tasho2Id == null) {
            throw new OptLockError("error.cant.delete", "他生２");
        }

        Tb8Tasho2 e = FormValidator.toBean(Tb8Tasho2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "他生２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
