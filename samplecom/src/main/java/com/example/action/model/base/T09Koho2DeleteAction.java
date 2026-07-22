package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T09Koho2;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 候補２削除
 *
 * @author emarfkrow
 */
public class T09Koho2DeleteAction extends BaseAction {

    /** 候補２削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String execId, final Map<String, Object> postJson) {

        // 主キーが不足していたらエラー
        Object koho2Id = postJson.get("koho2Id");
        if (koho2Id == null) {
            koho2Id = postJson.get("T09Koho2.koho2Id");
        }
        if (koho2Id == null) {
            throw new OptLockError("error.cant.delete", "候補２");
        }

        T09Koho2 e = FormValidator.toBean(T09Koho2.class.getName(), postJson);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "候補２");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
