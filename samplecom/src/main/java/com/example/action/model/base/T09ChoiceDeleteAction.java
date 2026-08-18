package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T09Choice;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 選択削除
 *
 * @author emarfkrow
 */
public class T09ChoiceDeleteAction extends BaseAction {

    /** 選択削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object choiceId = form.get("choiceId");
        if (choiceId == null) {
            choiceId = form.get("T09Choice.choiceId");
        }
        if (choiceId == null) {
            throw new OptLockError("error.cant.delete", "選択");
        }

        T09Choice e = FormValidator.toBean(T09Choice.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "選択");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
