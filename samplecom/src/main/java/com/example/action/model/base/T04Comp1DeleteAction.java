package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T04Comp1;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 複合１削除
 *
 * @author emarfkrow
 */
public class T04Comp1DeleteAction extends BaseAction {

    /** 複合１削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object ref1Id = form.get("ref1Id");
        if (ref1Id == null) {
            ref1Id = form.get("T04Comp1.ref1Id");
        }
        if (ref1Id == null) {
            throw new OptLockError("error.cant.delete", "複合１");
        }
        Object ref2Id = form.get("ref2Id");
        if (ref2Id == null) {
            ref2Id = form.get("T04Comp1.ref2Id");
        }
        if (ref2Id == null) {
            throw new OptLockError("error.cant.delete", "複合１");
        }

        T04Comp1 e = FormValidator.toBean(T04Comp1.class.getName(), form);

        java.util.List<com.example.entity.T04Comp2> t04Comp2s = e.referT04Comp2s();
        if (t04Comp2s != null) {
            for (com.example.entity.T04Comp2 t04Comp2 : t04Comp2s) {

                if (t04Comp2.delete() != 1) {
                    throw new OptLockError("error.cant.delete", "複合２");
                }
            }
        }

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "複合１");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
