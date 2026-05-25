package com.example.action.D0000;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.entity.T01Ko;
import com.example.entity.T01Mago;
import com.example.entity.T01Oya;

import jp.co.golorp.emarf.action.BaseAction;
import jp.co.golorp.emarf.exception.AppError;
import jp.co.golorp.emarf.util.Messages;
import jp.co.golorp.emarf.validation.FormValidator;

/**
 * 詳細画面登録アクション
 * @author toshiyuki
 *
 */
public class D0002RegistAction extends BaseAction {

    /**
     *
     */
    @Override
    public Map<String, Object> running(final LocalDateTime now, final String id, final Map<String, Object> postJson) {

        T01Mago mago = FormValidator.toBean(T01Mago.class.getName(), postJson);
        if (!mago.isEmpty()) {
            if (mago.getUpdateTs() == null) {
                if (mago.insert(now, id) != 1) {
                    throw new AppError("error.cant.insert");
                }
            } else {
                if (mago.update(now, id) != 1) {
                    throw new AppError("error.cant.update");
                }
            }
        }

        T01Ko ko = FormValidator.toBean(T01Ko.class.getName(), postJson);
        if (!ko.isEmpty()) {
            if (ko.getUpdateTs() == null) {
                if (ko.insert(now, id) != 1) {
                    throw new AppError("error.cant.insert");
                }
            } else {
                if (ko.update(now, id) != 1) {
                    throw new AppError("error.cant.update");
                }
            }
        }

        T01Oya oya = FormValidator.toBean(T01Oya.class.getName(), postJson);
        if (oya.update(now, id) != 1) {
            throw new AppError("error.cant.update");
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("INFO", Messages.get("info.update"));
        return map;
    }

}
