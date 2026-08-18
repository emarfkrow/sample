package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T06PrevDet;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 前世明細削除
 *
 * @author emarfkrow
 */
public class T06PrevDetDeleteAction extends BaseAction {

    /** 前世明細削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object prevId = form.get("prevId");
        if (prevId == null) {
            prevId = form.get("T06PrevDet.prevId");
        }
        if (prevId == null) {
            throw new OptLockError("error.cant.delete", "前世明細");
        }
        Object prevBn = form.get("prevBn");
        if (prevBn == null) {
            prevBn = form.get("T06PrevDet.prevBn");
        }
        if (prevBn == null) {
            throw new OptLockError("error.cant.delete", "前世明細");
        }

        T06PrevDet e = FormValidator.toBean(T06PrevDet.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "前世明細");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
