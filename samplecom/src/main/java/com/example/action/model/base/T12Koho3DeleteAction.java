package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T12Koho3;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 候補３削除
 *
 * @author emarfkrow
 */
public class T12Koho3DeleteAction extends BaseAction {

    /** 候補３削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object koho3Id = form.get("koho3Id");
        if (koho3Id == null) {
            koho3Id = form.get("T12Koho3.koho3Id");
        }
        if (koho3Id == null) {
            throw new OptLockError("error.cant.delete", "候補３");
        }

        T12Koho3 e = FormValidator.toBean(T12Koho3.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "候補３");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
