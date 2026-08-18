package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T08Kyosei;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 共生削除
 *
 * @author emarfkrow
 */
public class T08KyoseiDeleteAction extends BaseAction {

    /** 共生削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object kyoseiId = form.get("kyoseiId");
        if (kyoseiId == null) {
            kyoseiId = form.get("T08Kyosei.kyoseiId");
        }
        if (kyoseiId == null) {
            throw new OptLockError("error.cant.delete", "共生");
        }

        T08Kyosei e = FormValidator.toBean(T08Kyosei.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "共生");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
