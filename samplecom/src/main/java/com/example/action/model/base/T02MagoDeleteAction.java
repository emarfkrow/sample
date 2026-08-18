package com.example.action.model.base;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T02Mago;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.OptLockError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 孫削除
 *
 * @author emarfkrow
 */
public class T02MagoDeleteAction extends BaseAction {

    /** 孫削除処理 */
    @Override
    public Map<String, Object> running(final LocalDateTime at, final String by, final Map<String, Object> form) {

        // 主キーが不足していたらエラー
        Object oyaId = form.get("oyaId");
        if (oyaId == null) {
            oyaId = form.get("T02Mago.oyaId");
        }
        if (oyaId == null) {
            throw new OptLockError("error.cant.delete", "孫");
        }
        Object koBn = form.get("koBn");
        if (koBn == null) {
            koBn = form.get("T02Mago.koBn");
        }
        if (koBn == null) {
            throw new OptLockError("error.cant.delete", "孫");
        }
        Object magoBn = form.get("magoBn");
        if (magoBn == null) {
            magoBn = form.get("T02Mago.magoBn");
        }
        if (magoBn == null) {
            throw new OptLockError("error.cant.delete", "孫");
        }

        T02Mago e = FormValidator.toBean(T02Mago.class.getName(), form);
        if (e.delete() != 1) {
            throw new OptLockError("error.cant.delete", "孫");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.delete"));
        return map;
    }

}
