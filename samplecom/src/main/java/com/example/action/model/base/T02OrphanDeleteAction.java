package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Orphan;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 孤児削除
 *
 * @author emarfkrow
 */
public class T02OrphanDeleteAction extends BaseAction {

    /** 孤児削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object oyaId = form.get("oyaId");
        if (oyaId == null) {
            oyaId = form.get("T02Orphan.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.delete", "孤児");
        }
        Object koBn = form.get("koBn");
        if (koBn == null) {
            koBn = form.get("T02Orphan.koBn");
        }
        if (koBn == null) {
            throw new OptLockError("error.cant.delete", "孤児");
        }

        T02Orphan e = FormValidator.toBean(T02Orphan.class.getName(), form);

        // child:T02Mago, parents:2

        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "孤児");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
