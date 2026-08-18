package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T07Derive1Det;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 派生１明細削除
 *
 * @author emarfkrow
 */
public class T07Derive1DetDeleteAction extends BaseAction {

    /** 派生１明細削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object derive1Id = form.get("derive1Id");
        if (derive1Id == null) {
            derive1Id = form.get("T07Derive1Det.derive1Id");
        }
        if (derive1Id == null) {
            throw new OptLockError("error.cant.delete", "派生１明細");
        }
        Object derive1Bn = form.get("derive1Bn");
        if (derive1Bn == null) {
            derive1Bn = form.get("T07Derive1Det.derive1Bn");
        }
        if (derive1Bn == null) {
            throw new OptLockError("error.cant.delete", "派生１明細");
        }

        T07Derive1Det e = FormValidator.toBean(T07Derive1Det.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "派生１明細");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
